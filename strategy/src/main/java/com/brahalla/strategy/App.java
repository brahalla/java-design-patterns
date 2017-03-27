package com.brahalla.strategy;

import java.util.Arrays;

public class App {

  public static void main(String[] args) {

    int[] array = new int[] {20, 90, 5, 1, 9, 3, 32, 55, 12, 2, 19, 15, 50, 49, 14, 100, 6, 58, 35, 33, 34, 37, 31};
    System.out.println(String.format("Before sort: %s", Arrays.toString(array)));

    SortStrategy strategy = new BubbleSortStrategy();
    strategy.sort(array);
    System.out.println(String.format("After sort: %s", Arrays.toString(array)));

    array = new int[] {20, 90, 5, 1, 9, 3, 32, 55, 12, 2, 19, 15, 50, 49, 14, 100, 6, 58, 35, 33, 34, 37, 31};
    System.out.println(String.format("Before sort: %s", Arrays.toString(array)));

    strategy = new InsertionSortStrategy();
    strategy.sort(array);
    System.out.println(String.format("After sort: %s", Arrays.toString(array)));

  }

}
