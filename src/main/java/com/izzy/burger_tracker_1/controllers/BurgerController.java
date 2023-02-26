package com.izzy.burger_tracker_1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.izzy.burger_tracker_1.models.Burger;
import com.izzy.burger_tracker_1.services.BurgerService;

@Controller
public class BurgerController {

  @Autowired
  BurgerService burgerService;

  // (in this case Read All & Create are on the same page)
  // ============ READ ALL ============
  // (usually the root of the application) 
  // ============ CREATE ============
  // (need 2 Routes - to Render & Post)
  // vvvvvvv RENDER vvvvvvv
  @GetMapping("/")
  public String index(@ModelAttribute("burger") Burger burger, Model model) {
    List<Burger> burgers = burgerService.allBurgers();
    model.addAttribute("burgers", burgers);
    return "index.jsp";
  }
  // vvvvvvv POST vvvvvvv
  @PostMapping("/burgers")
  public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
    if (result.hasErrors()) {
      return "index.jsp";
    } else {
      burgerService.createBurger(burger);
      return "redirect:/";
    }
  }
  
  // ============ UPDATE ============
  // (need 2 Routes - to Render & Post)
  // vvvvvvv RENDER vvvvvvv
  @GetMapping("burgers/edit/{id}")
  public  String edit(@PathVariable("id") Long id, Model model) {
    Burger burger = burgerService.findBurger(id);
    model.addAttribute("burger", burger);
    return "/edit.jsp";
  }
  // vvvvvvv POST vvvvvvv
  @PostMapping("/burgers/{id}")
  public String update(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
    if (result.hasErrors()) {
      return "/edit.jsp";
    } else {
      burgerService.updateBurger(burger);
    }
    return "redirect:/";
  }
  
  // ============ DELETE ============
  @DeleteMapping("/burgers/{id}")
  public String destroy(@PathVariable("id") Long id) {
    burgerService.deleteBurger(id);
    return "redirect:/";
  }


}
