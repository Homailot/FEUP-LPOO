package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;

public class ListAggregatorTest {
    List<Integer> list;


    @BeforeEach
    private void helper() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }


    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(new ListDeduplicator(new ListSorter()));

        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(new ListDeduplicator(new ListSorter()));

        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(new ListDeduplicator(new ListSorter()));

        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(anyList())).thenReturn(Arrays.asList(1, 2, 4, 5));

        ListAggregator aggregator = new ListAggregator(new ListDeduplicator(new ListSorter()));

        int distinct = aggregator.distinct(list);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_7263() {
        list.clear();
        list.add(-1);
        list.add(-4);
        list.add(-5);

        ListAggregator aggregator = new ListAggregator(new ListDeduplicator(new ListSorter()));
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void distinct_bug_8726() {
        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(anyList())).thenReturn(Arrays.asList(1, 2, 4));

        list.clear();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        ListAggregator aggregator = new ListAggregator(new ListDeduplicator(new ListSorter()));
        int distinct = aggregator.distinct(list);

        Assertions.assertEquals(3, distinct);
    }
}
