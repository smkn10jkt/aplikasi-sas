/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.ui.controller;

import com.artivisi.school.administration.domain.Teacher;
import com.artivisi.school.administration.service.TeacherService;
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
public class TeacherController {
    @Autowired private TeacherService teacherService;
    
    @RequestMapping(value="/master/teacher", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Teacher t, HttpServletRequest request, HttpServletResponse response){
        teacherService.save(t);
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, t.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value="/master/teacher/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid Teacher t){
        Teacher teacherDb = teacherService.findTeacherById(id);
        if(teacherDb == null){
            throw  new IllegalStateException();
        }
        t.setId(teacherDb.getId());
        teacherService.save(t);
    }
    
    @RequestMapping(value="/master/teacher/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        Teacher teacherDb = teacherService.findTeacherById(id);
        if(teacherDb == null){
            throw new IllegalStateException();
        }
        teacherService.delete(teacherDb);
    }
    
    @RequestMapping(value="/master/teacher/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Teacher findById(@PathVariable String id){
        return teacherService.findTeacherById(id);
    }
    
    @RequestMapping(value="/master/teacher", method=RequestMethod.GET)
    @ResponseBody
    public Page<Teacher> findTeacher(Pageable pagination){
        return teacherService.findAllTeacher(pagination);
    }
}
