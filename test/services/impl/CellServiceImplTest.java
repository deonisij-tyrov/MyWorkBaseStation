package services.impl;

import dao.BaseStationDao;
import dao.CellDao;
import dao.impl.BaseStationDaoImpl;
import dao.impl.CellDaoImpl;
import entities.BaseStation;
import entities.Cell;
import junit.framework.TestCase;
import org.junit.*;

import java.sql.SQLException;

public class CellServiceImplTest extends TestCase {
    @Rule
    private BaseStationDao baseStationDao = BaseStationDaoImpl.getInstance();
    @Rule
    private CellDao cellDAO = CellDaoImpl.getInstance();
    private BaseStation baseStation;
    private Cell currentCell;
    private Cell newCell;

    @Before
    public void set() throws Exception {
        baseStation = baseStationDao.save(new BaseStation(999, "test"));
        currentCell = cellDAO.save(new Cell("testCell", 0, 0, 999, 0));
        newCell = cellDAO.get(currentCell.getId());
    }

    @After
    public void tear() throws Exception {
        cellDAO.delete(currentCell.getId());
        baseStationDao.delete(baseStation.getId());
    }

    @Test
    public void testSave() throws SQLException {
        Assert.assertEquals(currentCell, newCell);
    }
}