package com.apresentacao.java.defaultmethod;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.apresentacao.java.auxiliary.Client;

public class UsingDefaultMethod {

	private List<Client> getClients() {
		Client one = new Client(1);
		Client two = new Client(2);
		Client three = new Client(3);
		Client four = new Client(4);
		Client five = new Client(5);
		Client six = new Client(6);

		return Arrays.asList(six, four, three, two, five, one);
	}

	@Test
	public void sortString() {
		List<String> list = Arrays.asList("b", "d", "f", "a", "e", "c");

		Collections.sort(list);

		assertEquals(Arrays.asList("a", "b", "c", "d", "e", "f"), list);
	}

	@Test
	public void sortClients() {
		List<Client> clients = getClients();

		Collections.sort(clients);

		assertEquals(1, clients.get(0).getId().intValue());
		assertEquals(2, clients.get(1).getId().intValue());
		assertEquals(3, clients.get(2).getId().intValue());
		assertEquals(4, clients.get(3).getId().intValue());
		assertEquals(5, clients.get(4).getId().intValue());
		assertEquals(6, clients.get(5).getId().intValue());
	}

	@Test
	public void sortJ8() {
		List<Client> clients = getClients();

		clients.sort(new Comparator<Client>() {
			@Override
			public int compare(Client o1, Client o2) {
				return o1.getId().compareTo(o2.getId());
			}
		});

		assertEquals(1, clients.get(0).getId().intValue());
		assertEquals(2, clients.get(1).getId().intValue());
		assertEquals(3, clients.get(2).getId().intValue());
		assertEquals(4, clients.get(3).getId().intValue());
		assertEquals(5, clients.get(4).getId().intValue());
		assertEquals(6, clients.get(5).getId().intValue());
	}

	@Test
	public void sortJ8v2() {
		List<Client> clients = getClients();

		clients.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));

		assertEquals(1, clients.get(0).getId().intValue());
		assertEquals(2, clients.get(1).getId().intValue());
		assertEquals(3, clients.get(2).getId().intValue());
		assertEquals(4, clients.get(3).getId().intValue());
		assertEquals(5, clients.get(4).getId().intValue());
		assertEquals(6, clients.get(5).getId().intValue());
	}
}
