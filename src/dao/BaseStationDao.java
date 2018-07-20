package dao;

import entities.BaseStation;

import java.sql.SQLException;
import java.util.List;

public interface BaseStationDao extends DAO<BaseStation, Long> {
    List<BaseStation> getAll() throws SQLException;

    List<BaseStation> getSomeTen(int from, int to) throws SQLException;
}
