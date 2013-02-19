/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Pingkan
 */
@Entity @Table (name= "data_ekskul")
public class Ekskul {
    
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name = "system-uuid" , strategy= "uuid2")
    private String id_ekskul;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="id_siswa" , nullable=false)
    private Student student;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String semester;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String nama_ekskul;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String predikat;
    
}
