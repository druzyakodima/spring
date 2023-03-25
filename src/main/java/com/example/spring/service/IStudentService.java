package com.example.spring.service;

import com.example.spring.entities.Student;

import java.util.List;

public interface IStudentService {
    public Student findById(Long id);

    public List<Student> findAll();

    public void deleteById(Long id);

    public Student saveOrUpdate(Student student);

}
