package dao;

import entities.BaseStation;

import java.sql.SQLException;
import java.util.List;

public interface BaseStationDao extends DAO<BaseStation, Long> {
    List<BaseStation> readAll() throws SQLException;
}
