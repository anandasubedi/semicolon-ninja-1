package com.semicolon.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.semicolon.domain.UserRole;

@Controller
public class LoginController {

	@RequestMapping(value = { "/success" }, method = RequestMethod.GET)
	public String loginSuccess(HttpServletRequest request) {

		/*
		 * SecurityContextHolderAwareRequestWrapper s = new
		 * SecurityContextHolderAwareRequestWrapper(request, ""); if
		 * (s.isUserInRole(Role.ROLE_ADMIN.toString())) return
		 * "redirect:/admin/dashboard";
		 * 
		 * if (s.isUserInRole(Role.ROLE_USER.toString())) return
		 * "redirect:/user/dashboard";
		 * 
		 * return "redirect:/login";
		 */
		if (request.isUserInRole(UserRole.ROLE_ADMIN.toString()))
			return "redirect:/movies";

		if (request.isUserInRole(UserRole.ROLE_USER.toString()))
			return "redirect:/dashboard";

		return "redirect:/login";
	}

}
