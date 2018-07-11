package services.impl;

import dao.CellDao;
import dao.impl.CellDaoImpl;
import entities.BaseStation;
import entities.Cell;
import services.CellService;
import services.ServiceRuntimeExeption;

import java.sql.SQLException;
import java.util.List;

public class CellServiceImpl extends AbstractService implements CellService {
    private static volatile CellService INSTANCE = null;
    private CellDao cellDao = CellDaoImpl.getInstance();

    public static CellService getInstance() {
        CellService cellService = INSTANCE;
        if (cellService == null) {
            synchronized (CellServiceImpl.class) {
                cellService = INSTANCE;
                if (cellService == null) {
                    INSTANCE = cellService = new CellServiceImpl();
                }
            }
        }
        return cellService;
    }

    @Override
    public Cell save(Cell cell) {
        try {
            cell = cellDao.save(cell);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error creating cell" + cell);
        }
        return cell;
    }

    @Override
    public Cell get(Long id) {
        try {
            return cellDao.get(id);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error geting cell by id" + id);
        }
    }

    @Override
    public void update(Cell cell) {
        try {
            cellDao.update(cell);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error updating cell" + cell);
        }
    }

    @Override
    public int delete(Long id) {
        try {
            return cellDao.delete(id);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error deleting by id" + id);
        }

    }

    @Override
    public List<Cell> getByBaseStation(BaseStation baseStation) {
        try {
            return cellDao.getCellByBaseStation(baseStation);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error getting cells by base station" + baseStation);
        }
    }
}
