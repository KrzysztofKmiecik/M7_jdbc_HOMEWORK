package pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application.port.NewsService;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.News;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.NewsRepository;

import java.util.List;

@Service
public class NewsServiceUseCase implements NewsService {

    private final NewsRepository repository;

    @Autowired
    public NewsServiceUseCase(NewsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(News news) {
        repository.save(news);
    }

    @Override
    public List<News> getAllNews() {
        return repository.findAll();
    }

    @Override
    public void updateNews(News news) {
        repository.update(news);
    }


}
