package com.aryanstha.sms.service;

import java.util.List;
import com.aryanstha.sms.entity.Teacher;
public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher saveTeacher(Teacher teacher);
    Teacher getTeacherById(Long teacherId);
    Teacher updateTeacher(Teacher teacher);
    void deleteTeacher(Long teacherId);
}
