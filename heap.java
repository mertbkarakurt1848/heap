package heap;

import java.util.Scanner;

 //mert karakurt 02185076066

public class heap {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Diziye atilacak rakamlari virg�l ile ayirarak giriniz: ");

    String input = sc.nextLine();

 

    //say�lar� s�ras�yla diziye at�yoruz

    String[] numbers = input.split(",");

    int[] array = new int[numbers.length];

    for (int i = 0; i < array.length; i++) {

      array[i] = Integer.parseInt(numbers[i]);

    }

 

   //dizinin heap olup olmad���n� kontrol ediyoruz

    boolean isMinHeap = true;

    for (int i = 0; i < array.length; i++) {

      int leftChild = 2 * i + 1;

      int rightChild = 2 * i + 2;

 

      if (leftChild < array.length && array[i] > array[leftChild]) {

        isMinHeap = false;

        break;

      }

      if (rightChild < array.length && array[i] > array[rightChild]) {

        isMinHeap = false;

        break;

      }

    }

 

    // ��kt�m�z� al�yoruz

    if (isMinHeap) {

      System.out.println("Evet, min heap'tir.");

    } else {

      System.out.println("Hayır, min heap degildir.");

    }

 

    // diziyi min heap a d�d�r�yoru<

    for (int i = array.length / 2 - 1; i >= 0; i--) {

      heapify(array, array.length, i);

    }

 

    // min heap a d�nm�� halini yazdir�yoruz

    System.out.print("Heap hali: ");

    for (int i = 0; i < array.length; i++) {

      System.out.print(array[i] + " ");

    }

    System.out.println();

  }

 

  // diziyi min heap a �eviriyoruz

  public static void heapify(int[] array, int heapSize, int i) {

    int smallest = i;

    int leftChild = 2 * i + 1;

    int rightChild = 2 * i + 2;

 

    if (leftChild < heapSize && array[leftChild] < array[smallest]) {

      smallest = leftChild;

    }

   if (rightChild < heapSize && array[rightChild] < array[smallest]) {

      smallest = rightChild;

    }

    if (smallest != i) {

      int temp = array[i];

      array[i] = array[smallest];

      array[smallest] = temp;

 

      heapify(array, heapSize, smallest);

    }

  }

}