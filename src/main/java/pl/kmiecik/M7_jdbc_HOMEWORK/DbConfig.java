package pl.kmiecik.M7_jdbc_HOMEWORK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
class DbConfig {
    private final DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

   /* @EventListener(ApplicationReadyEvent.class)
    public void start(){
        String sql="CREATE TABLE vehicle(id int, mark varchar(255),model varchar(255),production int )"  ;
        getJdbcTemplate().update(sql);
    }*/


}
