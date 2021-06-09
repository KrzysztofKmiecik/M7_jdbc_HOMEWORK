package pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application.port.NewsClientApiService;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application.port.NewsService;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.Article;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.Example;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.News;

import java.util.List;

@Service
class NewsClientApiServiceUseCase implements NewsClientApiService {

    public NewsClientApiServiceUseCase(NewsService service) {
        this.service = service;
        this.restTemplate = new RestTemplate();
    }

    private final NewsService service;
    private final RestTemplate restTemplate;
    private long counter;

    @Value("${NewsClientApiServiceUseCase.apiKey:0}")
    private String apiKey;

    @Override
    public void loadNewsFromApiToDb() {
        Example example = restTemplate.getForObject("https://newsapi.org/v2/everything?q=Apple&from=2021-06-08&sortBy=popularity&apiKey="+apiKey, Example.class);
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
