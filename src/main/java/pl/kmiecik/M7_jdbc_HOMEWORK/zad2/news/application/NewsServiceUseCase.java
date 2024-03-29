package pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application;

import org.springframework.stereotype.Service;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application.port.NewsService;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.News;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.NewsRepository;

import java.util.List;

@Service
class NewsServiceUseCase implements NewsService {

    private final NewsRepository repository;


    public NewsServiceUseCase(NewsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(News news) {
        List<News> allById = repository.findAllById(news.getId());
        if (allById.isEmpty()) {
            repository.save(news);
        } else {
            allById.forEach(myNews -> repository.update(myNews));
        }
    }

    @Override
    public List<News> getAllNews() {
        return repository.findAll();
    }

    @Override
    public void updateNews(News news) {
        repository.update(news);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }


}
