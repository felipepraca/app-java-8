package com.apresentacao.java.stream;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.apresentacao.java.auxiliary.User;

public class StreamsFilterMap {

	private List<User> getUsers() {
		User tobias = new User(1, "Tobias", 10);
		User lucineia = new User(2, "Lucineia", 18);
		User creide = new User(3, "Creide", 6);
		User joreal = new User(4, "Jorel", 15);
		User shirley = new User(5, "Shirley", 13);
		User lucrecia = new User(6, "Lucrecia", 7);

		return Arrays.asList(tobias, lucineia, creide, joreal, shirley, lucrecia);
	}

	@Test
	public void filterNamesJ7() {
		List<User> users = getUsers();
		
		List<String> usersFiltered = new ArrayList<>();

		for (User user : users) {
			if (user.getName().contains("a")) {
				if (user.getPoints() >= 10) {
					usersFiltered.add(user.getName());
				}
			}
		}

		assertEquals(2, usersFiltered.size());
		assertEquals("Tobias", usersFiltered.get(0));
		assertEquals("Lucineia", usersFiltered.get(1));
	}

	@Test
	public void filterNamesJ8() {
		List<User> users = getUsers();
		
		List<String> usersFiltered = users.stream()//
				.filter(u -> u.getName().contains("a"))//
				.filter(u -> u.getPoints() >= 10)//
				.map(u -> u.getName())//
				.collect(Collectors.toList());
		
		assertEquals(2, usersFiltered.size());
		assertEquals("Tobias", usersFiltered.get(0));
		assertEquals("Lucineia", usersFiltered.get(1));
	}
}
