package io.broudy.leetcode.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NestedInteger implements INestedInteger {

    private boolean integer;
    private int integerValue;
    private List<INestedInteger> list;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
        this.integer = false;
        this.integerValue = -1;
        this.list = new ArrayList<>();
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        this();
        this.integer = true;
        this.integerValue = value;
    }

    @Override
    public void add(INestedInteger ni) {
        this.integer = false;
        this.list.add(ni);
    }

    @Override
    public Integer getInteger() {
        return integer ? this.integerValue : null;
    }

    @Override
    public List<INestedInteger> getList() {
        return integer ? Collections.emptyList() : this.list;
    }

    @Override
    public boolean isInteger() {
        return this.integer;
    }

    @Override
    public void setInteger(int value) {
        this.integerValue = value;
        this.integer = true;
    }

    @Override
    public String toString() {
        if (integer) {
            return integerValue + "";
        }
        if (list.isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (INestedInteger iNestedInteger : list) {
            builder.append(iNestedInteger.toString());
            builder.append(",");
        }
        builder.delete(builder.length() - 1, builder.length());
        builder.append(']');
        return builder.toString();
    }

}
