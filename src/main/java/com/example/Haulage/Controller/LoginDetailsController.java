package com.example.Haulage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.Haulage.Entity.LoginDetails;
import com.example.Haulage.Service.LoginDetailsService;

@Controller
//@RequestMapping("login")
public class LoginDetailsController {

	@Autowired
	LoginDetailsService loginDetailsService;

	@Autowired
	WebRequest webRequest;

	@GetMapping("/Login")
	public String indexer(Model model) {
		return "LoginDetails";
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		return "dashboard";
	}

	@PostMapping("/checkLogin")
	public String organizationManage(Model model, @RequestParam(value = "username", required = false) String user,
			@RequestParam(value = "password", required = false) String pass, RedirectAttributes redirect) {

		LoginDetails loginDetials = loginDetailsService.checkUserNamePassword(user, pass);
		if (loginDetials != null) {

			model.addAttribute("message", "Successfully Logged-In");
			webRequest.setAttribute("loginDetails", loginDetials, RequestAttributes.SCOPE_SESSION);
			// return "dashboard";
			return "redirect:/dashboard";
		} else {
			// model.addAttribute("message", "Invalid Credentials");
			redirect.addFlashAttribute("message", "Invalid Credentials");
			return "redirect:/";
		}
	}

	@GetMapping("/signOut")
	public String organizationManage(Model model, RedirectAttributes redirect) {
		webRequest.removeAttribute("loginDetails", RequestAttributes.SCOPE_SESSION);

		redirect.addFlashAttribute("message", "Successfully Logged-Out");
		return "redirect:/";
	}

}