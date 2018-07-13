package dao.impl;

import dao.ItemDao;
import entities.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDaoImpl extends AbstractDao implements ItemDao {
    private static final String updateItemQuery = "UPDATE item SET serial_board = ?, id_base = ?WHERE id = ?;";
    private static final String deleteItemQuery = "DELETE FROM item WHERE id = ?";
    private static final String creatItemQuery = "INSERT INTO item (id, serial_board, id_base) VALUES (DEFAULT ,1,2);";
    private static final String getItemQuery = "SELECT * FROM item WHERE id = ?;";
    private static final String deleteItemsByBaseStationQuery = "DELETE FROM item WHERE id_base = ?;";
    private static volatile ItemDao INSTANCE = null;

    private ItemDaoImpl() {
    }

    public static ItemDao getInstance() {
        ItemDao itemDao = INSTANCE;
        if (itemDao == null) {
            synchronized (CellDaoImpl.class) {
                itemDao = INSTANCE;
                if (itemDao == null) {
                    INSTANCE = itemDao = new ItemDaoImpl();
                }
            }
        }
        return itemDao;
    }

    @Override
    public Item save(Item item) throws SQLException {
        PreparedStatement preparedStatement = prepareStatement(creatItemQuery);
        preparedStatement.setLong(1, item.getSerialBoard());
        preparedStatement.setLong(2, item.getIdBaseStation());
        int id = preparedStatement.executeUpdate();
        item.setId(id);
        return item;
    }

    @Override
    public Item get(Long id) throws SQLException {
        Item item = new Item();
        PreparedStatement preparedStatement = prepareStatement(getItemQuery);
        preparedStatement.setLong(1, item.getId());
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();
        if (resultSet.next()) {
            item.setIdBaseStation(resultSet.getLong(3));
            item.setSerialBoard(resultSet.getLong(2));
            item.setId(id);
        }
        close(resultSet);
        return item;
    }

    @Override
    public void update(Item item) throws SQLException {
        PreparedStatement psUpdate = prepareStatement(updateItemQuery);
        psUpdate.setLong(1, item.getSerialBoard());
        psUpdate.setLong(2, item.getIdBaseStation());
        psUpdate.setLong(3, item.getId());
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Long id) throws SQLException {
        PreparedStatement psDelete = prepareStatement(deleteItemQuery);
        psDelete.setLong(1, id);
        return psDelete.executeUpdate();
    }

    @Override
    public int deleteByBaseStation(Long idBaseStation) throws SQLException {
        PreparedStatement psDelete = prepareStatement(deleteItemsByBaseStationQuery);
        psDelete.setLong(1, idBaseStation);
        return psDelete.executeUpdate();
    }
}
