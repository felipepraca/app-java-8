package com.apresentacao.java.defaultmethod;

import java.util.Objects;

import com.apresentacao.java.auxiliary.Client;

public interface DefaultMethodExample {

	String abstractMethod();

	public default boolean defaultMethod(Client client) {

		if (Objects.isNull(client)) {
			return false;
		}

		if (Objects.isNull(client.getId())) {
			return false;
		}

		if (Objects.isNull(client.getAddress())) {
			return false;
		}

		return true;
	}
}
