package com.client.rest.service;

import java.util.List;
import com.client.rest.model.Players;

public interface PlayerService {

	public List<Players> getPlayers();

	public void savePlayer(Players thePlayer);

	public Players getPlayer(int theId);

	public void deletePlayer(int theId);
	
}
