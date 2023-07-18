package spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.constant.Defines;
import spring.model.bean.Category;
import spring.model.bean.New;
import spring.model.bean.Project;
import spring.model.dao.ProjectDAO;
import spring.util.FileNameUtil;

@Controller
@RequestMapping("/admin/project")
public class AdminProjectController {

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private ServletContext context;

	@GetMapping("index")
	public String index(ModelMap modelMap) {
		List<Project> listP = projectDAO.getItems();
		modelMap.addAttribute("listP", listP);
		return "aboutme.admin.project.index";
	}

	@GetMapping("add")
	public String add() {
		return "aboutme.admin.project.add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("project") Project project, BindingResult br, RedirectAttributes ra,
			ModelMap modelMap, @RequestParam("picture") CommonsMultipartFile cmf) {
		if (br.hasErrors()) {
			return "aboutme.admin.project.add";
		}
		String fileName = FileNameUtil.rename(cmf.getOriginalFilename());
		project.setHinhanh(fileName);
		if (projectDAO.add(project) > 0) {
			String dirPath = context.getRealPath("") + "WEB-INF" + File.separator + Defines.DIR_UPLOAD; // duong dan thu
																										// muc
			System.out.println(dirPath);

			File file = new File(dirPath);

			if (!file.exists()) {
				file.mkdirs();
			}
			String filePath = dirPath + File.separator + fileName; // duong dan anh
			try {
				cmf.transferTo(new File(filePath));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}

			ra.addFlashAttribute("msg", Defines.MSG_ADD_SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
		}
		return "redirect:/admin/project/index";

	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, ModelMap modelMap) {
		Project project = projectDAO.getItem(id);
		modelMap.addAttribute("project", project);
		return "aboutme.admin.project.edit";
	}

	@PostMapping("edit/{id}")
	public String edit(@Valid @ModelAttribute("project") Project project, BindingResult br,
			@RequestParam("picture") CommonsMultipartFile cmf, ModelMap modelMap, RedirectAttributes ra) {
		Project project2 = projectDAO.getItem(project.getId());
		if (br.hasErrors()) {
			project.setHinhanh(project2.getHinhanh());
			return "aboutme.admin.project.edit";
		}
		String filename = "";
		if ("".equals(cmf.getOriginalFilename())) {
			project.setHinhanh(project2.getHinhanh());
		} else {
			filename = FileNameUtil.rename(cmf.getOriginalFilename());
			project.setHinhanh(filename);
		}
		if (projectDAO.edit(project) > 0) {
			if (!"".equals(filename)) {
				String dirPath = context.getRealPath("") + "WEB-INF" + File.separator + Defines.DIR_UPLOAD;
				System.out.println(dirPath);
				File file = new File(dirPath);
				if (!file.exists()) {
					file.mkdirs();
				}

				// xoa anh cu
				File oldFile = new File(dirPath + File.separator + project.getHinhanh());
				oldFile.delete();

				// them anh moi
				try {
					cmf.transferTo(new File(dirPath + File.separator + filename));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}

			}
			ra.addFlashAttribute("msg", Defines.MSG_UPDATE_SUCCESS);
			return "redirect:/admin/project/index";
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_UPDATE_SUCCESS);
			return "redirect:/admin/project/index";
		}
	}

	@GetMapping("del/{id}")
	public String del(@PathVariable int id, RedirectAttributes ra) {
		Project project = projectDAO.getItem(id);
		if (projectDAO.del(id) > 0) {
			File file = new File(context.getRealPath("") + "WEB-INF" + File.separator + Defines.DIR_UPLOAD
					+ File.separator + project.getHinhanh());
			file.delete();
			ra.addFlashAttribute("msg", Defines.MSG_DELETE_SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
		}
		return "redirect:/admin/project/index";

	}

}
