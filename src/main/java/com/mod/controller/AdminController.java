package com.mod.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
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
import com.mod.service.UserService;

@Controller
public class AdminController {
	@Autowired
	private MentorService mentorSevice;
	@Autowired
	private MentorService mentorService;
	@Autowired
	private MentorDao mentorDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String submit(@ModelAttribute("user3")  @Valid Mentor mentor, BindingResult result,Model model) {
	     return "adminLogin";
	       
	}
	@RequestMapping(path = "/adminlogin", method = RequestMethod.POST)
	
	public ModelAndView login1(Mentor mentor, Model model, HttpSession session) throws Exception {



	       ModelAndView mav = null;

	       String email = mentor.getEmail();
	       System.out.println(email);
	       List<Mentor> mentor1 = mentorSevice.findByemail(email);
	System.out.println(mentor1);
	       Mentor mentor2 = mentor1.get(0);

	       if ((mentor.getEmail().equals(mentor2.getEmail())) && (mentor.getPassword().equals(mentor2.getPassword()))) {

	    	   session.setAttribute("mentor",mentor2);
	                    mav = new ModelAndView("admin");
	                    
	              
	       } else {

	              mav = new ModelAndView("login", "message", "Invalid Username or Password");
	       }

	       return mav;

	}	@RequestMapping(value = "/blockmentor")
	public String blockMentor(ModelMap model, @RequestParam("id") int mentorId,
	              @ModelAttribute("adminmentorList") Mentor mentor) {
	       System.out.println(mentorId);
	       boolean a=mentor.isActive();
	       System.out.println(a);
	       if(a==false)
	       {             
	              mentorDao.blockBymentorId(mentorId);
	       }
	       System.out.println(a);
	       return "redirect:/adminmentorList";
	}
	@RequestMapping(value = "/Unblockmentor")
	public String unblockMentor(ModelMap model, @RequestParam("id") int mentorId,
	              @ModelAttribute("adminmentorList") Mentor mentor) {
	       System.out.println(mentorId);
	       boolean a=mentor.isActive();     
	       System.out.println(a);
	       a=true;
	       if(a==true)
	       {                          

	              mentorDao.unblockBymentorId(mentorId);
	       }
	       System.out.println(a);
	       return "redirect:/adminmentorList";
	}

	@RequestMapping(path="/adminmentorList")
	public ModelAndView getmentorListsearch() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminMentor");
		mv.addObject("adminmentorList",mentorService.getmentorList());
		return mv;
	}
	@RequestMapping(value = "/blockuser")
	public String blockuser(ModelMap model, @RequestParam("id") int id,
	              @ModelAttribute("adminuserList") User user) {
	       System.out.println(id);
	       boolean a=user.isActive();
	       System.out.println(a);
	       if(a==false)
	       {             
	    	   userDao.blockByid(id);
	       }
	       System.out.println(a);
	       return "redirect:/adminuserList";
	}
	@RequestMapping(value = "/Unblockuser")
	public String unblockuser(ModelMap model, @RequestParam("id") int id,
            @ModelAttribute("adminuserList") User user)  {
	       System.out.println(id);
	       boolean a=user.isActive();     
	       System.out.println(a);
	       a=true;
	       if(a==true)
	       {                          

	    	   userDao.unblockByid(id);
	       }
	       System.out.println(a);
	       return "redirect:/adminuserList";
	}

	@RequestMapping(path="/adminuserList")
	public ModelAndView getuserListsearch() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminUser");
		mv.addObject("adminuserList",userService.getuserList());
		return mv;
	}
}
