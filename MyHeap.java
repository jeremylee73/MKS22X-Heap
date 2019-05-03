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
    boolean pushed = false;
    while (!pushed){
      int a = (index - 1) / 2;
      if (a < 0){
        pushed = true;
      } else {
        if (data[index] > data[a]){
          swap(data, a, index);
          index = a;
        } else {
          pushed = true;
        }
      }
    }
  }
  public static void heapify(int[] data){
    int initial = (int)(Math.log(data.length)/Math.log(2.0));
    for (int i = (int)(Math.pow(2,initial)) - 2; i >= 0; i--) {
      pushDown(data, data.length, i);
    }
  }
  public static void heapsort(int[] data){
    heapify(data);
    for (int lastIndex = data.length - 1; lastIndex > 0; lastIndex--){
      swap(data, 0, lastIndex);
      pushDown(data, lastIndex, 0);
    }
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
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          MyHeap.heapsort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }
}
