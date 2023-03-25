package com.example.spring.controllers;

import com.example.spring.entities.Student;
import com.example.spring.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final IStudentService studentService;

    @GetMapping
    public List<Student> showAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveNewStudent(@RequestBody Student student) {
        student.setId(null);
        return studentService.saveOrUpdate(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.saveOrUpdate(student);
    }
}
