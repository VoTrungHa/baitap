package com.restfulApi.VoTrungHaW4.Services;

import com.restfulApi.VoTrungHaW4.Models.Employ;
import com.restfulApi.VoTrungHaW4.Response.GenericResponse;
import org.springframework.stereotype.Service;


public interface AppService {
    GenericResponse<Object> getAllEmploy();
    GenericResponse<Object> getEmployById(Long id);
    GenericResponse<Object> createEmploy(Employ employ);
    GenericResponse<Object> updateEmploy(Employ employ,Long id);
    GenericResponse<Object> deleteEmploy(Long id);
}
