package pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application.port.NewsClientApiService;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.application.port.NewsService;

@Component
public class StartNews {

    private final NewsClientApiService newsClientApiService;
    private final NewsService service;

    public StartNews(NewsClientApiService newsClientApiService, NewsService service) {
        this.newsClientApiService = newsClientApiService;
        this.service = service;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void Init() {
      //  newsClientApiService.loadNewsFromApiToDb();
        //service.deleteAll();
    }


}
