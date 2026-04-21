package com.api.capstone.service;

import com.api.capstone.model.Board;

import java.util.List;

public interface BoardService {
    List<Board> getAllBoards();
    Board getBoardById(int id);
    Board createNewBoard(Board board);
    Board updateBoard(int id, Board board);
    void deleteBoard(int id);
}
