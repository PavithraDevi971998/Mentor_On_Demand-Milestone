package com.mod.service;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import com.mod.model.Mentor;
import com.mod.model.User;

public interface MentorService {
public void insertMentor(Mentor mentor);



public List<Mentor> findByemail(String email);

public List<Mentor> getmentorList() throws SQLException;
public List<Mentor>  findByTechnology(String technology);



public List<Mentor> findByTime(String fromTime);



public Mentor getMentorId(int mentorId);



public void updateMentor(@Valid Mentor mentor);



public void getdeleteCode(int mentorId);




}
