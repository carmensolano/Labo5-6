package com.uca.capas.dao;

import com.uca.capas.domain.Student;

import java.util.List;

import org.springframework.dao.DataAccessException;




public interface StudentDAO {
	
public List<Student> findAll() throws DataAccessException;
	
	public Student findOne(Integer code) throws DataAccessException;


}
