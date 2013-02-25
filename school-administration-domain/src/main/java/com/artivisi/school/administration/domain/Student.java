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
 * @author dsemuts
 */
@Entity
@Table(name = "m_student")
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
    private String name;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String grade;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String majors;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String religion;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String sex;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String birth;
    
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
