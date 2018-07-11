package services;

import entities.Board;

public interface BoardService {

    Board save(Board board);

    Board get(Long id);

    void update(Board cell);

    int delete(Long id);


}
