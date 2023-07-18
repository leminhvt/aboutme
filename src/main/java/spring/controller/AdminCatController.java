package spring.controller;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.constant.Defines;
import spring.model.bean.Category;
import spring.model.dao.catDAO;
import spring.model.dao.landDAO;

@Controller
@RequestMapping("/admin/cat")
public class AdminCatController {
	@Autowired
	private catDAO catDAO;

	@Autowired
	private landDAO landDAO;

	@GetMapping("index")
	public String index(ModelMap modelMap) {
		List<Category> listC = catDAO.getItems();
		modelMap.addAttribute("list", listC);
		return "aboutme.admin.cat.index";
	}

	@GetMapping("add")
	public String add() {
		return "aboutme.admin.cat.add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("category") Category category, BindingResult br, RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "aboutme.admin.cat.add";
		}
		if (catDAO.add(category) > 0) {
			ra.addFlashAttribute("msg", Defines.MSG_ADD_SUCCESS);
			return "redirect:/admin/cat/index";
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
			return "redirect:/admin/cat/index";
		}

	}

	@GetMapping("del/{id}")
	public String del(@PathVariable int id, RedirectAttributes ra) {
		if (catDAO.delItem(id) > 0) {
			landDAO.delCatId(id);
			ra.addFlashAttribute("msg", Defines.MSG_DELETE_SUCCESS);
			return "redirect:/admin/cat/index";
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
			return "redirect:/admin/cat/index";
		}

	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, ModelMap modelMap) {
		Category category = catDAO.getItem(id);
		modelMap.addAttribute("category", category);
		return "aboutme.admin.cat.edit";
	}

	@PostMapping("edit/{id}")
	public String edit(@PathVariable int id, @Valid @ModelAttribute("category") Category category, BindingResult br,
			RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "aboutme.admin.cat.edit";
		}
		if (catDAO.editItem(category) > 0) {
			ra.addFlashAttribute("msg", Defines.MSG_UPDATE_SUCCESS);
			return "redirect:/admin/cat/index";
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
			return "redirect:/admin/cat/index";
		}

	}

}
