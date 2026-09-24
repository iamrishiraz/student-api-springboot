package com.learningspringboot.student.student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class  studentsService {

    private final studentsRepository studentsRepository;
    @Autowired
    public studentsService(studentsRepository studentsRepository) {

        this.studentsRepository = studentsRepository;
    }
    public List<students> getStudents(){
        return studentsRepository.findAll();
    }

    public void registerstudents(students students) {
        Optional<students> studentsOptional =
                studentsRepository.findstudentsByEmail(students.getEmail());
        if(studentsOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentsRepository.save(students);
    }

    public void deletestudents(Long studentsId) {
        boolean exists=studentsRepository.existsById(studentsId);
        if(!exists){
            throw new IllegalStateException("student not found");
        }
        studentsRepository.deleteById(studentsId);
    }
    @Transactional
    public void updatestudents(Long studentsId,String name,String email) {

        students students=studentsRepository.findById(studentsId).orElseThrow(()->new IllegalStateException("student not found"));
        if(name!=null && name.length()>0 && !Objects.equals(name,students.getName())){
            students.setName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(email,students.getEmail())){
            Optional<students> studentOptional=studentsRepository.findstudentsByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            students.setEmail(email);
        }
    }

}
    