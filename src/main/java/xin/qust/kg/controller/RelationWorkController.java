package xin.qust.kg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.qust.kg.domain.mysql.HiddenDangerCheck;
import xin.qust.kg.domain.mysql.QuestionExcel;
import xin.qust.kg.domain.mysql.QuestionGuideRelation;
import xin.qust.kg.domain.vo.QuestionGuideFormVo;
import xin.qust.kg.repository.mysql.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequestMapping("relation")
@Controller
public class RelationWorkController {

    @Autowired
    private QuestionExcelRepository questionExcelRepository;
    @Autowired
    private HiddenDangerCheckRepository hiddenDangerCheckRepository;
    @Autowired
    private HiddenDangerCheckTypeRepository hiddenDangerCheckTypeRepository;
    @Autowired
    private HiddenDangerCheckItemRepository hiddenDangerCheckItemRepository;
    @Autowired
    private QuestionGuideRelationRepository questionGuideRelationRepository;

    @RequestMapping("tag-task")
    public String tagTask(Model model) {
        return "/page/tag-task";
    }

    @RequestMapping("tag-task/question-guide")
    public String questionGuide(Model model) {
        QuestionGuideFormVo questionGuideFormVo = new QuestionGuideFormVo();
        Optional<QuestionExcel> questionExcel = questionExcelRepository.findByIsTaggedOrderByRand(false);
        List<HiddenDangerCheck> hiddenDangerChecks = hiddenDangerCheckRepository.findAll();
        int taggedCount = questionExcelRepository.countAllByIsTagged(true);
        int notTaggedCount = questionExcelRepository.countAllByIsTagged(false);
        questionExcel.ifPresent(excel -> {
            model.addAttribute("question", excel);
            questionGuideFormVo.setQuestionId(excel.getId());
            model.addAttribute("form", questionGuideFormVo);
        });
        model.addAttribute("checkList", hiddenDangerChecks);
        model.addAttribute("taggedCount", taggedCount);
        model.addAttribute("allCount", taggedCount + notTaggedCount);
        return "/page/question-guide";
    }

    @RequestMapping("tag-task/question-guide/post")
    public String questionGuideFormPost(QuestionGuideFormVo questionGuideFormVo) {
        if (questionGuideFormVo.getCheckItemId() != null) {
            QuestionGuideRelation questionGuideRelation = new QuestionGuideRelation();
            questionGuideRelation.setCheckItemId(questionGuideFormVo.getCheckItemId());
            questionGuideRelation.setQuestionId(questionGuideFormVo.getQuestionId());
            Optional<QuestionExcel> question = questionExcelRepository.findById(questionGuideFormVo.getQuestionId());
            if (question.isPresent()) {
                question.get().setTagged(true);
                questionExcelRepository.save(question.get());
            }
            questionGuideRelationRepository.save(questionGuideRelation);
        }
        return "redirect:/relation/tag-task/question-guide";
    }
}
