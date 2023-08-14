package com.aryanstha.sms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aryanstha.sms.entity.Teacher;
import com.aryanstha.sms.service.TeacherService;
@Controller
public class TeacherController {
    private TeacherService TeacherService;

    public TeacherController(TeacherService TeacherService) {
        super();
        this.TeacherService = TeacherService;
    }

    //	List all Teachers
    @GetMapping("/Teachers")
    public String listTeachers(Model model) {
        model.addAttribute("Teachers", TeacherService.getAllTeachers());
        return "Teachers";
    }

    //	add Teacher
    @GetMapping("/Teachers/new")
    public String createTeacherForm(Model model) {

        // created Teacher object to hold Teacher form data
        Teacher Teacher = new Teacher();
        model.addAttribute("Teacher", Teacher);
        return "create_Teacher";
    }

    //	save Teacher
    @PostMapping("/Teachers")
    public String saveTeacher(@ModelAttribute("Teacher") Teacher Teacher) {
        TeacherService.saveTeacher(Teacher);
        return "redirect:/Teachers";
    }

    //	update Teacher from page
    @GetMapping("/Teachers/edit/{id}")
    public String editTeacher(@PathVariable Long id, Model model) {
        Teacher existingTeacher = TeacherService.getTeacherById(id);
        model.addAttribute("Teacher", existingTeacher);
        return "edit_Teacher";
    }


    //	update Teacher actual 
    @PostMapping("/Teachers/{id}")
    public String updateTeacher(@PathVariable Long id,
                                @ModelAttribute("Teacher") Teacher Teacher,
                                Model model) {
        // Get Teacher details from database
        Teacher existingTeacher = TeacherService.getTeacherById(id);
        existingTeacher.setId(Teacher.getId());
        existingTeacher.setFirstName(Teacher.getFirstName());
        existingTeacher.setLastName(Teacher.getLastName());
        existingTeacher.setEmail(Teacher.getEmail());

        // save updated Teacher object
        TeacherService.updateTeacher(existingTeacher);

        return "redirect:/Teachers";
    }


    //	delete Teacher
    @GetMapping("/Teachers/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        TeacherService.deleteTeacher(id);
        return "redirect:/Teachers";
    }

}
