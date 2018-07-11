package dao.impl;

import dao.BoardDao;
import entities.BaseStation;
import entities.Board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl extends AbstractDao implements BoardDao {
    private static final String updateBoardQuery = "UPDATE board SET type = ? WHERE serial_number = ?;";
    private static final String deleteBoardQuery = "DELETE FROM board WHERE serial_number = ?;";
    private static final String creatBoardQuery = "INSERT INTO board (serial_number, type) VALUES (?,?);";
    private static final String getBoardQuery = "SELECT * FROM board WHERE serial_number = ?;";
    private static final String getBoardByBaseStationQuery = "SELECT board.serial_number, board.type FROM board JOIN item " +
            "ON item.serial_board = board.serial_number WHERE item.id_base = ?;";
    private static volatile BoardDao INSTANCE = null;

    private BoardDaoImpl() {
    }

    public static BoardDao getInstance() {
        BoardDao boardDao = INSTANCE;
        if (boardDao == null) {
            synchronized (CellDaoImpl.class) {
                boardDao = INSTANCE;
                if (boardDao == null) {
                    INSTANCE = boardDao = new BoardDaoImpl();
                }
            }
        }
        return boardDao;
    }

    @Override
    public List<Board> getBoardByBaseStation(BaseStation baseStation) throws SQLException {
        PreparedStatement psReadByBaseStation = prepareStatement(getBoardByBaseStationQuery);
        ArrayList<Board> list = new ArrayList<>();
        psReadByBaseStation.setLong(1, baseStation.getId());
        psReadByBaseStation.executeQuery();
        ResultSet resultSet = psReadByBaseStation.getResultSet();
        while (resultSet.next()) {
            long serialNumber = resultSet.getLong(1);
            String type = resultSet.getString(2);
            list.add(new Board(serialNumber, type));
        }
        close(resultSet);
        return list;
    }

    @Override
    public Board save(Board board) throws SQLException {
        PreparedStatement preparedStatement = prepareStatement(getBoardQuery);
        preparedStatement.setLong(1, board.getSeerial());
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();
        if (!resultSet.next()) {
            preparedStatement = prepareStatement(creatBoardQuery);
            preparedStatement.setLong(1, board.getSeerial());
            preparedStatement.setString(2, board.getType());
            preparedStatement.executeUpdate();
        }
        close(resultSet);
        return board;
    }

    @Override
    public Board get(Long serial) throws SQLException {
        Board board = new Board();
        PreparedStatement preparedStatement = prepareStatement(getBoardQuery);
        preparedStatement.setLong(1, serial);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();
        if (resultSet.next()) {
            board.setSeerial(resultSet.getLong(1));
            board.setType(resultSet.getString(2));
        }
        close(resultSet);
        return board;
    }

    @Override
    public void update(Board board) throws SQLException {
        PreparedStatement psUpdate = prepareStatement(updateBoardQuery);
        psUpdate.setString(1, board.getType());
        psUpdate.setLong(2, board.getSeerial());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Long serial) throws SQLException {
        PreparedStatement psDelete = prepareStatement(deleteBoardQuery);
        psDelete.setLong(1, serial);
        return psDelete.executeUpdate();
    }
}
