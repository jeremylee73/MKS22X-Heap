import java.util.*;
public class MyHeap{
  private static void swap(int[] data, int a, int b){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
  private static void pushDown(int[] data,int size,int index){
    if (size == 0){
      throw new IllegalArgumentException("Empty array");
    }
    if (index >= size || index < 0){
      throw new IllegalArgumentException("Index out of bounds");
    }
    try{
      boolean pushed = false;
      while (!pushed){
        int a = 2 * index + 1;
        int b = 2 * index + 2;
        if (a >= size && b >= size){
          pushed = true;
        } else {
          int temp = data[index];
          if (a < size){
            temp = Math.max(temp, data[a]);
          }
          if (b < size){
            temp = Math.max(temp, data[b]);
          }
          if (temp == data[index]){
            pushed = true;
          } else if (a < size && temp == data[a]){
            swap(data, a, index);
            index = a;
          } else {
            swap(data, b, index);
            index = b;
          }
        }
      }
    } catch(ArrayIndexOutOfBoundsException e){
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  private static void pushUp(int[] data,int index){

  }
  public static void heapify(int[] data){

  }
  public static void heapsort(int[] data){

  }

  public static void toString(int[] data){
    String ans = "[";
    for (int i=0; i<data.length-1; i++){
      ans += data[i] + ",";
    }
    ans += data[data.length - 1] + "]";
    System.out.println(ans);
  }

  public static void main(String[] args){
    int[] data = {16,1,10,8,7,9,3,2,4,14};
    pushDown(data, data.length, 1);
    toString(data);
  }
}
