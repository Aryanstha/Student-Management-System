package com.aryanstha.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aryanstha.sms.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
