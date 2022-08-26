package com.client.rest.model;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Data
public class Players {

	private int id;
	private String firstName;
	private String lastName;	
	private String email;
	private String sport;
	
}