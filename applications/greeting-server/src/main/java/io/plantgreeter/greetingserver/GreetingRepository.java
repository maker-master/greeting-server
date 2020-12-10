package io.plantgreeter.greetingserver;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class GreetingRepository {

    private JdbcTemplate jdbcTemplate;

    public GreetingRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Greeting> list() {
        return jdbcTemplate.query("SELECT id, message FROM greeting", mapper) ;
    }

    private RowMapper<Greeting> mapper = (rs, rowNum) -> {
        return new Greeting(rs.getLong("id"), rs.getString("message"));
    };
}
