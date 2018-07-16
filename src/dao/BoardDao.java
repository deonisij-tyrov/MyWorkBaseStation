package dao;

import entities.BaseStation;
import entities.Board;

import java.sql.SQLException;
import java.util.List;

public interface BoardDao extends DAO<Board, Long> {
    List<Board> getBoardByBaseStation(BaseStation baseStation) throws SQLException;
}
