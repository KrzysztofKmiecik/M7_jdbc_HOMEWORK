package pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application.port;

import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.News;

import java.util.List;

public interface NewsClientApiService {
    List<String> findAll();
}
