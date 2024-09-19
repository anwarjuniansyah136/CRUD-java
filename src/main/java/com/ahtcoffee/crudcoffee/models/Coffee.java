package com.ahtcoffee.crudcoffee.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremen
    private Integer code;
    private String merk;
    private String type;
    private Long price;
}
