package com.apresentacao.java.stream;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class StreamsFlatMap {

	private Map<String, Map<Integer, String>> getMaps() {
		Map<Integer, String> map1 = new HashMap<>();
		map1.put(1, "a");
		map1.put(2, "b");

		Map<Integer, String> map2 = new HashMap<>();
		map2.put(3, "c");
		map2.put(4, "d");

		Map<Integer, String> map3 = new HashMap<>();
		map3.put(5, "e");
		map3.put(6, "f");

		Map<String, Map<Integer, String>> maps = new HashMap<>();

		maps.put("map1", map1);
		maps.put("map2", map2);
		maps.put("map3", map3);

		return maps;
	}

	@Test
	public void flatMapJ7() {
		Map<String, Map<Integer, String>> maps = getMaps();

		List<String> flatMap = new ArrayList<>();

		for (Map<Integer, String> map : maps.values()) {
			flatMap.addAll(map.values());
		}

		flatMap.sort(String::compareTo);

		StringBuilder flatMaptString = new StringBuilder();

		for (String character : flatMap) {
			flatMaptString.append(character);
		}

		assertEquals(Arrays.asList("a", "b", "c", "d", "e", "f"), flatMap);
		assertEquals("abcdef", flatMaptString.toString());
	}

	@Test
	public void flatMapJ8() {
		Map<String, Map<Integer, String>> maps = getMaps();

		List<String> flatMap = maps.values().stream()//
				.flatMap(map -> map.values().stream())//
				.sorted()//
				.collect(Collectors.toList());

		String flatMaptString = maps.values().stream()//
				.flatMap(map -> map.values().stream())//
				.sorted()//
				.reduce((s1, s2) -> s1 += s2)//
				.get();

		assertEquals(Arrays.asList("a", "b", "c", "d", "e", "f"), flatMap);
		assertEquals("abcdef", flatMaptString);
	}
}
