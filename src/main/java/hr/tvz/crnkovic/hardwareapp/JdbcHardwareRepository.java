package hr.tvz.crnkovic.hardwareapp;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        return Set.copyOf(jdbcTemplate.query(SELECT_ALL, this::mapRowToHardware))
                .stream().toList();
    }

    private Hardware mapRowToHardware(ResultSet resultSet, int i) throws SQLException {
        return new Hardware(
                resultSet.getString("name"),
                resultSet.getString("code"),
                resultSet.getDouble("price"),
                resultSet.getInt("amount"),
                Hardware.HardwareType.valueOf(resultSet.getString("type"))
        );
    }


    @Override
    public Optional<Hardware> findByCode(String code) {
        return Set.copyOf(jdbcTemplate
                .query("SELECT * FROM hardware WHERE code = "+code, this::mapRowToHardware))
                .stream().findFirst();
    }

    @Override
    public void remove(String code) {

    }

    @Override
    public Hardware save(Hardware hardware) {
        String code = hardware.getCode();
        String name = hardware.getName();
        Double price = hardware.getPrice();
        String type = hardware.getType().toString();
        Integer amount = hardware.getAmount();
        this.jdbcTemplate.execute("INSERT INTO hardware VALUES " +
                "("+code+",'"+name+"', "+price+", '"+type+"', "+amount+")");
        return hardware;
    }
}
