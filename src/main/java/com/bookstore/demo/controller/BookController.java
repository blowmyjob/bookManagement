package com.bookstore.demo.controller;

import com.bookstore.demo.service.BookService;
import com.bookstore.demo.entity.*;
import com.bookstore.demo.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.awt.print.Book;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Resource
    BookService bookService;

    @Resource
    CategoryService categoryService;

    @RequestMapping("/getAll")
    public String getAll(Model model){
        List<book>books=bookService.getAllBook();
        model.addAttribute("books",books);
        return "book/getAll";
    }

    @RequestMapping("/delBook")
    public String del(Model model,int id){
        bookService.delBook(id);
        return "redirect:/getAll";
    }

    @RequestMapping("/ToAddBook")
    public String add(book book,Model model){
        List<category>categories=categoryService.getAll();
        model.addAttribute("categories",categories);
        return "book/bookAdd";
    }

    @RequestMapping("/Add")
    public String toAdd(HttpServletRequest request,book book){
        bookService.addBook(book);
        return "redirect:/getAll";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam(name="id")int id,Model model){
        book book=bookService.getBook(id);
        List<category>categories=categoryService.getAll();
        model.addAttribute("book",book);
        model.addAttribute("categories",categories);
        return "book/bookEdit";
    }

    @RequestMapping("/toEdit")
    public String toEdit(HttpServletRequest request,book book){
        int categoty_id=Integer.valueOf(request.getParameter("category_id"));
        book.setCategory_id(categoty_id);
        bookService.delBook(book.getId());
        bookService.addBook(book);
        return "redirect:/getAll";
    }
}
