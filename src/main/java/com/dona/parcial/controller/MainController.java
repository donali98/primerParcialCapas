package com.dona.parcial.controller;

import java.util.List;

import javax.validation.Valid;

import com.dona.parcial.domain.Book;
import com.dona.parcial.domain.Category;
import com.dona.parcial.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("successMessage", "");
        mav.setViewName("index");
        return mav;
    }
    @GetMapping("/addCategory")
    public ModelAndView addCategory() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("add-category");
        mav.addObject("category", new Category());
        return mav;
    }

    @GetMapping("/addBook")
    public ModelAndView addBook() {
        ModelAndView mav = new ModelAndView();
        List<Category> categories = null;
        try{
            categories = categoryService.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        mav.setViewName("add-book");
        mav.addObject("book", new Book());
        mav.addObject("categories", categories);

        return mav;
    }
    
    @PostMapping("/saveCategory")
    public ModelAndView saveCategory(@Valid @ModelAttribute Category category, BindingResult result) {
        
        ModelAndView modelAndView = new ModelAndView();
        if(result.hasErrors()){
            modelAndView.addObject("category",category);
            modelAndView.setViewName("add-category");
        }else{
            categoryService.save(category);
            modelAndView.addObject("successMessage", "Categoria guardada con exito");
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }

}