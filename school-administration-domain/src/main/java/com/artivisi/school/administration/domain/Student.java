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
 * @author dsemuts
 */
@Entity @Table(name="m_student")
public class Student {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String nis;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String nisn;
    
    @NotNull 
    @ManyToOne
    @JoinColumn(name="id_kelas" , nullable = false)
    @Column(nullable = false)
    private Kelas kelas;
    
    @NotNull 
    @ManyToOne
    @JoinColumn(name="id" , nullable = false)
    @Column(nullable = false)
    private Majors majors;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String name;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String religion;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String sex;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String placeofbirth;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String birthday;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String address;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String zipcode;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String phone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

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

    public Majors getMajors() {
        return majors;
    }

    public void setMajors(Majors majors) {
        this.majors = majors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    
}
