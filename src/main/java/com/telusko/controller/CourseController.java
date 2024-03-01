package com.telusko.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.pojo.Course;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	
     
	@GetMapping("/getcourse/{cid}")
	public ResponseEntity<Course> getCourseInfo(@PathVariable("cid") String cid)
	{
		System.out.println("id from client to server "+ cid);
		Course course=new Course("T01","Docker&K8s",4999.5,"Abbas");
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.
				methodOn(CourseController.class).getCourses()).withRel("getother");
		System.out.println("Before adding link");
		course.add(link);
		System.out.println("Link is fine");
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@GetMapping("/getallcourses")
	public List<Course> getAllCourses()
	{
		System.out.println("controller in all course");
		List<Course> list=new ArrayList<>();
		list.add(new Course("T01","Docker&K8s",4999.5,"Abbas"));
		list.add(new Course("T02","Microservices",3999.5,"Navin Reddy"));
		list.add(new Course("T03","SpringBoot & Microservices",4999.5,"Abbas & Navin reddy"));
		
		return list;
	}
	
	@GetMapping("/getother")
	public ResponseEntity<List<Course>> getCourses()
	{
		
		List<Course> list=new ArrayList<>();
		list.add(new Course("T02","AWS",4999.5,"Abbas"));
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getjava/{cid}")
	public ResponseEntity<Course> getCourse(@PathVariable("cid") String cid)
	{
		System.out.println("id from client to server "+ cid);
		Course course=new Course("T03","Java",4999.5,"Abbas");
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.
				methodOn(CourseController.class).getAllCourses()).withRel("getallcourses");
		System.out.println("Before adding link");
		course.add(link);
		System.out.println("Link is fine");
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
}