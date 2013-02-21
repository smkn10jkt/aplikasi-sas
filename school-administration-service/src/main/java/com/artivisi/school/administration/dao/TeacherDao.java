/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.dao;

import com.artivisi.school.administration.domain.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author dsemuts
 */
public interface TeacherDao extends PagingAndSortingRepository<Teacher, String> {
    
}
