package services.impl;

import dao.ItemDao;
import dao.impl.ItemDaoImpl;
import entities.Item;
import services.ItemService;
import services.ServiceRuntimeExeption;

import java.sql.SQLException;

public class ItemServiceImpl implements ItemService {
    private static volatile ItemService INSTANCE = null;
    private ItemDao itemDao = ItemDaoImpl.getInstance();

    public static ItemService getInstance() {
        ItemService itemService = INSTANCE;
        if (itemService == null) {
            synchronized (CellServiceImpl.class) {
                itemService = INSTANCE;
                if (itemService == null) {
                    INSTANCE = itemService = new ItemServiceImpl();
                }
            }
        }
        return itemService;
    }

    @Override
    public Item save(Item item) {
        try {
            item = itemDao.save(item);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error creating Item" + item);
        }
        return item;
    }

    @Override
    public Item get(Long id) {
        try {
            return itemDao.get(id);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error geting Item by id " + id);
        }
    }

    @Override
    public void update(Item item) {
        try {
            itemDao.update(item);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error updating Item" + item);
        }
    }

    @Override
    public int delete(Long id) {
        try {
            return itemDao.delete(id);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error updating Item" + id);
        }
    }

}
