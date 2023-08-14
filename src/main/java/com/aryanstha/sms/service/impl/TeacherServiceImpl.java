package com.aryanstha.sms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aryanstha.sms.service.TeacherService;
import com.aryanstha.sms.repository.TeacherRepository;
import com.aryanstha.sms.entity.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

        private TeacherRepository teacherRepository;

        @Autowired
        public TeacherServiceImpl(TeacherRepository teacherRepository) {
            super();
            this.teacherRepository = teacherRepository;
        }

        @Override
        public List<Teacher> getAllTeachers() {
            return teacherRepository.findAll();
        }

        @Override
        public Teacher saveTeacher(Teacher teacher) {
            return teacherRepository.save(teacher);
        }

        @Override
    public Teacher getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId).get();
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}
