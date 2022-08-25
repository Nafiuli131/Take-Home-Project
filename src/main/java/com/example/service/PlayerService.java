package com.example.service;

import com.example.model.Player;
import com.example.repository.PlayerRepo;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    PlayerRepo playerRepo;

    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }
    public Player addPlayer(Player player){
        return playerRepo.save(player);
    }
}
