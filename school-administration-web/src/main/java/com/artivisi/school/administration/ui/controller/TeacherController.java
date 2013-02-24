/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.ui.controller;

import com.artivisi.school.administration.domain.Teacher;
import com.artivisi.school.administration.service.BelajarRestfulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.net.URI;
import org.springframework.web.util.UriTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 *
 * @author dsemuts
 */
@Controller
public class TeacherController {
    @Autowired private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/master/teacher", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Teacher t, HttpServletRequest request, HttpServletResponse response){
        belajarRestfulService.save(t);
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, t.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value="/master/teacher/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid Teacher t){
        Teacher teacherDb = belajarRestfulService.findTeacherById(id);
        if(teacherDb == null){
            throw  new IllegalStateException();
        }
        t.setId(teacherDb.getId());
        belajarRestfulService.save(t);
    }
    
    @RequestMapping(value="/master/teacher/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        Teacher teacherDB = belajarRestfulService.findTeacherById(id);
        if(teacherDB == null){
            throw new IllegalStateException();
        }
        belajarRestfulService.delete(teacherDB);
    }
    
    @RequestMapping(value="/master/teacher/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Teacher findById(@PathVariable String id){
        return belajarRestfulService.findTeacherById(id);
    }
    
    @RequestMapping(value="/master/teacher", method=RequestMethod.GET)
    @ResponseBody
    public Page<Teacher> findTeacher(Pageable pagination){
        return belajarRestfulService.findAllTeacher(pagination);
    }
}
