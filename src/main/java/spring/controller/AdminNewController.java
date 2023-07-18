package spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.constant.Defines;
import spring.model.bean.Category;
import spring.model.bean.New;
import spring.model.dao.catDAO;
import spring.model.dao.landDAO;
import spring.util.FileNameUtil;

@Controller
@RequestMapping("/admin/new")
public class AdminNewController {

	@Autowired
	private landDAO landDAO;

	@Autowired
	private catDAO catDAO;

	@Autowired
	private ServletContext context;

	@GetMapping("index")
	public String index(@RequestParam(name = "page", required = false) Integer page, ModelMap modelMap) {

		int numberOfItems = landDAO.coutItems();
		int numberOfPage = (int) Math.ceil(numberOfItems * 1.0 / Defines.ROW_COUNT);

		if (page == null) {
			page = 1;
		} else if (page < 1) {
			return "redirect:/admin/new/index";
		} else if (page > numberOfPage) {
			return "redirect:/admin/new/index?page=" + numberOfPage;
		}
		int offset = (page - 1) * Defines.ROW_COUNT;

		List<New> listL = landDAO.getItemsPagination(offset);
		modelMap.addAttribute("listL", listL);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("numberOfPage", numberOfPage);
		return "aboutme.admin.new.index";
	}

	@GetMapping("search")
	public String search(@RequestParam("search") String search, ModelMap modelMap) {
		ArrayList<New> listS = landDAO.getItemSearch(search);
		modelMap.addAttribute("listL", listS);
		return "aboutme.admin.new.search";
	}

	@GetMapping("add")
	public String add(ModelMap modelMap) {
		List<Category> listC = catDAO.getItems();
		modelMap.addAttribute("listC", listC);
		return "aboutme.admin.new.add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("new") New new1, BindingResult br,
			@RequestParam("picture") CommonsMultipartFile cmf, ModelMap modelMap, RedirectAttributes ra,
			@RequestParam("id") int id) {
		new1.setCategory(new Category(id, null));
		if (br.hasErrors()) {
			List<Category> listC = catDAO.getItems();
			modelMap.addAttribute("listC", listC);
			return "aboutme.admin.new.add";
		}

		String fileName = FileNameUtil.rename(cmf.getOriginalFilename());
		new1.setHinhanh(fileName);
		if (landDAO.add(new1) > 0) {
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
		return "redirect:/admin/new/index";

	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, ModelMap modelMap) {
		New new1 = landDAO.getItem(id);
		modelMap.addAttribute("land", new1);
		List<Category> listC = catDAO.getItems();
		modelMap.addAttribute("listC", listC);
		return "aboutme.admin.new.edit";
	}

	@PostMapping("edit/{id}")
	public String edit(@Valid @ModelAttribute New land, BindingResult br,
			@RequestParam("picture") CommonsMultipartFile cmf, @RequestParam("id") int id, ModelMap modelMap,
			RedirectAttributes ra, @PathVariable("id") int id_tin) {

		land.setId_tin(id_tin);
		land.setCategory(new Category(id, null));

		New oldLand = landDAO.getItem(land.getId_tin());

		if (br.hasErrors()) {
			land.setHinhanh(oldLand.getHinhanh());
			List<Category> listC = catDAO.getItems();
			modelMap.addAttribute("listC", listC);
			return "aboutme.admin.new.edit";
		}

		String filename = "";
		if ("".equals(cmf.getOriginalFilename())) {
			land.setHinhanh(oldLand.getHinhanh());
		} else {
			filename = FileNameUtil.rename(cmf.getOriginalFilename());
			land.setHinhanh(filename);
		}

		if (landDAO.edit(land) > 0) {
			if (!"".equals(filename)) {
				String dirPath = context.getRealPath("") + "WEB-INF" + File.separator + Defines.DIR_UPLOAD;
				System.out.println(dirPath);
				File file = new File(dirPath);
				if (!file.exists()) {
					file.mkdirs();
				}

				// xoa anh cu
				File oldFile = new File(dirPath + File.separator + oldLand.getHinhanh());
				oldFile.delete();

				// them anh moi
				try {
					cmf.transferTo(new File(dirPath + File.separator + filename));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}

			}
			ra.addFlashAttribute("msg", Defines.MSG_UPDATE_SUCCESS);
			return "redirect:/admin/new/index";
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_UPDATE_SUCCESS);
			return "redirect:/admin/new/index";
		}
	}

	@GetMapping("del/{id}")
	public String del(@PathVariable int id, RedirectAttributes ra) {
		New land = landDAO.getItem(id);
		if (landDAO.del(id) > 0) {
			File file = new File(context.getRealPath("") + "WEB-INF" + File.separator + Defines.DIR_UPLOAD
					+ File.separator + land.getHinhanh());
			file.delete();
			ra.addFlashAttribute("msg", Defines.MSG_DELETE_SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
		}
		return "redirect:/admin/new/index";

	}

	@PostMapping("status")
	@ResponseBody
	public String status(@RequestParam int atrangthai, @RequestParam int aid, ModelMap modelMap) {
		if (atrangthai == 1) {
			landDAO.updateStatusZezo(aid, 0);
		} else {
			landDAO.updateStatusOne(aid, 1);
		}
		int trangthai = landDAO.getItemStatus(aid);

		if (trangthai == 1) {
			return ("<a href=\"javascript:void(0)\" onclick=\"return getActive(" + aid + ",1)\" >"
					+ "<img src=\"/aboutme/adminUrl/images/active.gif \" />" + "</a>");
		} else {
			return ("<a href=\"javascript:void(0)\" onclick=\"return getActive(" + aid + ",0)\" >"
					+ "<img src=\"/aboutme/adminUrl/images/deactive.gif \" />" + "</a>");
		}

	}

}
