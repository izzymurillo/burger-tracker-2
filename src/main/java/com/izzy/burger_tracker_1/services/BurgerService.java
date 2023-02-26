// (THE SERVICE UTILIZES THE REPOSITORY)
// This is where we put all the CRUD methods

package com.izzy.burger_tracker_1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.izzy.burger_tracker_1.models.Burger;
import com.izzy.burger_tracker_1.repositories.BurgerRepository;

@Service // <-- tells Spring this is a service

public class BurgerService {

  // connect to the repository to access built-in methods
  @Autowired
  BurgerRepository burgerRepository;

  // ========== READ ALL ==========
  public List<Burger> allBurgers() {
    return burgerRepository.findAll();
  }

  // =========== CREATE ===========
  public Burger createBurger(Burger burger) {
    return burgerRepository.save(burger);
  }

  // ========== FIND BY ID ==========
  public Burger findBurger(Long id) {
    Optional<Burger> optionalBurger = burgerRepository.findById(id);
    if (optionalBurger.isPresent()) {
      return optionalBurger.get();
    } else {
      return null;
    }
  }

  // =========== UPDATE ===========
  // (exactly the same as create)
  public Burger updateBurger(Burger burger) {
    return burgerRepository.save(burger);
  }

}
