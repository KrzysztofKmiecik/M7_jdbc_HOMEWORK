package pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application.port.NewsClientApiService;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.Article;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsClientApiServiceUseCase implements NewsClientApiService {

    private final RestTemplate restTemplate;

    public NewsClientApiServiceUseCase() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<String> findAll() {
        Example example = restTemplate.getForObject("https://newsapi.org/v2/everything?q=Apple&from=2021-06-08&sortBy=popularity&apiKey=078e6e31bb955432f9d251d7030c18d9d", Example.class);
        List<Article> articleList = example.getArticles();
        List<String> news = articleList.stream()
                .map(article -> article.getDescription())
                .collect(Collectors.toList());
        return news;
    }
}
