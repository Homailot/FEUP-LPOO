package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSorterTest {
    List<Integer> list;

    @BeforeEach
    private void helper() {
        list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(7);
    }

    @Test
    public void sort() {
        list.clear();
        list.add(25);
        list.add(20);
        list.add(13);
        list.add(15);
        list.add(13);
        list.add(12);
        list.add(11);

        List<Integer> expected = Arrays.asList(11,12,13,13,15,20,25);


        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }

    @Test
    public void sort_bug_8726() {
        list.clear();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        List<Integer> expected = Arrays.asList(1,2,2,4);

        ListSorter listSorter = new ListSorter();
        List<Integer> sorted = listSorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }
}
