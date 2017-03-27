package com.brahalla.strategy;

import java.util.Arrays;

public class BubbleSortStrategy implements SortStrategy {

  @Override
  public void sort(int[] array) {
    System.out.println(String.format("Performing bubble sort"));

    int n = array.length;
    int temp = 0;
    int checks = 0;
    int swaps = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 1; j < (n - i); j++) {
        checks++;
        if (array[j - 1] > array[j]) {
          temp = array[j - 1];
          array[j - 1] = array[j];
          array[j] = temp;
          swaps++;
        }
      }
    }

    System.out.println(String.format("Checks performed: %d", checks));
    System.out.println(String.format("Swaps performed: %d", swaps));
  }

}
