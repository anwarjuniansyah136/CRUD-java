package com.ahtcoffee.crudcoffee.reporitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahtcoffee.crudcoffee.models.Coffee;

public interface CoffeeRepository  extends JpaRepository<Coffee, Integer>{
    
}
