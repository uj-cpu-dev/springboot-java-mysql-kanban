package com.ujdev.kanbanproject.controller;

import java.util.List;
import java.util.Optional;

import com.ujdev.kanbanproject.model.KanbanBoard;
import com.ujdev.kanbanproject.model.KanbanBoardSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ujdev.kanbanproject.services.KanbanBoardService;

@RestController
@RequestMapping("api/dashboard")
public class KanbanBoardController {

    @Autowired
    public KanbanBoardService kanbanBoardService;

    @GetMapping
    public ResponseEntity<?> getListOfBoards(){
        try {
            List<KanbanBoardSchema> boards = kanbanBoardService.getAllBoard();
            return new ResponseEntity<>(boards, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBoard(@PathVariable Integer id){
        try {
            Optional<KanbanBoardSchema> board = kanbanBoardService.getEachBoard(id);
            return new ResponseEntity<>(board, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createNewBoard(@RequestBody KanbanBoard kanbanBoard){
        try{
            kanbanBoardService.createNewBoard(kanbanBoard);
            return new ResponseEntity<>("BOARD CREATED", HttpStatus.CREATED);
        }catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable Integer id, @RequestBody KanbanBoard kanbanBoard){
        try{
            kanbanBoardService.updateBoard(id, kanbanBoard);
            return new ResponseEntity<>("BOARD UPDATED", HttpStatus.OK);
        } catch(Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoardById(@PathVariable  Integer id){
        try {
            kanbanBoardService.deleteBoard(id);
            return new ResponseEntity<>("BOARD DELETED", HttpStatus.OK);
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    
}
