package uz.muydinovs.appspringjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.muydinovs.appspringjpa.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;


}
