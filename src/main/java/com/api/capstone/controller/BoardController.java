package com.api.capstone.controller;

import com.api.capstone.model.Board;
import com.api.capstone.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/mesas")
public class BoardController {
    @Autowired
    private BoardService service;

    @GetMapping
    public ResponseEntity<List<Board>> getAllBoard() {
        return ResponseEntity.ok(service.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable int id) {
        return ResponseEntity.ok(service.getBoardById(id));
    }

    @PostMapping
    public ResponseEntity<Board> createNewBoard(@RequestBody Board board) {
        Board Board = service.createNewBoard(board);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/mesas/{id}")
                .buildAndExpand(Board.getId())
                .toUri();

        return ResponseEntity.created(location).body(Board);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable int id, @RequestBody Board board) {
        return ResponseEntity.ok(service.updateBoard(id, board));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable int id) {
        service.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }
}
