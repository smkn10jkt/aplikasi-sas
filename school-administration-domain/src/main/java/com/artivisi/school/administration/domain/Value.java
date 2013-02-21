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

@Entity @Table(name="data_nilai")
public class Value {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id_nilai;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="id_matpel" , nullable = false)
    private Lesson lesson;    
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String id_matpel;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String id_kompetensi;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String id_siswa;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String semester;
    
    @NotNull @NotEmpty
    @Column(nullable = false) 
    private String nilai;

    public String getId_kompetensi() {
        return id_kompetensi;
    }

    public void setId_kompetensi(String id_kompetensi) {
        this.id_kompetensi = id_kompetensi;
    }

    public String getId_matpel() {
        return id_matpel;
    }

    public void setId_matpel(String id_matpel) {
        this.id_matpel = id_matpel;
    }

    public String getId_nilai() {
        return id_nilai;
    }

    public void setId_nilai(String id_nilai) {
        this.id_nilai = id_nilai;
    }

    public String getId_siswa() {
        return id_siswa;
    }

    public void setId_siswa(String id_siswa) {
        this.id_siswa = id_siswa;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
}
