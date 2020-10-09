package com.kozachenko.lesson14;

import java.util.*;
import java.util.stream.Collectors;

public class CompareArrays {

    private int array1[];
    private int array2[];

    public CompareArrays() {
    }

    public CompareArrays(int[] array1, int[] array2) {
        this.array1 = array1;
        this.array2 = array2;
    }

    public Integer[] getSimilarListVersion(int[] a, int[] b) throws ArraysCompareException {
        List<Integer> arrayList1 = Arrays.asList(getArray(a));
        List<Integer> arrayList2 = Arrays.asList(getArray(b));
        arrayList1.retainAll(arrayList2);

        throw new ArraysCompareException("Wrong arrays!");
    }

    public Integer[] getSimilarMapVersion(int[] a, int[] b) throws ArraysCompareException {
        Map<Integer, Integer> map = new HashMap<>();
        int mediator[];
        if (a.length > b.length) {
            populateMap(a, map);
            mediator = a;
        } else {
            populateMap(b, map);
            mediator = b;
        }
        for (int i = 0; i < mediator.length; i++) {
            if (map.containsKey(mediator[i]) && map.get(mediator[i]) == null) {
                map.put(mediator[i], mediator[i]);
            }
        }

        return (Integer[]) map.values().stream()
                .filter(value -> value != null)
                .collect(Collectors.toList())
                .toArray();

    }

    private void populateMap(int[] a, Map<Integer, Integer> map) {
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], null);
        }
    }

    public int[] getDifferent() {
        throw new UnsupportedOperationException("asdf");
    }

    private Integer[] getArray(int[] a) {
        Integer array[] = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            array[i] = a[i];
        }
        return array;
    }

    public int[] getArray1() {
        return array1;
    }

    public void setArray1(int[] array1) {
        this.array1 = array1;
    }

    public int[] getArray2() {
        return array2;
    }

    public void setArray2(int[] array2) {
        this.array2 = array2;
    }
}
