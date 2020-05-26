package com.dona.parcial.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public",name = "cat_categoria")
public class Category {

    @Column(name = "c_categoria")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCategory;

    @NotEmpty(message = "El campo no debe estar vacio")
    @Size(max =50, message = "El campo no debe tener mas de 50 caracteres")
    @Column(name = "s_categoria")
    private String category;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Book> books;


    public Category() {}


    public Integer getCodCategory() {
        return this.codCategory;
    }

    public void setCodCategory(Integer codCategory) {
        this.codCategory = codCategory;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}