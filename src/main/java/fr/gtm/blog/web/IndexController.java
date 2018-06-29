package fr.gtm.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
//	les annotations peuvent prendre une valeur par défaut
	// dans ce cas c'est path = portion d'url
	@RequestMapping("/")
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("index");
		return mav;
	}
}
