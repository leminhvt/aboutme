package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("auth")
public class AuthController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("login")
	public String login() {
		return "auth/login";
	}

	@ResponseBody
	@GetMapping("mahoa")
	public String mahoa() {
		String pass = bCryptPasswordEncoder.encode("123456");
		return pass;
	}

}
