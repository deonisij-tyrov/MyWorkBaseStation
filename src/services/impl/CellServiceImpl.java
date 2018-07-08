package services.impl;

import dao.CellDAO;
import dao.impl.CellDAOImpl;
import entities.BaseStation;
import entities.Cell;
import services.CellService;
import services.ServiceRuntimeExeption;

import java.sql.SQLException;
import java.util.List;

public class CellServiceImpl extends AbstractService implements CellService {
    private static volatile CellService INSTANCE = null;
    private CellDAO cellDAO = CellDAOImpl.getInstance();

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
            cell = cellDAO.save(cell);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error creating cell" + cell);
        }
        return cell;
    }

    @Override
    public Cell get(Long id) {
        try {
            return cellDAO.get(id);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error geting cell by id" + id);
        }
    }

    @Override
    public void update(Cell cell) {
        try {
            cellDAO.update(cell);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error updating cell" + cell);
        }
    }

    @Override
    public int delete(Long id) {
        try {
            return cellDAO.delete(id);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error deleting by id" + id);
        }

    }

    @Override
    public List<Cell> getByBaseStation(BaseStation baseStation) {
        try {
            return cellDAO.getCellByBaseStation(baseStation);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error getting cells by base station" + baseStation);
        }
    }
}
