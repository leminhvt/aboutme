package spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.constant.Defines;
import spring.model.bean.Category;
import spring.model.bean.Comment;
import spring.model.bean.Information;
import spring.model.bean.Manage;
import spring.model.bean.New;
import spring.model.bean.Skill;
import spring.model.dao.CommentDAO;
import spring.model.dao.InformationDAO;
import spring.model.dao.ManageDAO;
import spring.model.dao.SkillDAO;
import spring.model.dao.catDAO;
import spring.model.dao.landDAO;

@Controller
public class PublicController {

	@Autowired
	private InformationDAO informationDAO;

	@Autowired
	private ManageDAO manageDAO;

	@Autowired
	private SkillDAO skillDAO;

	@Autowired
	private landDAO landDAO;

	@Autowired
	private catDAO catDAO;

	@Autowired
	private CommentDAO commentDAO;

	@GetMapping("")
	public String index(@RequestParam(name = "page", required = false) Integer page, ModelMap modelMap) {
		Information information = informationDAO.getItem(1);
		modelMap.addAttribute("information", information);
		List<Manage> listM = manageDAO.getItems();
		modelMap.addAttribute("listM", listM);
		List<Skill> listK = skillDAO.getItems();
		modelMap.addAttribute("listK", listK);

		int numberOfItems = landDAO.coutItems();
		int numberOfPage = (int) Math.ceil(numberOfItems * 1.0 / Defines.ROW_COUNT);

		if (page == null) {
			page = 1;
		} else if (page < 1) {
			return "redirect:/";
		} else if (page > numberOfPage) {
			return "redirect:/?page=" + numberOfPage;
		}
		int offset = (page - 1) * Defines.ROW_COUNT;

		List<New> listL = landDAO.getItemsPagination(offset);
		modelMap.addAttribute("listL", listL);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("numberOfPage", numberOfPage);
		return "aboutme.public.index";
	}

	@GetMapping("cat")
	public String cat(ModelMap modelMap) {
		List<Category> listC = catDAO.getItems();
		modelMap.addAttribute("listC", listC);
		List<New> listN = landDAO.getItemsMore(3);
		modelMap.addAttribute("listN", listN);
		return "aboutme.public.cat";
	}

	@GetMapping("cat/{id}")
	public String cat(@PathVariable int id, ModelMap modelMap) {
		List<Category> listC = catDAO.getItems();
		modelMap.addAttribute("listC", listC);
		List<New> listN = landDAO.getItemsMore(3);
		modelMap.addAttribute("listN", listN);
		List<New> listNN = landDAO.getItems(id);
		modelMap.addAttribute("listNN", listNN);
		Category category = catDAO.getItem(id);
		modelMap.addAttribute("category", category);
		modelMap.addAttribute("idCat", id);
		return "aboutme.public.cat";
	}

	@GetMapping("blog")
	public String blog(ModelMap modelMap) {
		List<Category> listC = catDAO.getItems();
		modelMap.addAttribute("listC", listC);
		List<New> listN = landDAO.getItemsMore(3);
		modelMap.addAttribute("listN", listN);
		List<Comment> comments = commentDAO.getItems();
		modelMap.addAttribute("comments", comments);
		return "aboutme.public.blog";
	}

	@GetMapping("blog/{id}")
	public String blog(@PathVariable int id, ModelMap modelMap) {
		landDAO.increaseviews(id);
		New newnew = landDAO.getItem(id);
		modelMap.addAttribute("newnew", newnew);
		List<New> listNN = landDAO.getItemOther(newnew, 3);
		modelMap.addAttribute("listNN", listNN);
		List<Category> listC = catDAO.getItems();
		modelMap.addAttribute("listC", listC);
		List<New> listN = landDAO.getItemsMore(3);
		modelMap.addAttribute("listN", listN);
		List<Comment> comments = commentDAO.getItems(id);
		modelMap.addAttribute("comments", comments);
		return "aboutme.public.blog";
	}

	@PostMapping("xuly-comment")
	public String blog(@RequestParam int id_tin, @RequestParam String user, @RequestParam String noidung,
			ModelMap modelMap) {
		commentDAO.add(id_tin, user, noidung);
		List<Comment> comments = commentDAO.getItems(id_tin);
		modelMap.addAttribute("comments", comments);
		return "public/ajax";
	}

}
