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
      if (size == 2){
        int lowerIndex = index + 1;
        if (data[lowerIndex] > data[index]){
          swap(data, index, lowerIndex);
        }
      }
      int a = 2 * index + 1;
      int b = 2 * index + 2;
      if (data[a] > data[b] && data[a] > data[index]){
        swap(data, a, index);
        pushDown(data, size, a);
      } else if (data[b] >= data[a] && data[b] > data[index]){
        swap(data, b, index);
        pushDown(data, size, b);
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

  public static void main(int[] args){
    
  }
}
