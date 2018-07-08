package services;

import entities.BaseStation;
import entities.Cell;

import java.util.List;

public interface CellService {

    Cell save(Cell cell);

    Cell get(Long id);

    void update(Cell cell);

    int delete(Long id);

    List<Cell> getByBaseStation(BaseStation baseStation);
}
