package com.apresentacao.java.optional;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.apresentacao.java.auxiliary.Client;

public class UsingOptional {

	private List<Client> getClients() {
		Client one = new Client(1, "Street one");
		Client two = new Client(2, "Street two");
		Client three = new Client(3, "Street three");
		Client four = new Client(4);
		Client five = new Client(5);
		Client six = new Client(6);

		return Arrays.asList(one, two, three, four, five, six);
	}

	@Test
	public void filterClientWithAddress() {
		List<Client> clients = getClients();
		List<String> address = new ArrayList<>();

		for (Client client : clients) {
			if (client.getAddress() != null) {
				address.add(client.getAddress());
			}
		}

		assertEquals(3, address.size());
		assertEquals("Street one", address.get(0));
		assertEquals("Street two", address.get(1));
		assertEquals("Street three", address.get(2));
	}

	@Test
	public void filterClientWithAddressUsingOptional() {
		List<Client> clients = getClients();
		List<String> address = new ArrayList<>();

		for (Client client : clients) {
			if (client.getOptionalAddress().isPresent()) {
				address.add(client.getOptionalAddress().get());
			}
		}

		assertEquals(3, address.size());
		assertEquals("Street one", address.get(0));
		assertEquals("Street two", address.get(1));
		assertEquals("Street three", address.get(2));
	}

	@Test
	public void filterClientWithAddressUsingOptional2() {
		List<Client> clients = getClients();
		List<String> address = new ArrayList<>();

		for (Client client : clients) {
			client.getOptionalAddress().ifPresent(s -> address.add(s));
		}

		assertEquals(3, address.size());
		assertEquals("Street one", address.get(0));
		assertEquals("Street two", address.get(1));
		assertEquals("Street three", address.get(2));
	}
	
	@Test
	public void filterClientWithAddressUsingOptional3() {
		List<Client> clients = getClients();
		List<String> address = new ArrayList<>();

		for (Client client : clients) {
			String customAddress = client.getOptionalAddress().orElse("Default");
			address.add(customAddress);
		}

		assertEquals(6, address.size());
		assertEquals("Street one", address.get(0));
		assertEquals("Street two", address.get(1));
		assertEquals("Street three", address.get(2));
		assertEquals("Default", address.get(3));
		assertEquals("Default", address.get(4));
		assertEquals("Default", address.get(5));
	}
}
