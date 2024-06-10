package life.majiang.community.controller;

import life.majiang.community.dto.CommentDTO;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.service.CommentService;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Sam
 * @create 2024-06-03 9:21 PM
 */

@Controller
public class QuestionController {

  @Autowired
  private QuestionService questionService;

  @Autowired
  private CommentService commentService;

  @GetMapping("/question/{id}")
  public String question(@PathVariable(name = "id") Long id, Model model) {
    QuestionDTO questionDTO = questionService.getById(id);

    List<CommentDTO> comments = commentService.listByQuestionId(id);
    //增加累计阅读数
    questionService.incView(id);
    model.addAttribute("question", questionDTO);
    model.addAttribute("comments", comments);
    return "question";
  }
}