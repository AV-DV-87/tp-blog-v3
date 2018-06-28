package fr.gtm.blog.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Author implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private LocalDate subDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getSubDate() {
		return subDate;
	}

	public void setSubDate(LocalDate subDate) {
		this.subDate = subDate;
	}

}
