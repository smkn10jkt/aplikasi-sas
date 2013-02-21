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
 * @author Fauzani
 */
@Entity @Table(name="m_class")
public class Kelas {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id_kelas;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="id_pk" , nullable = false)
    private Majors majors;
    
 
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String id_wali;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String tingkat;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String nama;

    public String getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(String id_kelas) {
        this.id_kelas = id_kelas;
    }

    public String getId_wali() {
        return id_wali;
    }

    public void setId_wali(String id_wali) {
        this.id_wali = id_wali;
    }

    public Majors getMajors() {
        return majors;
    }

    public void setMajors(Majors majors) {
        this.majors = majors;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTingkat() {
        return tingkat;
    }

    public void setTingkat(String tingkat) {
        this.tingkat = tingkat;
    }
    
    
}
