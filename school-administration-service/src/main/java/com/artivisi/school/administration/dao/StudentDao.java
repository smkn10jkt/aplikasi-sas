/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.dao;

import com.artivisi.school.administration.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author dsemuts
 */
public interface StudentDao extends PagingAndSortingRepository<Student, String>{
    Page<Student> findByNameContaining(String name, PageRequest pagination);
    
    @Query("select student from Student student")
            
    Page<Student> findByNISContaining(String nis);
}
