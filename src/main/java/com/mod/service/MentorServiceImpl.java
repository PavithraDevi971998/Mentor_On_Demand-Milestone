package com.mod.service;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mod.dao.MentorDao;
import com.mod.model.Mentor;
import com.mod.model.User;
@Service
public class MentorServiceImpl implements MentorService
{
@Autowired
MentorDao mentorDao;
	
	public void insertMentor(Mentor mentor) {
		// TODO Auto-generated method stub
		mentorDao.save(mentor);
	}

	@Override
	public List<Mentor> findByemail(String email) {
		// TODO Auto-generated method stub
		return mentorDao.findByemail(email);
	}

	@Override
	public List<Mentor> getmentorList() throws SQLException {
		// TODO Auto-generated method stub
		return mentorDao.findAll();
	}

	@Override
	public List<Mentor> findByTechnology(String technology) {
		// TODO Auto-generated method stub
		return mentorDao.findBytechnology(technology);
	}

	@Override
	public List<Mentor> findByTime(String fromTime) {
		// TODO Auto-generated method stub
		return mentorDao.findByfromTime(fromTime);
	}

	@Override
	public Mentor getMentorId(int mentorId) {
		// TODO Auto-generated method stub
		return mentorDao.getOne(mentorId);
	}

	@Override
	public void updateMentor(@Valid Mentor mentor) {
		// TODO Auto-generated method stub
		mentorDao.save(mentor);
		
	}

	@Override
	public void getdeleteCode(int mentorId) {
		// TODO Auto-generated method stub
		mentorDao.deleteById(mentorId);
	}

	
}
