package com.example.demo.model;

import com.example.demo.FareSettingApplication;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data

public class User {
@Id
    private Long Id;
    private String  plans;
   private  double Amount;
}

