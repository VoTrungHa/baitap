package com.restfulApi.VoTrungHaW4.Repository;

import com.restfulApi.VoTrungHaW4.Models.Employ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployRepo  extends JpaRepository<Employ,Long> {

}
