package dao;

import java.sql.SQLException;

public interface DAO<Entity, Key> {
    Entity save(Entity entity) throws SQLException;

    Entity get(Key key) throws SQLException;

    void update(Entity entity) throws SQLException;

    int delete(Key key) throws SQLException;
}