package com.apresentacao.java.stream;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.apresentacao.java.auxiliary.User;

public class StreamsMapReduce {

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
	public void sumPointsJ7() {
		List<User> users = getUsers();

		int sumPoints = 0;

		for (User user : users) {
			if (user.getName().contains("i")) {
				sumPoints += user.getPoints();
			}
		}

		assertEquals(54, sumPoints);
	}

	@Test
	public void sumPointsJ8() {
		List<User> users = getUsers();

		int sumPoints = users.stream()//
				.filter(u -> u.getName().contains("i"))//
				.map(u -> u.getPoints())//
				.reduce((i1, i2) -> i1 + i2)//
				.orElse(0);

		assertEquals(54, sumPoints);
	}

	@Test
	public void sumPointsJ8v2() {
		List<User> users = getUsers();

		int sumPoints = users.stream()//
				.filter(u -> u.getName().contains("i"))//
				.mapToInt(u -> u.getPoints())//
				.sum();

		assertEquals(54, sumPoints);
	}

}
