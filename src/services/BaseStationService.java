package services;

import entities.BaseStation;
import entities.Board;
import entities.Item;

public interface BaseStationService {

    BaseStation save(BaseStation baseStation);

    BaseStation get(Long id);

    void update(BaseStation baseStation);

    int delete(Long id);

    Item addBoard(Board board, BaseStation baseStation);
}
