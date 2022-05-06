package com.restfulApi.VoTrungHaW4.Services;

import com.restfulApi.VoTrungHaW4.Models.Employ;
import com.restfulApi.VoTrungHaW4.Repository.EmployRepo;
import com.restfulApi.VoTrungHaW4.Response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AppServiceImlp implements AppService {

    @Autowired
    EmployRepo employRepo;

    @Override
    public GenericResponse<Object> getAllEmploy() {
        try {
            return GenericResponse.builder().code(HttpStatus.OK.value())
                    .message("Success")
                    .status("200")
                    .result(employRepo.findAll())
                    .build();
        } catch (Exception ex) {
            return GenericResponse.builder().code(HttpStatus.OK.value())
                    .message(ex.getMessage())
                    .status("200")
                    .build();
        }
    }

    @Override
    public GenericResponse<Object> getEmployById(Long id) {
        try {
            Optional<Employ> employ = employRepo.findById(id);
            return GenericResponse.builder().code(HttpStatus.OK.value())
                    .message("Success")
                    .status("200")
                    .result(employ.get())
                    .build();
        } catch (Exception ex) {
            return GenericResponse.builder().code(HttpStatus.OK.value())
                    .message(ex.getMessage())
                    .status("400")
                    .build();
        }
    }

    @Override
    public GenericResponse<Object> createEmploy(Employ employ) {
        try {
            Employ em = Employ.builder()
                    .Id(employ.getId())
                    .email(employ.getEmail())
                    .userName(employ.getUserName())
                    .mobilePhone(employ.getMobilePhone())
                    .address(employ.getAddress()).build();
            employRepo.save(em);
            return GenericResponse.builder().code(HttpStatus.OK.value())
                    .message("Success")
                    .status("200")
                    .build();
        } catch (Exception ex) {
            return GenericResponse.builder().code(HttpStatus.OK.value())
                    .message(ex.getMessage())
                    .status("400")
                    .build();
        }
    }

    @Override
    public GenericResponse<Object> updateEmploy(Employ request, Long id) {
        try {
            employRepo.findById(id).map(employ ->
            {
                employ.setAddress(request.getAddress());
                employ.setEmail(request.getEmail());
                employ.setMobilePhone(request.getMobilePhone());
                employ.setId(request.getId());
                employ.setUserName(request.getUserName());
                return employRepo.save(request);
            }).orElseGet(() -> {
                request.setId(id);
                return employRepo.save(request);
            });

            return GenericResponse.builder().code(HttpStatus.OK.value())
                    .message("Success")
                    .status("200")
                    .build();
        } catch (Exception ex) {
            return GenericResponse.builder().code(HttpStatus.OK.value())
                    .message(ex.getMessage())
                    .status("400")
                    .build();
        }
    }

    @Override
    public GenericResponse<Object> deleteEmploy(Long id) {
        try {
            boolean exists = employRepo.existsById(id);
            if (exists) {
                employRepo.deleteById(id);
                return GenericResponse.builder().code(HttpStatus.OK.value())
                        .message("Success")
                        .status("200")
                        .build();
            }
            return GenericResponse.builder().code(HttpStatus.OK.value())
                    .message("failed")
                    .status("400")
                    .build();

        } catch (Exception ex) {
            return GenericResponse.builder().code(HttpStatus.OK.value())
                    .message(ex.getMessage())
                    .status("400")
                    .build();
        }
    }
}
