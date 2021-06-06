package com.example.demo.web;

import com.example.demo.domain.Project;
import com.example.demo.services.MapValidationService;
import com.example.demo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    MapValidationService validationService;

    @PostMapping("")
     public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
            if(result.hasErrors()) {

                return  validationService.mapValidationService(result);
            }

//            return new ResponseEntity<String>("Invalid Project Object",HttpStatus.BAD_REQUEST);
            //return new ResponseEntity<List<FieldError>>(result.getFieldErrors(),HttpStatus.BAD_REQUEST); It will return list of field errors as response
            //key should be value of field and value should be the value of message
            //not a good practice, logic shouldn't be in controller



       Project project1= projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }

}
