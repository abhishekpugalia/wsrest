package com.amitverma.spring.rest.controller;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.amitverma.spring.rest.to.StudentTO;
import com.amitverma.spring.rest.to.Students;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
	public String getStudent(@PathVariable int id, ModelMap model) {
		System.out.println("in getStudent()");
		StudentTO st = new StudentTO(id, "Amit", "amit@gmail.com", "9999");
		model.addAttribute("STUD", st);
		return "index";
	}

	@RequestMapping(value = "/add/{name}/{email}/{phone}", method = RequestMethod.POST)
	public String addStudent(@PathVariable String name,
			@PathVariable String email, @PathVariable String phone,
			ModelMap model) {
		System.out.println("in addStudent()");
		StudentTO st = new StudentTO(123, name, email, phone);
		System.out.println("in server: " + st);
		model.addAttribute("ADDED", "Student Info Added Sucessfully");
		return "index";
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public String getAllStudents(ModelMap model) {
		System.out.println("in getAllStudent()");
		List<StudentTO> studList = new ArrayList<StudentTO>();
		studList.add(new StudentTO(1, "Aman", "aman@gmail.com", "28829"));
		studList.add(new StudentTO(2, "Manish", "manish@gmail.com", "42672"));
		studList.add(new StudentTO(3, "Ravi", "ravi@gmail.com", "89002"));
		studList.add(new StudentTO(4, "Raghu", "raghu@gmail.com", "68292"));
		Students list = new Students();
		list.setStudList(studList);
		model.addAttribute("LIST", list);
		return "index";
	}

}