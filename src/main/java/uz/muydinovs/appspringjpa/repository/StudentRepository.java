package uz.muydinovs.appspringjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.muydinovs.appspringjpa.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
