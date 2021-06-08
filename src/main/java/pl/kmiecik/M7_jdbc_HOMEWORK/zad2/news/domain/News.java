package pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain;

import java.util.StringJoiner;

public class News {
    private long id;
    private String news;
    private String publishedAt;

    public News(long id, String news, String publishedAt) {
        this.id = id;
        this.news = news;
        this.publishedAt = publishedAt;
    }

    public News() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", News.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("news='" + news + "'")
                .add("publishedAt='" + publishedAt + "'")
                .toString();
    }
}
