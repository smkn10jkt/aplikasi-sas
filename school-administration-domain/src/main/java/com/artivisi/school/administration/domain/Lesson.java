/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Fauzani
 */

    
    @Entity @Table(name="data_matpel")
    public class Lesson {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id_matpel;
  
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String semester;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String nama_matpel;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String kkm;
    
     @NotNull @NotEmpty
    @Column(nullable = false)
    private String jml_kompetensi;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String deskripsi;

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getId_matpel() {
        return id_matpel;
    }

    public void setId_matpel(String id_matpel) {
        this.id_matpel = id_matpel;
    }

    public String getJml_kompetensi() {
        return jml_kompetensi;
    }

    public void setJml_kompetensi(String jml_kompetensi) {
        this.jml_kompetensi = jml_kompetensi;
    }

    public String getKkm() {
        return kkm;
    }

    public void setKkm(String kkm) {
        this.kkm = kkm;
    }

    public String getNama_matpel() {
        return nama_matpel;
    }

    public void setNama_matpel(String nama_matpel) {
        this.nama_matpel = nama_matpel;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    
    
}
