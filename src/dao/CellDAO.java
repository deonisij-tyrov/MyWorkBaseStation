package dao;


import entities.BaseStation;
import entities.Cell;

import java.sql.SQLException;
import java.util.List;

public interface CellDAO extends DAO<Cell, Long> {
    List<Cell> getCellByBaseStation(BaseStation baseStation) throws SQLException;

    void addNewBaseStationCells(BaseStation baseStation) throws SQLException;

    List<Cell> readAll() throws SQLException;
}
