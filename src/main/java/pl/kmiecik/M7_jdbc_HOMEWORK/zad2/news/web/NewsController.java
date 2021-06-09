package pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application.port.NewsService;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.News;

@Controller
@RequestMapping("/news")
public class NewsController {
    private final NewsService service;

    @Autowired
    public NewsController(NewsService service) {
        this.service = service;
    }

    @GetMapping
    public String getNews(Model model){
        model.addAttribute("newsList",service.getAllNews());
        model.addAttribute("newNews",new News());
        return "newsView";
    }

    @PostMapping
    public String updateNews(@ModelAttribute News news){
        service.updateNews(news);
        return "redirect:/news";
    }
}
