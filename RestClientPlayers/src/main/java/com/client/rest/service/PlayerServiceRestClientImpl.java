package com.client.rest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.client.rest.model.Players;

@Service
public class PlayerServiceRestClientImpl implements PlayerService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public PlayerServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Players> getPlayers() {
		
		logger.info("***OBTENER LISTA DE JUGADORES DESDE EL SERVICE REST CLIENTE");
		logger.info("in getPlayers(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Players>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
													 new ParameterizedTypeReference<List<Players>>() {});

		// get the list of customers from response
		List<Players> players = responseEntity.getBody();

		logger.info("in getPlayers(): players" + players);
		
		return players;
	}

	@Override
	public Players getPlayer(int theId) {
		logger.info("***OBTENER UN JUGADOR DESDE EL SERVICE REST CLIENTE");

		logger.info("in getPlayer(): Calling REST API " + crmRestUrl);

		// make REST call
		Players thePlayer = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Players.class);

		logger.info("in savePlayer(): thePlayer=" + thePlayer);
		
		return thePlayer;
	}

	@Override
	public void savePlayer(Players thePlayer) {

		logger.info("in savePlayer(): Calling REST API " + crmRestUrl);
		
		int playerId = thePlayer.getId();

		// make REST call
		if (playerId == 0) {
			// add employee
			logger.info("***SALVAR UN JUGADOR DESDE EL SERVICE REST CLIENTE");

			restTemplate.postForEntity(crmRestUrl, thePlayer, String.class);			
		
		} else {
			// update employee
			logger.info("***ACTUALIZAR UN JUGADOR DESDE EL SERVICE REST CLIENTE");

			restTemplate.put(crmRestUrl, thePlayer);
		}

		logger.info("in savePlayer(): success");	
	}

	@Override
	public void deletePlayer(int theId) {
		logger.info("***BORRAR UN JUGADOR DESDE EL SERVICE REST CLIENTE");

		logger.info("in deletePlayer(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deletePlayer(): deleted player theId=" + theId);
	}

}
