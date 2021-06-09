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

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/news")
class NewsController {
    private final NewsService service;

    @Autowired
    public NewsController(NewsService service) {
        this.service = service;
    }

    @GetMapping
    public String getNews(Model model) {
        model.addAttribute("newsList", service.getAllNews());
        model.addAttribute("newNews", new News());
        return "newsView";
    }

    @PostMapping
    public String updateNews(@Valid @ModelAttribute NewsCommand command) {
        service.updateNews(command.toNews());
        return "redirect:/news";
    }

    private static class NewsCommand {

        @NotNull
        private long id;
        @NotBlank
        private String news;
        @NotBlank
        private String publishedAt;

        public NewsCommand(long id, String news, String publishedAt) {
            this.id = id;
            this.news = news;
            this.publishedAt = publishedAt;
        }

        public long getId() {
            return id;
        }

        public String getNews() {
            return news;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public News toNews() {
            return new News(getId(), getNews(), getPublishedAt());
        }
    }
}
