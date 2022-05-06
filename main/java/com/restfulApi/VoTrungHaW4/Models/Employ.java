package com.restfulApi.VoTrungHaW4.Models;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employ implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String userName;
    private String email;
    private String mobilePhone;
    private String address;

    public Employ(Long id, String userName, String email, String mobilePhone, String address) {
        Id = id;
        this.userName = userName;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.address = address;
    }
}
