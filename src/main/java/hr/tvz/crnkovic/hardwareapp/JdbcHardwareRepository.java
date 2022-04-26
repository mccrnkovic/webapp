package hr.tvz.crnkovic.hardwareapp;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class JdbcHardwareRepository implements HardwareRepository {

    private static String SELECT_ALL = "SELECT * FROM hardware";

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public JdbcHardwareRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("hardware")
                .usingGeneratedKeyColumns("code");
    }

    @Override
    public List<Hardware> findAll() {
        return null;
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        return Optional.empty();
    }

    @Override
    public void remove(String code) {

    }
}
