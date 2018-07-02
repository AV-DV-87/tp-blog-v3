package fr.gtm.blog.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.gtm.blog.business.ArticleService;
import fr.gtm.blog.domain.Article;

@Controller
public class IndexController {

	@Autowired
	private ArticleService service;

	// les annotations peuvent prendre une valeur par défaut
	// dans ce cas c'est path = portion d'url
	@RequestMapping({ "/index", "/articles" })
	public ModelAndView index() {
		final ModelAndView mav = new ModelAndView("index");
		// ajout de la liste d'article dans le model
		mav.addObject("listArticle", service.getList());
		return mav;
	}

	// pour un nouvel article
	@GetMapping("/manage")
	public ModelAndView addArticle() {

		final ModelAndView mav = new ModelAndView("article");

		mav.getModel().put("modelArticle", new Article());

		return mav;
	}

	@GetMapping("/update")
	public ModelAndView updateArticle(@RequestParam Integer id) {

		final ModelAndView mav = new ModelAndView("article");
		//charger l'article existant dans le modèle pour le précharger
		mav.getModel().put("modelArticle", this.service.read(id));

		return mav;
	}

	@PostMapping({"/manage", "/update"})
	public String validateArticle(@ModelAttribute Article modelArticle) {
		if (modelArticle.getId() == null) {
			this.service.create(modelArticle);
		} else {
			this.service.edit(modelArticle);
		}
		// retour d'un nom de vue (client)
		return "redirect:/articles.html";
	}

	//// --------------- V1 Modification PERSO------------------
	// @RequestMapping({"/manage"})
	// public ModelAndView manage() {
	// final ModelAndView mav = new ModelAndView("article");
	// return mav;
	// }
	//
	//// Cas du post possibilité de renvoyer un objet MAV + appel de index()
	//// ou un string avec le nom de la vue
	// //@RequestParam("attribut name formualire") nom de l'attribut java
	// @PostMapping("/manage")
	// public String submit(
	// @RequestParam("title") String title, @RequestParam("description") String
	//// description) {
	//
	// final Article result = new Article();
	//
	// result.setTitle(title);
	// result.setDescription(description);
	//
	// service.create(result);
	// return "redirect:/";
	// // return this.index() possibilité de renvoyer vers la méthode générant
	//// l'index
	//
	// }
	//
	@GetMapping("/delete{id}")
	public String delete(@RequestParam("id") Integer id) {
		service.delete(id);
		return "redirect:/";
	}

}
