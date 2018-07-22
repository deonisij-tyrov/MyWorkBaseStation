package dao.impl;


import dao.BaseStationDao;
import dao.CellDao;
import entities.BaseStation;
import entities.Cell;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CellDaoImpl extends AbstractDao implements CellDao {
    private static final String creatCellQuery = "INSERT INTO cell (id, cell_name, sector, power_id, bs_id, band_id) VALUES (DEFAULT, ?, ?, ?, ?, ?);";
    private static final String updateCellQuery = "UPDATE cell SET cell_name = ?, sector = ?,power_id = ?, bs_id = ?, band_id = ? WHERE id = ?;";
    private static final String readCellQuery = "SELECT * FROM cell WHERE id = ?;";
    private static final String deleteCellQuery = "DELETE FROM cell WHERE id = ?;";
    private static final String getReadCellByBaseStationQuery = "SELECT * FROM cell WHERE bs_id = ?;";
    private static final String getAllCellQuery = "SELECT * FROM cell";
    private static final String deleteCellByBaseStationQuery = "DELETE FROM cell WHERE bs_id = ?;";
    private static volatile CellDao INSTANCE = null;
    private BaseStationDao baseStationDao = BaseStationDaoImpl.getInstance();


    private CellDaoImpl() {
    }

    public static CellDao getInstance() {
        CellDao cellDao = INSTANCE;
        if (cellDao == null) {
            synchronized (CellDaoImpl.class) {
                cellDao = INSTANCE;
                if (cellDao == null) {
                    INSTANCE = cellDao = new CellDaoImpl();
                }
            }
        }
        return cellDao;
    }


    @Override
    public List<Cell> getCellByBaseStationId(Long baseStationId) throws SQLException {
        PreparedStatement psReadByBaseStation = prepareStatement(getReadCellByBaseStationQuery);
        ArrayList<Cell> list = new ArrayList<>();
        psReadByBaseStation.setLong(1, baseStationId);
        psReadByBaseStation.executeQuery();
        ResultSet resultSet = psReadByBaseStation.getResultSet();
        addCellToList(list, resultSet);
        close(resultSet);
        return list;
    }

    @Override
    public void addCallsByBaseStation(BaseStation baseStation) throws SQLException {
        PreparedStatement preparedStatement = prepareStatement(creatCellQuery);
        Connection connection = preparedStatement.getConnection();
        try {
            connection.setAutoCommit(false);
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
            throw new SQLException(e.getMessage());
        }
    }


    @Override
    public Cell save(Cell cell) throws SQLException {
        PreparedStatement psCreate = prepareStatement(creatCellQuery, Statement.RETURN_GENERATED_KEYS);
        psCreate.setString(1, cell.getName());
        psCreate.setInt(2, cell.getSector());
        psCreate.setInt(3, cell.getPower());
        psCreate.setLong(4, cell.getBsNumber());
        psCreate.setLong(5, cell.getBand());
        psCreate.executeUpdate();
        ResultSet resultSet = psCreate.getGeneratedKeys();
        resultSet.next();
        cell.setId(resultSet.getInt(1));
        close(resultSet);
        return cell;
    }

    @Override
    public Cell get(Long id) throws SQLException {
        PreparedStatement psRead = prepareStatement(readCellQuery);
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
    public int deleteByBaseStation(long idBaseStation) throws SQLException {
        PreparedStatement preparedStatement = prepareStatement(deleteCellByBaseStationQuery);
        preparedStatement.setLong(1, idBaseStation);
        return preparedStatement.executeUpdate();
    }

    @Override
    public void update(Cell cell) throws SQLException {
        PreparedStatement psUpdate = prepareStatement(updateCellQuery);
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
        PreparedStatement psDelete = prepareStatement(deleteCellQuery);
        psDelete.setLong(1, id);
        return psDelete.executeUpdate();
    }

    @Override
    public List<Cell> readAll() throws SQLException {
        List<Cell> list = new ArrayList<>();
        PreparedStatement psReadAll = prepareStatement(getAllCellQuery);
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
