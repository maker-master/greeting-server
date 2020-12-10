package io.plantgreeter.plantserver;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class PlantRepository {

    private JdbcTemplate jdbcTemplate;

    public PlantRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Plant> list() {
        return jdbcTemplate.query("SELECT * FROM plant",
                rowMapper
        );
    }

    public Plant findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM plant WHERE id = ?", new Object[]{id}, resultSetExtractor);
    }

    public Plant create(Plant plant) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
                    PreparedStatement statement = conn.prepareStatement(
                            "INSERT INTO plant (name, description, height) VALUES (?,?,?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
                    statement.setString(1, plant.getName());
                    statement.setString(2, plant.getDescription());
                    statement.setFloat(3, plant.getHeight());

                    return statement;
                },
                keyHolder
        );
        return findById(keyHolder.getKey().longValue());
    }

    public Plant update(Long id, Plant plant) {
        jdbcTemplate.update("UPDATE plant SET name=?, description=?, height=? WHERE id=?",
                        plant.getName(),
                        plant.getDescription(),
                        plant.getHeight(),
                        id
                );
        return findById(id);
    }

    public boolean delete(Long id) {
        return jdbcTemplate.update("DELETE FROM plant WHERE id=?", id) > 0;
    }

    private RowMapper<Plant> rowMapper = (rs, rowNum) -> new Plant(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getFloat("height")
    );

    private ResultSetExtractor<Plant> resultSetExtractor = (rs) -> {
        return rs.next() ? rowMapper.mapRow(rs, 1) : null;
    };
}
