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
import spring.model.bean.Information;
import spring.model.dao.InformationDAO;

@Controller
@RequestMapping("/admin/information")
public class AdminInformationController {

	@Autowired
	private InformationDAO informationDAO;

	@GetMapping("index")
	public String index(ModelMap modelMap) {
		List<Information> listI = informationDAO.getItems();
		modelMap.addAttribute("listI", listI);
		return "aboutme.admin.information.index";
	}

	@GetMapping("add")
	public String add() {
		return "aboutme.admin.information.add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("information") Information information, BindingResult br,
			RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "aboutme.admin.information.add";
		}
		if (informationDAO.add(information) > 0) {
			ra.addFlashAttribute("msg", Defines.MSG_ADD_SUCCESS);
			return "redirect:/admin/information/index";
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
			return "redirect:/admin/information/index";
		}
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, ModelMap modelMap) {
		Information information = informationDAO.getItem(id);
		modelMap.addAttribute("information", information);
		return "aboutme.admin.information.edit";
	}

	@PostMapping("edit/{id}")
	public String edit(@Valid @ModelAttribute("information") Information information, BindingResult br,
			RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "aboutme.admin.information.edit";
		}
		if (informationDAO.edit(information) > 0) {
			ra.addFlashAttribute("msg", Defines.MSG_UPDATE_SUCCESS);
			return "redirect:/admin/information/index";
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
			return "redirect:/admin/information/index";
		}

	}

	@GetMapping("del/{id}")
	public String del(@PathVariable int id, RedirectAttributes ra) {
		if (informationDAO.del(id) > 0) {
			ra.addFlashAttribute("msg", Defines.MSG_DELETE_SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
		}
		return "redirect:/admin/information/index";
	}

}
