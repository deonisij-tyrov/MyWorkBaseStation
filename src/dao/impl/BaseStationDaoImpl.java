package dao.impl;

import dao.BaseStationDao;
import entities.BaseStation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseStationDaoImpl extends AbstractDao implements BaseStationDao {
    private static final String updateBaseStationQuery = "UPDATE BASE_STATION SET name = ? WHERE id = ?;";
    private static final String deleteBaseStationQuery = "DELETE FROM BASE_STATION WHERE id = ?;";
    private static final String getAllBaseStationQuery = "SELECT * FROM BASE_STATION";
    private static final String creatBaseStationQuery = "INSERT INTO BASE_STATION (id, name) VALUES (?, ?);";
    private static final String getBaseStationQuery = "SELECT * FROM BASE_STATION WHERE id = ?;";
    private static final String getCountBaseStationQuery = "SElect Count(*) FROM BASE_STATION;";
    private static final String getSomeBaseStationQuery = "SELECT * FROM BASE_STATION ORDER BY id LIMIT ?, ?;";
    private static volatile BaseStationDao INSTANCE = null;

    private BaseStationDaoImpl() {
    }

    public static BaseStationDao getInstance() {
        BaseStationDao baseStationDao = INSTANCE;
        if (baseStationDao == null) {
            synchronized (CellDaoImpl.class) {
                baseStationDao = INSTANCE;
                if (baseStationDao == null) {
                    INSTANCE = baseStationDao = new BaseStationDaoImpl();
                }
            }
        }
        return baseStationDao;
    }

    @Override
    public List<BaseStation> getAll() throws SQLException {
        List<BaseStation> list = new ArrayList<>();
        PreparedStatement psReadAll = prepareStatement(getAllBaseStationQuery);
        psReadAll.executeQuery();
        ResultSet resultSet = psReadAll.getResultSet();
        while (resultSet.next()) {
            long id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            list.add(new BaseStation(id, name));
        }
        close(resultSet);
        return list;
    }

    @Override
    public long count() throws SQLException {
        PreparedStatement psReadAll = prepareStatement(getCountBaseStationQuery);
        psReadAll.executeQuery();
        ResultSet resultSet = psReadAll.getResultSet();
        resultSet.next();
        return resultSet.getInt(1);
    }

    @Override
    public List<BaseStation> getSomeTen(int from, int to) throws SQLException {
        List<BaseStation> list = new ArrayList<>();
        PreparedStatement preparedStatement = prepareStatement(getSomeBaseStationQuery);
        preparedStatement.setInt(1, from);
        preparedStatement.setInt(2, to);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            long id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            list.add(new BaseStation(id, name));
        }
        close(resultSet);
        return list;
    }

    @Override
    public BaseStation save(BaseStation baseStation) throws SQLException {
        PreparedStatement preparedStatement = prepareStatement(creatBaseStationQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setLong(1, baseStation.getId());
        preparedStatement.setString(2, baseStation.getName());
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        close(resultSet);
        return baseStation;
    }

    @Override
    public BaseStation get(Long id) throws SQLException {
        BaseStation baseStation = new BaseStation();
        PreparedStatement preparedStatement = prepareStatement(getBaseStationQuery);
        preparedStatement.setLong(1, id);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();
        if (resultSet.next()) {
            baseStation.setId(resultSet.getLong(1));
            baseStation.setName(resultSet.getString(2));
        }
        close(resultSet);
        return baseStation;
    }

    @Override
    public void update(BaseStation baseStation) throws SQLException {
        PreparedStatement psUpdate = prepareStatement(updateBaseStationQuery);
        psUpdate.setString(1, baseStation.getName());
        psUpdate.setLong(2, baseStation.getId());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Long id) throws SQLException {
        PreparedStatement psDelete = prepareStatement(deleteBaseStationQuery);
        psDelete.setLong(1, id);
        return psDelete.executeUpdate();
    }
}
