package pl.kmiecik.M7_jdbc_HOMEWORK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VehicleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Vehicle> findAll() {


        String sql="SELECT * FROM vehicle"  ;
        return jdbcTemplate.query(sql, new RowMapper<Vehicle>() {
            @Override
            public Vehicle mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Vehicle(resultSet.getLong("id"),resultSet.getString("name"));
            }
        }) ;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        String sql ="INSERT INTO vehicle VALUES(?,?)" ;
        jdbcTemplate.update(sql,vehicle.getId(),vehicle.getName());
    }

    @Override
    public void deleteVehicle(long id) {
        String sql="DELETE FROM vehicle WHERE vehicle.id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateVehicle(Vehicle myVehicle) {
        String sql="UPDATE vehicle SET vehicle.name=? WHERE vehicle.id=?";
        jdbcTemplate.update(sql,myVehicle.getName(),myVehicle.getId());
    }

    public void createTable() {
        String sql = "CREATE TABLE vehicle(id int, name varchar(255) )";
        jdbcTemplate.update(sql);
    }
}
