/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.dao;

import com.artivisi.school.administration.domain.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author dsemuts
 */
public interface StudentDao extends PagingAndSortingRepository<Student, String> {
    
}
