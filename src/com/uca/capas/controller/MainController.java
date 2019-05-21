package com.uca.capas.controller;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.Student;




@Controller
public class MainController {
	

	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping("/")
	public ModelAndView initMain(){
		log.info("Entrando a funcion init-main" + log.getName() );
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
		 students = studentDao.findAll();
		 log.info("termino de buscar en la base de datos");
		}
		catch(Exception e){
			log.log(Level.SEVERE, "Exception Occur", e);
			// e.printStackTrace();
		}
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/form")
	public ModelAndView formData(@RequestParam(value="ID") int id_stdnt) {
		ModelAndView mav = new ModelAndView();
		List<Student> student= null;
		Student student2= null;
		try {
			student = studentDao.findAll();
			student2= studentDao.findOne(id_stdnt);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("student2", student2);
		mav.addObject("student", student);
		mav.setViewName("main");
		
		return mav;
	}
	
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student", new Student());
		mav.setViewName("form");
		return mav;
	}
	
	
	@RequestMapping(value="/formData")
	public ModelAndView save(@ModelAttribute Student s) {
		ModelAndView mav= new ModelAndView();
		List<Student> students = null;
		try {
			log.info("Agrego un nuevo Usuario");
			studentDao.save(s, 1);
			}catch(Exception e) {
				log.info("Error:"+e.toString());
				}
		students = studentDao.findAll();
		log.info(students.get(0).getlName());
		mav.addObject("students", students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView formData(@RequestParam(value ="id2")String id_stdnt) {
		ModelAndView mav = new ModelAndView();
		List<Student> student = null;
		Student student2 = null;
		try {
			studentDao.delete(id_stdnt);
			student= studentDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("student", student);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/mod", method=RequestMethod.POST)
	public ModelAndView mod(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> student = null;
		
		try {
			studentDao.update(s);
			student = studentDao.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("student", student);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView update(@RequestParam(value= "id3") int id_stdnt) {
		ModelAndView mav = new ModelAndView();
		Student student= null;
		try {
			student = studentDao.findOne(id_stdnt);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("student", student);
		mav.setViewName("update");
		return mav;
	} 
}
