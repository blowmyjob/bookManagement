package com.bookstore.demo.controller;

import com.bookstore.demo.entity.category;
import com.bookstore.demo.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CategoryController {

    @Resource
    CategoryService categoryService;

    @RequestMapping("/category/getAll")
    public String getAll(Model model){
        List<category>categories=categoryService.getAll();
        model.addAttribute("categories",categories);
        return "category/getAll";
    }

    @RequestMapping("/category/toAdd")
    public String toAdd(){
        return "category/addCategory";
    }

    @ResponseBody
    @RequestMapping("/category/del")
    public String delete(@RequestParam(name="id")int id){
        categoryService.delCategory(id);
        return "1";
    }

    @RequestMapping("/category/edit")
    public String edit(@RequestParam(name="id")int id,Model model){
        category category=categoryService.queryCategoryById(id);
        model.addAttribute("category",category);
        return "category/categoryEdit";
    }

    @RequestMapping("/category/toEdit")
    public String toEdit(HttpServletRequest request, Model model){
        int id=Integer.valueOf(request.getParameter("CategoryId"));
        String name=request.getParameter("CategoryName");
        System.out.println(id);
        categoryService.updateById(id,name);
        return "redirect:/category/getAll";
    }
}
