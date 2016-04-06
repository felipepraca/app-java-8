package com.apresentacao.java.stream;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class StreamsFlatLists {

	private List<List<String>> getList() {
		List<String> list1 = Arrays.asList("F", "e");
		List<String> list2 = Arrays.asList("l", "i");
		List<String> list3 = Arrays.asList("p", "e");

		return Arrays.asList(list1, list2, list3);
	}

	@Test
	public void flatJ7() {
		List<List<String>> lists = getList();
		List<String> flatList = new ArrayList<>();

		for (List<String> list : lists) {
			flatList.addAll(list);
		}

		StringBuilder flatListString = new StringBuilder();

		for (List<String> list : lists) {
			for (String character : list) {
				flatListString.append(character);
			}
		}

		assertEquals(Arrays.asList("F", "e", "l", "i", "p", "e"), flatList);
		assertEquals("Felipe", flatListString.toString());
	}

	@Test
	public void flatJ8() {
		List<List<String>> lists = getList();

		List<String> flatList = lists.stream()//
				.flatMap(list -> list.stream())//
				.collect(Collectors.toList());

		String flatListString = lists.stream()//
				.flatMap(list -> list.stream())//
				.reduce((s1, s2) -> s1 += s2)//
				.get();

		assertEquals(Arrays.asList("F", "e", "l", "i", "p", "e"), flatList);
		assertEquals("Felipe", flatListString);
	}

}
