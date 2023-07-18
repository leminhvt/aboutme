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
import spring.model.bean.Manage;
import spring.model.dao.ManageDAO;

@Controller
@RequestMapping("/admin/manage")
public class AdminManageController {

	@Autowired
	private ManageDAO manageDAO;

	@GetMapping("index")
	public String index(ModelMap modelMap) {
		List<Manage> listM = manageDAO.getItems();
		modelMap.addAttribute("listM", listM);
		return "aboutme.admin.manage.index";
	}

	@GetMapping("add")
	public String add() {
		return "aboutme.admin.manage.add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("manage") Manage manage, BindingResult br, RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "aboutme.admin.manage.add";
		}
		if (manageDAO.add(manage) > 0) {
			ra.addFlashAttribute("msg", Defines.MSG_ADD_SUCCESS);
			return "redirect:/admin/manage/index";
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
			return "redirect:/admin/manage/index";
		}
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, ModelMap modelMap) {
		Manage manage = manageDAO.getItem(id);
		modelMap.addAttribute("manage", manage);
		return "aboutme.admin.manage.edit";
	}

	@PostMapping("edit/{id}")
	public String edit(@Valid @ModelAttribute("manage") Manage manage, BindingResult br, RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "aboutme.admin.manage.add";
		}
		if (manageDAO.edit(manage) > 0) {
			ra.addFlashAttribute("msg", Defines.MSG_UPDATE_SUCCESS);
			return "redirect:/admin/manage/index";
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
			return "redirect:/admin/manage/index";
		}
	}

	@GetMapping("del/{id}")
	public String del(@PathVariable int id, RedirectAttributes ra) {
		if (manageDAO.del(id) > 0) {
			ra.addFlashAttribute("msg", Defines.MSG_DELETE_SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
		}
		return "redirect:/admin/manage/index";

	}

}
