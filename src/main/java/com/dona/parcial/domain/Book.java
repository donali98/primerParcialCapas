package com.dona.parcial.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(schema = "public",name = "cat_libro")
public class Book {

    @Column(name = "c_libro")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codBook;

    @NotEmpty(message = "El campo no debe estar vacio")
    @Size(max =500, message = "El campo no debe tener mas de 500 caracteres")
    @Column(name = "s_titulo")
    private String title;

    @NotEmpty(message = "El campo no debe estar vacio")
    @Size(max =150, message = "El campo no debe tener mas de 150 caracteres")
    @Column(name = "s_autor")
    private String author;

    @NotEmpty(message = "El campo no debe estar vacio")
    @Size(max =10, message = "El campo no debe tener mas de 10 caracteres")
    @Column(name = "s_isbn")
    private String isbn;


    @Column(name = "f_ingreso")
    @CreationTimestamp
    private LocalDateTime inDate;

    @Column(name = "b_estado")
    @NotNull(message = "El campo no debe estar vacio")
    private Boolean state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_categoria")
    private Category category;

    public Book() {}



    public Integer getCodBook() {
        return this.codBook;
    }

    public void setCodBook(Integer codBook) {
        this.codBook = codBook;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getInDate() {
        return this.inDate;
    }

    public void setInDate(LocalDateTime inDate) {
        this.inDate = inDate;
    }

    public Boolean isState() {
        return this.state;
    }

    public Boolean getState() {
        return this.state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDateDelegate() {
        if(this.inDate == null)
            return "";
        else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy h:mm a");
            String shortDate = this.inDate.format(formatter);
            return shortDate;
        }
    }



    public String getStatusDelegate(){
        if(this.state == null) return "";
        else return this.state == true ? "Activo" : "Inactivo";
    }

    
}