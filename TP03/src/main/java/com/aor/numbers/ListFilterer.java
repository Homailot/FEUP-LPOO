package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    List<Integer> list;

    ListFilterer(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> filter(IListFilter filter) {
        List<Integer> result = new ArrayList<>();

        for(Integer integer: list) {
            if(filter.accept(integer)) {
                result.add(integer);
            }
        }

        return result;
    }
}
