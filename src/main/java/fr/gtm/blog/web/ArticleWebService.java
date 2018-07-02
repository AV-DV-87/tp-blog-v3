package fr.gtm.blog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.blog.business.ArticleService;
import fr.gtm.blog.domain.Article;

@RestController
@RequestMapping("/api/article")
public class ArticleWebService {
	
	@Autowired
	private ArticleService service;
	
//	@ResponseBody si on reste en @Controller, à mettre sur chaque méthode
	//RequestBody tous les paramètres dans un objet JAVA
	
	@PostMapping({"","/"})
	public Article create(@RequestBody Article article) {
		return this.service.create(article);
	}
	
	@GetMapping("")
	public List<Article> readAll(){
		return this.service.getList();
	}
	
	
	
}
