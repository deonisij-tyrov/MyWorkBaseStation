package dao.impl;

import dao.CellDao;
import entities.Cell;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.sql.SQLException;


public class CellDaoImplTest {
    private CellDao cellDAO = CellDaoImpl.getInstance();

    @Test
    public void fullTest() throws SQLException {
        long countBeforeSave = cellDAO.readAll().size();
        Cell cell = cellDAO.save(new Cell("test", 2, 0, 0, 3));
        long countAfterSave = cellDAO.readAll().size();
        Assert.assertNotSame(countAfterSave, countBeforeSave);
        Cell readCell = cellDAO.get(cell.getId());
        Assert.assertEquals(cell, readCell);

        cell.setPower(1);
        cell.setSector(0);
        cell.setBsNumber(1);
        cell.setBand(1);
        cellDAO.update(cell);
        readCell = cellDAO.get(cell.getId());
        Assert.assertEquals(cell, readCell);

        cellDAO.delete(cell.getId());
        int countAfterDelete = cellDAO.readAll().size();
        Assert.assertEquals(countBeforeSave, countAfterDelete);
    }
}
