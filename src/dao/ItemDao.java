package dao;


import entities.Item;

import java.sql.SQLException;


public interface ItemDao extends DAO<Item, Long> {
    int deleteByBaseStation(Long idBaseStation) throws SQLException;
}
