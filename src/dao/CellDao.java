package dao;


import entities.BaseStation;
import entities.Cell;

import java.sql.SQLException;
import java.util.List;

public interface CellDao extends DAO<Cell, Long> {
    List<Cell> getCellByBaseStation(BaseStation baseStation) throws SQLException;

    void addCallsByBaseStation(BaseStation baseStation) throws SQLException;

    List<Cell> readAll() throws SQLException;
}