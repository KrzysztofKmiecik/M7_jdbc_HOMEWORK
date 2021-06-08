package pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.News;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad2.news.domain.NewsRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NewsRepositoryMySqlImpl implements NewsRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NewsRepositoryMySqlImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(News news) {
        String sql="INSERT INTO news SET news.id=?,news.news=?,news.published=?";
        jdbcTemplate.update(sql,news.getId(),news.getNews(),news.getPublishedAt());
    }

    @Override
    public List<News> findAll() {
        String sql="SELECT * FROM news";
        return jdbcTemplate.query(sql, new RowMapper<News>() {
            @Override
            public News mapRow(ResultSet resultSet, int i) throws SQLException {
                return  new News(resultSet.findColumn("id"),resultSet.getString("news"),resultSet.getString("published"));
            }
        });
    }

    @Override
    public void update(News news) {
        String sql="UPDATE news WHERE news.id=?";
        jdbcTemplate.update(sql,news.getId());
    }
}
