package com.client.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.client.rest.model.Players;
import com.client.rest.service.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayersController {

	// need to inject our customer service
	@Autowired
	private PlayerService playerService;
	
	@GetMapping("/list")
	public String listPlayers(Model theModel) {
		
		// get customers from the service
		List<Players> thePlayers = playerService.getPlayers();
				
		// add the customers to the model
		theModel.addAttribute("players", thePlayers);
		
		return "list-players";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Players thePlayer = new Players();
		
		theModel.addAttribute("player", thePlayer);
		
		return "player-form";
	}
	
	@PostMapping("/savePlayer")
	public String savePlayer(@ModelAttribute("player") Players thePlayer) {
		
		// save the customer using our service
		playerService.savePlayer(thePlayer);	
		
		return "redirect:/players/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("playerId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Players thePlayer = playerService.getPlayer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("player", thePlayer);
		
		// send over to our form		
		return "player-form";
	}
	
	@GetMapping("/delete")
	public String deletePlayer(@RequestParam("playerId") int theId) {
		
		// delete the customer
		playerService.deletePlayer(theId);
		
		return "redirect:/players/list";
	}
}










