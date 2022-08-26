package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Player;

import org.springframework.batch.item.ItemProcessor;

public class PlayerProcessor implements ItemProcessor<Player,Player> {

    @Override
    public Player process(Player player) throws Exception {
        if(player.getEstado().equals("CDMX")) {
            return player;
        }
        return null;
    }
}