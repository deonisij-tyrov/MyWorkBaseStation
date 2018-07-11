package services.impl;

import dao.BoardDao;
import dao.impl.BoardDaoImpl;
import entities.Board;
import services.BoardService;
import services.ServiceRuntimeExeption;

import java.sql.SQLException;

public class BoardServiceImpl implements BoardService {
    private static volatile BoardService INSTANCE = null;
    private BoardDao boardDao = BoardDaoImpl.getInstance();

    public static BoardService getInstance() {
        BoardService boardService = INSTANCE;
        if (boardService == null) {
            synchronized (CellServiceImpl.class) {
                boardService = INSTANCE;
                if (boardService == null) {
                    INSTANCE = boardService = new BoardServiceImpl();
                }
            }
        }
        return boardService;
    }

    @Override
    public Board save(Board board) {
        try {
            boardDao.save(board);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error creating board" + board);
        }
        return board;
    }

    @Override
    public Board get(Long id) {
        try {
            return boardDao.get(id);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error geting board by id" + id);
        }
    }

    @Override
    public void update(Board board) {
        try {
            boardDao.update(board);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error updating boar" + board);
        }
    }

    @Override
    public int delete(Long id) {
        try {
            return boardDao.delete(id);
        } catch (SQLException e) {
            throw new ServiceRuntimeExeption("Error deleting by id" + id);
        }
    }
}
