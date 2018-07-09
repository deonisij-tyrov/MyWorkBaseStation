package dao.impl;


import dao.CellDAO;
import db.ConnectionManager;
import entities.BaseStation;
import entities.Cell;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CellDAOImpl implements CellDAO {
    private static final String creatCellQuery = "INSERT INTO cell (id, cell_name, sector, power_id, bs_id, band_id) VALUES (DEFAULT, ?, ?, ?, ?, ?);";
    private static final String updateCellQuery = "SET cell_name = ?, sector = ?,power = ?, bs_id = ?, band_id = ? WHERE id = ?;";
    private static final String readCellQuery = "SELECT * FROM cell WHERE id = ?;";
    private static final String deleteCellQuery = "DELETE FROM cell WHERE id = ?;";
    private static final String getReadCellQueryByBaseStation = "SELECT * FROM cell WHERE bs_id = ?;";
    private static final String creatBaseStation = "INSERT INTO bs (id, name) VALUES (?, ?);";
    private static final String getBaseStation = "SELECT * FROM bs WHERE id = ?;";
    private static final String getAllCell = "SELECT * FROM cell";
    private static volatile CellDAO INSTANCE = null;
    Connection connection;

    public CellDAOImpl() {
        connection = ConnectionManager.getConnection();
    }

    public static CellDAO getInstance() {
        CellDAO cellDAO = INSTANCE;
        if (cellDAO == null) {
            synchronized (CellDAOImpl.class) {
                cellDAO = INSTANCE;
                if (cellDAO == null) {
                    INSTANCE = cellDAO = new CellDAOImpl();
                }
            }
        }
        return cellDAO;
    }

    private static void close(ResultSet resultSet) {
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cell> getCellByBaseStation(BaseStation baseStation) throws SQLException {
        PreparedStatement psReadByBaseStation = connection.prepareStatement(getReadCellQueryByBaseStation);
        ArrayList<Cell> list = new ArrayList<>();
        psReadByBaseStation.setLong(1, baseStation.getId());
        ResultSet resultSet = psReadByBaseStation.executeQuery();
        addCellToList(list, resultSet);
        close(resultSet);
        return list;
    }

    @Override
    public void addNewBaseStationCells(BaseStation baseStation) throws SQLException {
        try {
            connection.setAutoCommit(false);
            addNewBaseStationIfNotExist(connection, baseStation);
            PreparedStatement preparedStatement = connection.prepareStatement(creatCellQuery);
            for (Cell cell : baseStation.getCells()) {
                preparedStatement.setString(1, cell.getName());
                preparedStatement.setInt(2, cell.getSector());
                preparedStatement.setInt(3, cell.getPower());
                preparedStatement.setLong(4, cell.getBsNumber());
                preparedStatement.setLong(5, cell.getBand());
                preparedStatement.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
    }

    private void addNewBaseStationIfNotExist(Connection connection, BaseStation baseStation) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(getBaseStation);
        preparedStatement.setLong(1, baseStation.getId());
        ResultSet resultSet = preparedStatement.getResultSet();
        if (!resultSet.next()) {
            preparedStatement = connection.prepareStatement(creatBaseStation);
            preparedStatement.setLong(1, baseStation.getId());
            preparedStatement.setString(2, baseStation.getName());
            preparedStatement.executeUpdate();
        }
        close(resultSet);
    }

    @Override
    public Cell save(Cell cell) throws SQLException {
        PreparedStatement psCreate = connection.prepareStatement(creatCellQuery, Statement.RETURN_GENERATED_KEYS);
        psCreate.setString(1, cell.getName());
        psCreate.setInt(2, cell.getSector());
        psCreate.setInt(3, cell.getPower());
        psCreate.setLong(4, cell.getBsNumber());
        psCreate.setLong(5, cell.getBand());
        psCreate.executeUpdate();
        ResultSet resultSet = psCreate.getGeneratedKeys();
        if (resultSet.next()) {
            cell.setId(resultSet.getLong(1));
        }
        close(resultSet);
        return cell;
    }

    @Override
    public Cell get(Long id) throws SQLException {
        PreparedStatement psRead = connection.prepareStatement(readCellQuery);
        Cell cell = new Cell();
        psRead.setLong(1, id);
        psRead.executeQuery();
        ResultSet resultSet = psRead.getResultSet();
        if (resultSet.next()) {
            cell.setId(resultSet.getLong(1));
            cell.setName(resultSet.getString(2));
            cell.setSector(resultSet.getInt(3));
            cell.setPower(resultSet.getInt(4));
            cell.setBsNumber(resultSet.getLong(5));
            cell.setBand(resultSet.getInt(6));
        }
        close(resultSet);
        psRead.close();
        return cell;
    }

    @Override
    public void update(Cell cell) throws SQLException {
        PreparedStatement psUpdate = connection.prepareStatement(updateCellQuery);
        psUpdate.setString(1, cell.getName());
        psUpdate.setInt(2, cell.getSector());
        psUpdate.setInt(3, cell.getPower());
        psUpdate.setLong(4, cell.getBsNumber());
        psUpdate.setInt(5, cell.getBand());
        psUpdate.setLong(6, cell.getId());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Long id) throws SQLException {
        PreparedStatement psDelete = connection.prepareStatement(deleteCellQuery);
        psDelete.setLong(1, id);
        return psDelete.executeUpdate();
    }

    @Override
    public List<Cell> readAll() throws SQLException {
        List<Cell> list = new ArrayList<>();
        PreparedStatement psReadAll = connection.prepareStatement(getAllCell);
        psReadAll.executeQuery();
        ResultSet resultSet = psReadAll.getResultSet();
        addCellToList(list, resultSet);
        close(resultSet);
        return list;
    }

    private void addCellToList(List<Cell> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            int sector = resultSet.getInt(3);
            int power = resultSet.getInt(4);
            long bsNumber = resultSet.getLong(5);
            int band = resultSet.getInt(6);
            list.add(new Cell(id, name, sector, power, bsNumber, band));
        }
    }
}
