package xin.qust.kg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("relation")
//@Controller
public class RelationWorkController {

    @RequestMapping("tag-task")
    public String tagTask(Model model) {
        model.addAttribute("name", "royalzzz");
        return "page/tag-task";
    }
}
