package com.ujdev.kanbanproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ujdev.kanbanproject.model.KanbanBoard;
import com.ujdev.kanbanproject.repository.KanbanBoardRepository;

@Service
public class KanbanBoardService {
    
    @Autowired
    public KanbanBoardRepository kanbanBoardRepository;

    public List<KanbanBoard> getAllBoard(){
        return kanbanBoardRepository.findAll();
    }
}