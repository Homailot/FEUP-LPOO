package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        class StubDeduplicator implements IListDeduplicator {

            @Override
            public List<Integer> deduplicate() {
                return Arrays.asList(1,2,4,5);
            }
        }

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new StubDeduplicator());

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_7263() {
        list.clear();
        list.add(-1);
        list.add(-4);
        list.add(-5);

        ListAggregator aggregator = new ListAggregator(list);
        int max = aggregator.max();

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void distinct_bug_8726() {
        class StubDeduplicator implements IListDeduplicator {

            @Override
            public List<Integer> deduplicate() {
                return Arrays.asList(1,2,4);
            }
        }

        list.clear();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new StubDeduplicator());

        Assertions.assertEquals(3, distinct);
    }
}
