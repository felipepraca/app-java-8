package com.apresentacao.java.auxiliary;

import java.util.Optional;

public class Client implements Comparable<Client> {

	private Integer id;
	private String address;

	public Client(int id) {
		this.id = id;
	}

	public Client(int id, String address) {
		this.id = id;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Optional<String> getOptionalAddress() {
		return Optional.ofNullable(address);
	}

	@Override
	public int compareTo(Client o) {
		return this.getOptionalAddress().orElse("").compareTo(o.getOptionalAddress().orElse(""));
	}
}
