package com.artivisi.school.administration.service;

import java.util.List;

import com.artivisi.school.administration.domain.ApplicationConfig;
import com.artivisi.school.administration.domain.Competency;
import com.artivisi.school.administration.domain.Job;
import com.artivisi.school.administration.domain.Lesson;
import com.artivisi.school.administration.domain.Kelas;
import com.artivisi.school.administration.domain.Menu;
import com.artivisi.school.administration.domain.Permission;
import com.artivisi.school.administration.domain.Role;
import com.artivisi.school.administration.domain.Student;
import com.artivisi.school.administration.domain.Teacher;
import com.artivisi.school.administration.domain.User;
import com.artivisi.school.administration.domain.Value;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BelajarRestfulService extends MonitoredService {
	// konfigurasi aplikasi
	void save(ApplicationConfig ac);
	void delete(ApplicationConfig ac);
	ApplicationConfig findApplicationConfigById(String id);
    Page<ApplicationConfig> findAllApplicationConfigs(Pageable pageable);
	Long countAllApplicationConfigs();
	Long countApplicationConfigs(String search);
	Page<ApplicationConfig> findApplicationConfigs(String search, Pageable pageable);
        
    // menu
    void save(Menu m);
    void delete(Menu m);
    Menu findMenuById(String id);
    List<Menu> findTopLevelMenu();
    Page<Menu> findAllMenu(Pageable pageable);
    Long countAllMenu();
    List<Menu> findMenuByParent(Menu m);
    List<Menu> findMenuNotInRole(Role r);
    
    // permission
    void save(Permission m);
    void delete(Permission m);
    Permission findPermissionById(String id);
    Page<Permission> findAllPermissions(Pageable pageable);
    Long countAllPermissions();
    List<Permission> findPermissionsNotInRole(Role r);
    
    // role
    void save(Role role);
    void delete(Role role);
    Role findRoleById(String id);
    Page<Role> findAllRoles(Pageable pageable);
    Long countAllRoles();
    
    // user
    void save(User m);
    void delete(User m);
    User findUserById(String id);
    User findUserByUsername(String username);
    Page<User> findAllUsers(Pageable pageable);
    Long countAllUsers();
    
    // teacher
    void save(Teacher teacher);
    void delete(Teacher teacher);
    Teacher findTeacherById(String id);
    Page<Teacher> findAllTeacher();
    Long countAllTeachers();
    
     //value
    void save(Value v);
    void delete(Value v);
    Kelas findValueById (String id);
    Page<Kelas> findAllValues();
    Long countAllValues();
    
    //competency
    void save(Competency c);
    void delete(Competency c);
    Kelas findCompetencyById (String id);
    Page<Kelas> findAllCompetencies();
    Long countAllCompetencies();
}