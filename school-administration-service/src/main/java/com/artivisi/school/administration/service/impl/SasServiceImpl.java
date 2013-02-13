/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.service.impl;

import com.artivisi.school.administration.dao.StudentDao;
import com.artivisi.school.administration.domain.Student;
import com.artivisi.school.administration.service.SasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dsemuts
 */
@Service
@Transactional
public class SasServiceImpl implements SasService{

    @Autowired private StudentDao studentDao;
    
    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public void delete(Student student) {
        studentDao.delete(student);
    }

    @Override
    public Student findStudentById(String id) {
        if(id == null || id.trim().length() < 1){
            return null;
        }
        return studentDao.findOne(id);
    }

    @Override
    public Page<Student> findAllStudent(PageRequest pagination) {
        return studentDao.findAll(pagination);
    }

    @Override
    public Page<Student> findStudentByNIS(String nis, PageRequest pagination) {
        return studentDao.findByNISContaining(nis);
    }

    @Override
    public Page<Student> findStudentByName(String name, PageRequest pagination) {
        if(name == null || name.trim().length() < 1){
            return findAllStudent(pagination);
        }
        return studentDao.findByNameContaining(name, pagination);
    }
    
}
