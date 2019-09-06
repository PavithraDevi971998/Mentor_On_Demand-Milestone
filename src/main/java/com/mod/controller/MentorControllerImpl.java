package com.mod.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mod.dao.MentorDao;
import com.mod.dao.UserDao;
import com.mod.model.Mentor;
import com.mod.model.User;
import com.mod.service.MentorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MentorControllerImpl {
@Autowired
private MentorService mentorSevice;
@Autowired
private MentorDao mentorDao;
@Autowired
private UserDao userDao;
@RequestMapping( value = "/addMentors", method = RequestMethod.GET)
public String getUserForm(ModelMap model) {
	System.out.println("add mentor");
	Mentor mentor=new Mentor();
	model.addAttribute("mentor", mentor);
	
	return "registerMentor";
}
@RequestMapping("/update")
public ModelAndView mentorUpdation(@RequestParam("mentorId") int mentorId, ModelMap map, HttpServletRequest request,
              @ModelAttribute("mentor") Mentor mentor) throws ClassNotFoundException, SQLException {
       ModelAndView mav = null;
       mentor= mentorSevice.getMentorId(mentorId) ; 
                map.addAttribute("mentorList",mentor);
                
                System.out.println(mentor);  
                mav = new ModelAndView("updateMentor");
                return mav;
}
@RequestMapping(value = "/updateMentor", method = RequestMethod.POST)
public String updatementor(@ModelAttribute("mentor")@Valid Mentor mentor,BindingResult result,Model model) throws SQLException {
       if(result.hasErrors()){
              System.out.println("errors");
              System.out.println(result.getAllErrors());
              model.addAttribute("e1",mentor );
              return "updateCompany";
       }
       mentorSevice.updateMentor(mentor);
       return "redirect:/mentorList";  
}
@RequestMapping(value="/delete")
public ModelAndView mentordelete(@RequestParam("mentorId") int mentorId) throws ClassNotFoundException, SQLException {
       ModelAndView mav = null;
       System.out.println(mentorId);
       mentorSevice.getdeleteCode(mentorId);
                
                mav = new ModelAndView("redirect:/mentorList");
                return mav;

       
}
@RequestMapping(value = "/addMentors", method = RequestMethod.POST)
public String formHandler(@ModelAttribute("mentor") @Valid 	Mentor mentor, 
		BindingResult result, Model model) throws SQLException {
	System.out.println(mentor);
	if(result.hasErrors()){
		
		return "registerMentor";
	}
	mentorSevice.insertMentor(mentor);
	System.out.println("inserted");
	return "redirect:/searchMentor";
	}
@RequestMapping(path="/loginMentor")
public String loginUser(Model model) throws Exception {
       Mentor mentor=new Mentor();
       System.out.println("hii");
       model.addAttribute("mentor", mentor);
       return "mentorLogin";
}
@RequestMapping(value = "/mentorLogin", method = RequestMethod.GET)
public String submit(@ModelAttribute("mentor")  @Valid Mentor mentor, BindingResult result,Model model) {
     return "mentorLogin";
       
}
@RequestMapping(path="/mentorList")
public ModelAndView getmentorList() throws Exception {
	ModelAndView mv=new ModelAndView();
	mv.setViewName("mentorList");
	mv.addObject("mentorList",mentorSevice.getmentorList());
	return mv;
}
@RequestMapping( value = "/searchMentor", method = RequestMethod.GET)
public String getCompanySearch(ModelMap model) {
	
	Mentor e=new Mentor();
	model.addAttribute("c1", e);
	return "SearchMentor";
}
@RequestMapping( value = "/searchMentor", method = RequestMethod.POST)
public ModelAndView  findByTechnology(Mentor mentor){
	ModelAndView mv=new ModelAndView();
	mv.setViewName("searchMentorList");
	mv.addObject("mentorList",mentorSevice.findByTechnology(mentor.getTechnology()));
	return mv;	
}
@RequestMapping( value = "/searchMentorTime", method = RequestMethod.GET)
public String getMentorSearch(ModelMap model) {
	Mentor e=new Mentor();
	model.addAttribute("c2", e);
	return "searchMentorTime";
}
@RequestMapping( value = "/searchMentorTime", method = RequestMethod.POST)
public ModelAndView  findByTime(Mentor mentor){
	ModelAndView mv=new ModelAndView();
	mv.setViewName("searchMentorListTime");
	mv.addObject("mentorList",mentorSevice.findByTime(mentor.getFromTime()));
	return mv;	
}


@RequestMapping(path="/confirmStatus")
public ModelAndView updateStatus(@RequestParam("id") int id,@RequestParam("userId") int userId, Mentor mentor){
       ModelAndView mav=new ModelAndView();
       Mentor mentor1=mentorDao.findBymentorId(id);
       //mentorDao.save(mentor);
       User user=userDao.findByid(userId);
       
        user.setStatusUser("Approved");
       mentor1.setStatusMentor("Approved");
       mentorDao.save(mentor1);
       userDao.save(user);
       mav=new ModelAndView("redirect:/userList");
       return mav;
}


@RequestMapping(path = "/mentorLogin", method = RequestMethod.POST)
public ModelAndView login1(Mentor mentor, Model model, HttpSession session) throws Exception {



       ModelAndView mav = null;

       String email = mentor.getEmail();
       System.out.println(email);
       List<Mentor> mentor1 = mentorSevice.findByemail(email);
System.out.println(mentor1);
       Mentor mentor2 = mentor1.get(0);

       if ((mentor.getEmail().equals(mentor2.getEmail())) && (mentor.getPassword().equals(mentor2.getPassword()))) {

    	   session.setAttribute("mentor",mentor2);
                    mav = new ModelAndView("redirect:/userList");
                    
              
       } else {

              mav = new ModelAndView("login", "message", "Invalid Username or Password");
       }

       return mav;
}
}
