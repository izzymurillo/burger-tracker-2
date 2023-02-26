package com.izzy.burger_tracker_1.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity // <--represents an entity model for our app
@Table(name = "burgers") // <--sets this as a table in the database

public class Burger {

  @Id // <--sets this as the primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // <--sets this as an auto-incrementing value
  private Long id;

  @NotNull // <--adds validation that the column must not be null
  @Size(min = 3, max = 50, message = " Burger name must be at least 3 characters.") // <--adds validation that the column must be in the specified range
  private String burgerName;

  @NotNull
  @Size(min = 2, max = 50, message = " Restaurant name must be at least 2 characters.")
  private String restaurantName;

  @NotNull
  private Integer rating;

  @NotNull
  @Size(min = 2, max = 200, message = " Notes name must be at least 2 characters.")
  private String notes;

  // This will not allow the createdAt column to be updated after creation
  @Column(updatable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createdAt;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updatedAt;

  public Burger() { // <--(empty constructor)
  }

  public Burger(String burgerName, String restaurantName, Integer rating, String notes) {
    this.burgerName = burgerName;
    this.restaurantName = restaurantName;
    this.rating = rating;
    this.notes = notes;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBurgerName() {
    return this.burgerName;
  }

  public void setBurgerName(String burgerName) {
    this.burgerName = burgerName;
  }

  public String getRestaurantName() {
    return this.restaurantName;
  }

  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }

  public Integer getRating() {
    return this.rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getNotes() {
    return this.notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  @PrePersist //<-- runs the method right before the object is created
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate //<--runs a method when the object is modified
  protected void onUpdate() {
    this.updatedAt = new Date();
  }

}
