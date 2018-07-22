package dao.impl;

import dao.BaseStationDao;
import entities.BaseStation;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.sql.SQLException;


public class BaseStationDaoImplTest {
    @Rule
    private BaseStationDao baseStationDao = BaseStationDaoImpl.getInstance();

    @Test
    public void fullTest() throws SQLException {
        long countBeforeSave = baseStationDao.count();
        BaseStation baseStation = baseStationDao.save(new BaseStation(9999, "test"));
        long countAfterSave = baseStationDao.count();
        Assert.assertNotSame(countAfterSave, countBeforeSave);
        BaseStation readBaseStation = baseStationDao.get(baseStation.getId());
        Assert.assertEquals(baseStation, readBaseStation);

        baseStation.setName("test");
        baseStationDao.update(baseStation);
        readBaseStation = baseStationDao.get(baseStation.getId());
        Assert.assertEquals(baseStation, readBaseStation);

        baseStationDao.delete(baseStation.getId());
        countAfterSave = baseStationDao.count();
        Assert.assertEquals(countBeforeSave, countAfterSave);
    }
}
