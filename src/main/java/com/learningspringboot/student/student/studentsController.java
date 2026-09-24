package com.learningspringboot.student.student;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(path="api/v1/students")
public class studentsController {
    private final studentsService studentsService;
    public studentsController(studentsService studentsService){

        this.studentsService = studentsService;
    }
    @GetMapping
    public List<students> getStudents(){

        return studentsService.getStudents();
    }
    @PostMapping
    public void registerstudents(@RequestBody students students  ){
        studentsService.registerstudents(students);
    }
    @DeleteMapping(path="{studentsId}")
    public void deleetstudents(@PathVariable("studentsId")Long id){
        studentsService.deletestudents(id);
    }
    @PutMapping(path="{studentsId}")
    public void updatestudents(
            @PathVariable("studentsId")Long studentsId,
            @RequestParam(required =false)String name,
            @RequestParam(required =false)String email){
        studentsService.updatestudents(studentsId,name,email);
    }



}
