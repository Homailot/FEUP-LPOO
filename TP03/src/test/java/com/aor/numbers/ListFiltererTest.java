package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

public class ListFiltererTest {

    @Test
    public void filter() {
        IListFilter filter = Mockito.mock(IListFilter.class);
        Mockito.when(filter.accept(anyInt())).thenReturn(false);
        Mockito.when(filter.accept(1)).thenReturn(true);
        Mockito.when(filter.accept(2)).thenReturn(true);

        List<Integer> list = Arrays.asList(1,2,3,4,5,1,2,3,4,2);
        List<Integer> expected = Arrays.asList(1,2,1,2,2);

        ListFilterer listFilterer = new ListFilterer(list);

        Assertions.assertEquals(expected, listFilterer.filter(filter));
    }

    @Test
    public void posFilter() {
        List<Integer> list = Arrays.asList(-1,2,-3,4,5,-1,2,-3,4,2);
        List<Integer> expected = Arrays.asList(2,4,5,2,4,2);

        ListFilterer listFilterer = new ListFilterer(list);

        Assertions.assertEquals(expected, listFilterer.filter(new PositiveFilter()));
    }

    @Test
    public void divideByFilter() {
        List<Integer> list = Arrays.asList(-1,2,-3,4,5,-2,2,-3,4,2);
        List<Integer> expected = Arrays.asList(2,4,-2,2,4,2);

        ListFilterer listFilterer = new ListFilterer(list);

        Assertions.assertEquals(expected, listFilterer.filter(new DivisibleByFilter(2)));
    }
}
