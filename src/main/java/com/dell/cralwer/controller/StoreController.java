package com.dell.cralwer.controller;

import com.dell.cralwer.Utils.Tool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Controller
public class StoreController {

    @RequestMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("files", Tool.getAllFileTail("C:\\static\\img"));
        return "crawlerIndex";
    }
    @RequestMapping(value = {"/imgStore/{name}"})
    public String imgStore(@PathVariable("name") String name,Model model){
        model.addAttribute("files", Tool.getAllFileTail("C:\\static\\img"));
        model.addAttribute("imgUrl",Tool.getAllFileTail("C:\\static\\img\\"+name));
        return "crawlerIndex";
    }

}
