package com.groupName.studentregisterapplication.controller;

import com.groupName.studentregisterapplication.model.Student;
import com.groupName.studentregisterapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public List<Student> getStudentList() {
        return studentService.printStudent();
    }

    @PostMapping("/save")
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        Student foundStudent = studentService.getStudentById(id);
        return ResponseEntity.ok(foundStudent);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudentById(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);

        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
