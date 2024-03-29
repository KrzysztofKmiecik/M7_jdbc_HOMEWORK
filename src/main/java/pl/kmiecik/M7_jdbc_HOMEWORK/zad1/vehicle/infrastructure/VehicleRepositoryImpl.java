package pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.domain.Vehicle;
import pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.domain.VehicleRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
class VehicleRepositoryImpl implements VehicleRepository {

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
                return new Vehicle(resultSet.getLong("id"),resultSet.getString("mark"),resultSet.getString("model"),resultSet.getInt("production"));
            }
        }) ;
    }

    @Override
    public void addVehicle(final Vehicle vehicle) {
        String sql ="INSERT INTO vehicle VALUES(?,?,?,?)" ;
        jdbcTemplate.update(sql,vehicle.getId(),vehicle.getMark(),vehicle.getModel(),vehicle.getProductionDate());
    }

    @Override
    public void deleteVehicle(final long id) {
        String sql="DELETE FROM vehicle WHERE vehicle.id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateVehicle(final Vehicle myVehicle) {
        String sql="UPDATE vehicle SET vehicle.mark=?, vehicle.model=?,vehicle.production=? WHERE vehicle.id=?";
        jdbcTemplate.update(sql,myVehicle.getMark(),myVehicle.getModel(),myVehicle.getProductionDate(),myVehicle.getId());
    }

}
