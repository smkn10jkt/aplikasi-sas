/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.dao;

import com.artivisi.school.administration.domain.Kelas;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Fauzani
 */
public interface KelasDao extends PagingAndSortingRepository<Kelas, String> {
    
}
