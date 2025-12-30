package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import com.sist.web.service.*;
import com.sist.web.vo.*;

@Controller
public class RecipeController {
  
   @GetMapping("/list")
   public String main_page()
   {
	   return "recipe/list";
   }
   @GetMapping("/detail")
   public String detail_page(
     @RequestParam("no") int no
   )
   {
	   return "recipe/detail";
   }
}
