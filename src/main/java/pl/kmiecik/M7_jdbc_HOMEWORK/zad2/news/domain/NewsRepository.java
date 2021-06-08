package pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain;

import java.util.List;

public interface NewsRepository {
    void save(News news);

    List<News> findAll();

    void update(News news);
}
