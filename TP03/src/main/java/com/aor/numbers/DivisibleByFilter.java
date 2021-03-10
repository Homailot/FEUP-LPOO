package com.aor.numbers;

public class DivisibleByFilter implements IListFilter{
    int num;

    DivisibleByFilter(Integer integer) {
        this.num = integer;
    }

    @Override
    public boolean accept(Integer number) {
        return number % num == 0;
    }
}
