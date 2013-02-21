/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.service;

import com.artivisi.school.administration.domain.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author dsemuts
 */
public interface TeacherService {
    void save(Teacher t);
    void delete(Teacher t);
    Teacher findTeacherById(String id);
    Page<Teacher> findAllTeacher(Pageable pagination);
    Long countAllTeacher();
}
