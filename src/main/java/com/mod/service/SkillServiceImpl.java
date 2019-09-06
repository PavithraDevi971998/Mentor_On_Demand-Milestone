package com.mod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mod.dao.SkillDao;
import com.mod.model.Skills;
@Service
public class SkillServiceImpl implements SkillService {
@Autowired
SkillDao skillDao;
	@Override
	public void insertSkills(Skills skill) {
		// TODO Auto-generated method stub
		skillDao.save(skill);
	}

}
