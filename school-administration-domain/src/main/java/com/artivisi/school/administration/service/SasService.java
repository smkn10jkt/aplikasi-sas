/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.service;

import com.artivisi.school.administration.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author dsemuts
 */
public interface SasService {
    void save(Student student);
    void delete(Student student);
    Student findStudentById(String id);
    Page<Student> findAllStudent(PageRequest pagination);
    Page<Student> findStudentByNIS(String nis, PageRequest pagination);
    Page<Student> findStudentByName(String name, PageRequest pagination);
}
