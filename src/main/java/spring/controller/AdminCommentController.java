package spring.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.constant.Defines;
import spring.model.bean.Comment;
import spring.model.dao.CommentDAO;

@Controller
@RequestMapping("/admin/comment")
public class AdminCommentController {

	@Autowired
	private CommentDAO commentDAO;

	@GetMapping("index")
	public String index(ModelMap modelMap) {
		List<Comment> listC = commentDAO.getItems();
		modelMap.addAttribute("listC", listC);
		return "aboutme.admin.comment.index";
	}

	@GetMapping("del/{id}")
	public String del(@PathVariable int id, RedirectAttributes ra) {
		if (commentDAO.del(id) > 0) {
			ra.addFlashAttribute("msg", Defines.MSG_DELETE_SUCCESS);
		} else {
			ra.addFlashAttribute("msg", Defines.MSG_ERROR);
		}
		return "redirect:/admin/comment/index";
	}

}
