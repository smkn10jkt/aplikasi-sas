/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author dsemuts
 */
@Entity @Table(name="m_mapclass")
public class MapClass {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="id" , nullable = false)
    private Student student;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="id_kelas" , nullable = false)
    private Kelas kelas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Kelas getKelas() {
        return kelas;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
}
