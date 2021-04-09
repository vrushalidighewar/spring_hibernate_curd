package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.entity.Student;
import com.app.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@ModelAttribute("students")
	public List<Student> listOfStudents(){
		return studentService.getStudents();
	}
	
	@GetMapping(value="/index")
	public String viewHome() {
		return "registration";
	}
	
	@PostMapping(value="save")
	public String saveOrUpdate(Model model,@ModelAttribute Student student,RedirectAttributes redirectAttributes) {
		Boolean result=studentService.saveOrUpdate(student);
		if(result)
			redirectAttributes.addFlashAttribute("success","student saved...");
		else
			redirectAttributes.addFlashAttribute("error","student not saved..");
		return "redirect:/index";
	}
	
	@GetMapping(value="delete")
	public String deleteStudent(@RequestParam("id") Integer id,RedirectAttributes redirectAttributes) {
		Boolean result=studentService.deleteStudent(id);
		if(result)
			redirectAttributes.addFlashAttribute("success","student deleted..");
		else
			redirectAttributes.addFlashAttribute("error","student not deleted....");
		return "redirect:/index";
	}
}
