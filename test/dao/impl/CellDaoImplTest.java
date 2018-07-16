package dao.impl;

import dao.CellDao;
import entities.Cell;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;


public class CellDaoImplTest {

    private CellDao cellDAO = CellDaoImpl.getInstance();

    @Test
    public void fullTest() throws SQLException {
        int countBeforeSave = cellDAO.readAll().size();
        Cell cell = cellDAO.save(new Cell("005-S2", 2, 0, 000, 3));
        int countAfterSave = cellDAO.readAll().size();
        Assert.assertNotSame(countAfterSave, countBeforeSave);
        Cell readCell = cellDAO.get(cell.getId());
        Assert.assertEquals(cell, readCell);

        cell.setPower(0);
        readCell = cellDAO.get(cell.getId());
        Assert.assertEquals(cell, readCell);

        cellDAO.delete(cell.getId());
        int countAfterDelete = cellDAO.readAll().size();
        Assert.assertEquals(countBeforeSave, countAfterDelete);
    }
}
