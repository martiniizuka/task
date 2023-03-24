package uk.co.iizuka.cars;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CarManager {
  JdbcTemplate jdbcTemplate;
  private List<Car> carList = new ArrayList<>();

  private CarManager(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Car> getAll() {
    return jdbcTemplate.query("SELECT * FROM cars", new CarMapper());
  }

  class CarMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet resultSet, int rowNum) throws SQLException {
      Car car = new Car();
      car.setId(resultSet.getInt("id"));
      car.setAge(resultSet.getInt("age"));
      car.setColour(resultSet.getString("colour"));
      car.setMake(resultSet.getString("make"));
      car.setModel(resultSet.getString("model"));
      return car;
    }
  }
}
