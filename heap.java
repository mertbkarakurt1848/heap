package heap;

import java.util.Scanner;

 //mert karakurt 02185076066

public class heap {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Diziye atilacak rakamlari virgül ile ayirarak giriniz: ");

    String input = sc.nextLine();

 

    //sayýlarý sýrasýyla diziye atýyoruz

    String[] numbers = input.split(",");

    int[] array = new int[numbers.length];

    for (int i = 0; i < array.length; i++) {

      array[i] = Integer.parseInt(numbers[i]);

    }

 

   //dizinin heap olup olmadýðýný kontrol ediyoruz

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

 

    // çýktýmýzý alýyoruz

    if (isMinHeap) {

      System.out.println("Evet, min heap'tir.");

    } else {

      System.out.println("HayÄ±r, min heap degildir.");

    }

 

    // diziyi min heap a dödürüyoru<

    for (int i = array.length / 2 - 1; i >= 0; i--) {

      heapify(array, array.length, i);

    }

 

    // min heap a dönmüþ halini yazdirýyoruz

    System.out.print("Heap hali: ");

    for (int i = 0; i < array.length; i++) {

      System.out.print(array[i] + " ");

    }

    System.out.println();

  }

 

  // diziyi min heap a çeviriyoruz

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