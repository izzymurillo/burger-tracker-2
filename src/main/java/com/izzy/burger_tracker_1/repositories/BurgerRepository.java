package com.izzy.burger_tracker_1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.izzy.burger_tracker_1.models.Burger;

// ... (THE REPOSITORY CONNECTS TO THE DATABASE)

@Repository // <--tells Spring this is a repository

// create an interface that extends the CrudRepository (allows all CRUD
// operations)
public interface BurgerRepository extends CrudRepository<Burger, Long> { // (Long = id)

  // this method retrieves all burgers from the database
  List<Burger> findAll();

}
