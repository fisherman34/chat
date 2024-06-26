package life.majiang.community.controller;

import life.majiang.community.dto.PaginationDTO;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Sam
 * @create 2024-04-29 2:51 PM
 */
@Controller
public class IndexController {

  @Autowired
  private QuestionService questionService;
  @GetMapping("/")
  public String index(Model model,
                      @RequestParam(name = "page", defaultValue = "1") Integer page,
                      @RequestParam(name = "size", defaultValue = "5") Integer size) {

    PaginationDTO pagination = questionService.list(page, size);  //list方法显示主页内容
    List<QuestionDTO> topViewedQuestions = questionService.selectTopViewedQuestions();

    model.addAttribute("pagination", pagination);
    model.addAttribute("topViewedQuestions", topViewedQuestions);

    return "index";
  }
}

