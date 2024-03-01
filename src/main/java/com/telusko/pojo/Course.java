package com.telusko.pojo;

import org.springframework.hateoas.RepresentationModel;

public class Course extends RepresentationModel
{
	private String cid;
	private String cname;
	private Double price;
	private String instructorName;
	
	
	public Course() 
	{
		
	}

	public Course(String cid, String cname, Double price, String instructorName) {
		this.cid = cid;
		this.cname = cname;
		this.price = price;
		this.instructorName = instructorName;
	}
	

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", price=" + price + ", instructorName=" + instructorName
				+ "]";
	}
}
