package pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application.port.NewsClientApiService;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application.port.NewsService;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.Article;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.Example;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.News;

import java.util.List;

@Service
public class NewsClientApiServiceUseCase implements NewsClientApiService {

    public NewsClientApiServiceUseCase(NewsService service) {
        this.service = service;
        this.restTemplate = new RestTemplate();
    }

    private final NewsService service;
    private final RestTemplate restTemplate;
    private long counter;


    @Override
    public void loadNewsFromApiToDb() {
        Example example = restTemplate.getForObject("https://newsapi.org/v2/everything?q=Apple&from=2021-06-08&sortBy=popularity&apiKey=78e6e31bb955432f9d251d7030c18d9d", Example.class);
        List<Article> articleList = example.getArticles();
        News news = new News();
        articleList.stream()
                .forEach(article -> {
                    news.setId(++counter);
                    news.setNews(article.getDescription().replaceFirst("^(.{80}).*", "$1")); // limit to 80 chars
                    news.setPublishedAt(article.getPublishedAt());
                    service.save(news);
                });
    }
}
