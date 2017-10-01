package it.melo.todolist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by melo on 01/10/17.
 */
@Controller
public class AppController {
    @RequestMapping("/")
    public String home() {
        return "index";
    }

}