package uz.muydinovs.appspringjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.muydinovs.appspringjpa.model.Student;
import uz.muydinovs.appspringjpa.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElseGet(Student::new);
    }

    //TODO check
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    //TODO
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String editStudent(@PathVariable("id") int id, @RequestBody Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            optionalStudent.get().setFirstName(student.getFirstName());
            optionalStudent.get().setLastName(student.getLastName());
            optionalStudent.get().setPhoneNumber(student.getPhoneNumber());
            studentRepository.save(optionalStudent.get());
            return "Successfully edited";
        }
        return "Student not found";
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String editStudent(@PathVariable("id") int id) {
        studentRepository.deleteById(id);
        return "Student deleted";
    }
}
