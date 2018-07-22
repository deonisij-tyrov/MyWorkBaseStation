package services.impl;

import dao.BaseStationDao;
import dao.CellDao;
import dao.ItemDao;
import dao.impl.BaseStationDaoImpl;
import dao.impl.CellDaoImpl;
import dao.impl.ItemDaoImpl;
import entities.BaseStation;
import entities.Board;
import entities.Item;
import services.BaseStationService;
import services.ServiceRuntimeExeption;

import java.sql.SQLException;
import java.util.List;

public class BaseStationServiceImpl implements BaseStationService {
    private static volatile BaseStationService INSTANCE = null;
    private BaseStationDao baseStationDao = BaseStationDaoImpl.getInstance();
    private ItemDao itemDao = ItemDaoImpl.getInstance();
    private CellDao cellDao = CellDaoImpl.getInstance();

    public static BaseStationService getInstance() {
        BaseStationService baseStationService = INSTANCE;
        if (baseStationService == null) {
            synchronized (CellServiceImpl.class) {
                baseStationService = INSTANCE;
                if (baseStationService == null) {
                    INSTANCE = baseStationService = new BaseStationServiceImpl();
                }
            }
        }
        return baseStationService;
    }

    @Override
    public BaseStation save(BaseStation baseStation) {
        try {
            baseStationDao.save(baseStation);
//            cellDao.addCallsByBaseStation(baseStation);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error creating baseStation" + baseStation);
        }
        return baseStation;
    }

    @Override
    public BaseStation get(Long id) {
        try {
            return baseStationDao.get(id);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error getting baseStation" + id);
        }
    }

    @Override
    public void update(BaseStation baseStation) {
        try {
            baseStationDao.update(baseStation);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error updating baseStation" + baseStation);
        }
    }

    @Override
    public int delete(Long id) {
        try {
//            itemDao.deleteByBaseStation(id);
            cellDao.deleteByBaseStation(id);
            return baseStationDao.delete(id);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error deleting baseStation" + id);
        }


    }

    @Override
    public long count() {
        try {
            return baseStationDao.count();
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error getting number of stations");
        }
    }

    @Override
    public Item addBoard(Board board, BaseStation baseStation) {
        Item item = new Item(board.getSeerial(), baseStation.getId());
        try {
            return itemDao.save(item);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error addBoard baseStation" + baseStation);
        }
    }

    @Override
    public List<BaseStation> getAll() {
        try {
            return baseStationDao.getAll();
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error getting baseStations");
        }
    }

    @Override
    public List<BaseStation> getPartOfStations(int from, int to) {
        try {
            return baseStationDao.getSomeTen(from, to);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error getting baseStations");
        }
    }
}
