package services.impl;

import entities.BaseStation;
import entities.Cell;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import services.BaseStationService;
import services.CellService;

import java.sql.SQLException;

public class BaseStationServiceImplTest extends TestCase {
    private BaseStationService baseStationService = BaseStationServiceImpl.getInstance();
    private CellService cellService = CellServiceImpl.getInstance();
    private BaseStation baseStation;
    private Cell currentCell;
    private Cell newCell;


    @Before
    protected void setUp() throws Exception {
        baseStation = baseStationService.save(new BaseStation(999, "test"));
        currentCell = cellService.save(new Cell("testCell", 0, 0, 999, 0));
        newCell = cellService.get(currentCell.getId());
    }

    @Test
    public void testDelete() throws SQLException {
        Assert.assertEquals(currentCell, newCell);
        baseStationService.delete(baseStation.getId());
        newCell = cellService.get(currentCell.getId());
        Assert.assertNotEquals(newCell, currentCell);
    }
}