/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.service.impl;

import com.artivisi.school.administration.dao.TeacherDao;
import com.artivisi.school.administration.domain.Teacher;
import com.artivisi.school.administration.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 *
 * @author dsemuts
 */

@Service
@Transactional
public class TeacherImpl implements TeacherService{

    @Autowired private TeacherDao teacherDao;
    
    @Override
    public void save(Teacher t) {
        teacherDao.save(t);
    }

    @Override
    public void delete(Teacher t) {
        teacherDao.delete(t);
    }

    @Override
    public Teacher findTeacherById(String id) {
        if(!StringUtils.hasText(id)){
            return null;
        }
        return teacherDao.findOne(id);
    }

    @Override
    public Page<Teacher> findAllTeacher(Pageable pagination) {
        return teacherDao.findAll(pagination);
    }

    @Override
    public Long countAllTeacher() {
        return teacherDao.count();
    }

}
