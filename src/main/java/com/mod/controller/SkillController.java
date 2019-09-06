package com.mod.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mod.model.Mentor;
import com.mod.model.Skills;
import com.mod.service.SkillService;

@Controller
public class SkillController {
@Autowired
private SkillService skillService;
@RequestMapping( value = "/addSkills", method = RequestMethod.GET)
public String getUserForm(ModelMap model) {
	System.out.println("add skill");
	Skills skill=new Skills();
	model.addAttribute("skill", skill);
	
	return "registerSkill";
}
@RequestMapping(value = "/addSkills", method = RequestMethod.POST)
public String formHandler(@ModelAttribute("skill") @Valid 	Skills skill, 
		BindingResult result, Model model) throws SQLException {
	System.out.println(skill);
	if(result.hasErrors()){
		
		return "registerSkill";
	}
	skillService.insertSkills(skill);
	System.out.println("inserted");
	return "redirect:/registerSkill";
	}
}
