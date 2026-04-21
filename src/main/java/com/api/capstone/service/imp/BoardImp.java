package com.api.capstone.service.imp;

import com.api.capstone.exception.NotFoundException;
import com.api.capstone.model.Board;
import com.api.capstone.repository.BoardRepository;
import com.api.capstone.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardImp implements BoardService {
    @Autowired
    private BoardRepository repository;

    @Override
    public List<Board> getAllBoards() {
        return repository.findAll();
    }

    @Override
    public Board getBoardById(int id) {
        Board search = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Board not found with id: " + id));

        return search;
    }

    @Override
    public Board createNewBoard(Board board) {
        return repository.save(board);
    }

    @Override
    public Board updateBoard(int id, Board board) {
        Board search = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Board not found with id: " + id));

        search.setNumber(board.getNumber());
        search.setCapacity(board.getCapacity());
        search.setState(board.getState());

        return repository.save(search);
    }

    @Override
    public void deleteBoard(int id) {
        Board search = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Board not found with id: " + id));

        repository.delete(search);
    }
}
