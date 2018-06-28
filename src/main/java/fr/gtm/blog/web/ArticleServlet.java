package fr.gtm.blog.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import fr.gtm.blog.business.CrudService;
import fr.gtm.blog.domain.Article;

public class ArticleServlet extends AutowiredServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CrudService<Article> service;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/article.jsp")
				.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Récupérer les paramètres 'title' et 'descr'.
		final String title = request.getParameter("title");
		final String description = request.getParameter("descr");
		this.service.create(new Article(title, description));
		response.sendRedirect(
				this.getServletContext().getContextPath() + "/articles");
	}
}
