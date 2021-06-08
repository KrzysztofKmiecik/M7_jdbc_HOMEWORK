package pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application.port.NewsService;

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
        service.getAllNews();
        return "newsView";
    }
}
