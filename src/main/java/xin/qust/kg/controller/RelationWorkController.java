package xin.qust.kg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.qust.kg.domain.mysql.QuestionExcel;
import xin.qust.kg.domain.vo.QuestionGuideFormVo;
import xin.qust.kg.repository.mysql.QuestionExcelRepository;

import java.util.Optional;
import java.util.Set;

@RequestMapping("relation")
@Controller
public class RelationWorkController {

    @Autowired
    private QuestionExcelRepository questionExcelRepository;

    @RequestMapping("tag-task")
    public String tagTask(Model model) {
        return "/page/tag-task";
    }

    @RequestMapping("tag-task/question-guide")
    public String questionGuide(Model model, QuestionGuideFormVo questionGuideFormVo) {
        model.addAttribute("form", new QuestionGuideFormVo());
        Optional<QuestionExcel> questionExcel = questionExcelRepository.findByIsTaggedOrderByRand(false);
        int taggedCount = questionExcelRepository.countAllByIsTagged(true);
        int notTaggedCount = questionExcelRepository.countAllByIsTagged(false);
        questionExcel.ifPresent(excel -> model.addAttribute("question", excel));
        model.addAttribute("taggedCount", taggedCount);
        model.addAttribute("allCount", taggedCount + notTaggedCount);
        return "/page/question-guide";
    }

    @RequestMapping("tag-task/question-guide/post")
    public String questionGuideFormPost(QuestionGuideFormVo questionGuideFormVo) {
        System.out.println("vo" + questionGuideFormVo);
        return "redirect:/relation/tag-task/question-guide";
    }
}
