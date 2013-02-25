/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.ui.controller;

import com.artivisi.school.administration.domain.Student;
import com.artivisi.school.administration.service.BelajarRestfulService;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;
/**
 *
 * @author dsemuts
 */
@Controller
public class StudentController {
    @Autowired private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/master/student", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Student student, HttpServletRequest request, HttpServletResponse response){
        belajarRestfulService.save(student);
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, student.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value="/master/student/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid Student student){
        Student studentDb = belajarRestfulService.findStudentById(id);
        if(studentDb == null){
            throw  new IllegalStateException();
        }
        student.setId(studentDb.getId());
        belajarRestfulService.save(student);
    }
    
    @RequestMapping(value="/master/student/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        Student studentDb = belajarRestfulService.findStudentById(id);
        if(studentDb == null){
            throw new IllegalStateException();
        }
        belajarRestfulService.delete(studentDb);
    }
    
    @RequestMapping(value="/master/student/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Student findById(@PathVariable String id){
        return belajarRestfulService.findStudentById(id);
    }
    
    @RequestMapping(value="/master/student", method=RequestMethod.GET)
    @ResponseBody
    public Page<Student> findStudent(Pageable pagination){
        return belajarRestfulService.findAllStudent(pagination);
    }
}
