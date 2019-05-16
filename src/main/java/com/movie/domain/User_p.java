package com.movie.domain;

public class User_p {
	private Integer id;
	private String name;
	private String image;
	@Override
	public String toString() {
		return "User_p [id=" + id + ", name=" + name + ", image=" + image + "]";
	}
	
	public User_p() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User_p(Integer id, String name, String image) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
	}

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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
