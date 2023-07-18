package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.constant.Defines;
import spring.model.bean.Contact;
import spring.model.dao.ContactDAO;

@Controller
@RequestMapping("/admin/contact")
public class AdminContactController {

	@Autowired
	private ContactDAO contactDAO;

	@GetMapping("index")
	public String index(ModelMap modelMap) {
		List<Contact> listC = contactDAO.getItems();
		modelMap.addAttribute("listC", listC);
		return "aboutme.admin.contact.index";
	}

	@GetMapping("del/{id}")
	public String del(@PathVariable int id, RedirectAttributes ra) {
		if (contactDAO.del(id) > 0) {
			ra.addFlashAttribute("msg", Defines.MSG_DELETE_SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
		}
		return "redirect:/admin/contact/index";
	}

}
