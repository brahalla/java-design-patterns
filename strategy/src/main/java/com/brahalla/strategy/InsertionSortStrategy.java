package com.brahalla.strategy;

public class InsertionSortStrategy implements SortStrategy {

  @Override
  public void sort(int[] array) {
    System.out.println(String.format("Performing insertion sort"));

    int n = array.length;
    int checks = 0;
    int swaps = 0;

    for (int i = 1; i < n; i++) {
      checks++;
      int temp = array[i];
      int j = i;
      while (j > 0 && array[j - 1] > temp) {
        array[j] = array[j - 1];
        j--;
        swaps++;
      }
      array[j] = temp;
    }

    System.out.println(String.format("Checks performed: %d", checks));
    System.out.println(String.format("Swaps performed: %d", swaps));
  }

}
