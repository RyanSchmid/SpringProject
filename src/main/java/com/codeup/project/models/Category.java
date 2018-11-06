package com.codeup.project.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;

    @ManyToMany
    private List<Category> categories;

    public Category() {
    }

    public Category(long id, String name, List<Category> categories) {
        this.name = name;
        this.id = id;
        this.categories = categories;
    }

    public Category( String name, List<Category> categories) {
        this.name = name;
        this.categories = categories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void set(List<Category> ads) {
        this.categories = categories;
    }
}
