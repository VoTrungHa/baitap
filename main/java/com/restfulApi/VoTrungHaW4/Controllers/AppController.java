package com.restfulApi.VoTrungHaW4.Controllers;

import com.restfulApi.VoTrungHaW4.Models.Employ;
import com.restfulApi.VoTrungHaW4.Response.GenericResponse;
import com.restfulApi.VoTrungHaW4.Services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/employ")
@RestController
public class AppController {

    @Autowired
    AppService appService;

    @GetMapping("")
    public ResponseEntity<GenericResponse> getAllEmploys() {
        return ResponseEntity.ok(appService.getAllEmploy());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse> getEmployById(@PathVariable Long id) {
        return ResponseEntity.ok(appService.getEmployById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<GenericResponse> createEmploy(@RequestBody Employ employ) {
        return ResponseEntity.ok(appService.createEmploy(employ));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GenericResponse> updateEmploy(@RequestBody Employ employ, @PathVariable Long id) {
        return ResponseEntity.ok(appService.updateEmploy(employ, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GenericResponse> deleteEmploy(@PathVariable Long id) {
        return ResponseEntity.ok(appService.deleteEmploy(id));
    }


}
