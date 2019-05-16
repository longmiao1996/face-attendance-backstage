package com.movie.domain;

public class Meeting_p {
	private Integer id;
	private String name_m;
	private String content_m;
	private String ids_m;
	private Integer state;
	@Override
	public String toString() {
		return "Meeting_p [id=" + id + ", name_m=" + name_m + ", content_m=" + content_m + ", ids_m=" + ids_m
				+ ", state=" + state + "]";
	}
	public Meeting_p(Integer id, String name_m, String content_m, String ids_m, Integer state) {
		super();
		this.id = id;
		this.name_m = name_m;
		this.content_m = content_m;
		this.ids_m = ids_m;
		this.state = state;
	}
	public Meeting_p() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName_m() {
		return name_m;
	}
	public void setName_m(String name_m) {
		this.name_m = name_m;
	}
	public String getContent_m() {
		return content_m;
	}
	public void setContent_m(String content_m) {
		this.content_m = content_m;
	}
	public String getIds_m() {
		return ids_m;
	}
	public void setIds_m(String ids_m) {
		this.ids_m = ids_m;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	

}
