package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminIndexController {

	@GetMapping("admincp")
	public String index() {
		return "aboutme.admin.index.index";

	}

}
