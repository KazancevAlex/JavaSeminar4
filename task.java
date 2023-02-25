// Реализовать алгоритм пирамидальной сортировки (HeapSort)


public class task {
  public static void main(String[] args) {
    task sorter = new task();
    int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
    System.out.println(java.util.Arrays.toString(array));
    sorter.sort(array);
    System.out.println(java.util.Arrays.toString(array));
  }

  public interface InplaceSort {
    public void sort(int[] values);
  }
  
  public void sort(int[] values) {
    task.heapsort(values);
  }

  private static void heapsort(int[] ar) {
    if (ar == null) return;
    int n = ar.length;
    
    for (int i = Math.max(0, (n / 2) - 1); i >= 0; i--) {
      sink(ar, n, i);
    }
    // Сортировка
    for (int i = n - 1; i >= 0; i--) {
      swap(ar, 0, i);
      sink(ar, i, 0);
    }
  }

  private static void sink(int[] ar, int n, int i) {
    while (true) {
      int left = 2 * i + 1; // Левая ветка
      int right = 2 * i + 2; // Правая ветка
      int largest = i;

      // Правый элемент больше главного
      if (right < n && ar[right] > ar[largest]) largest = right;

      // Левый элемент больше главного
      if (left < n && ar[left] > ar[largest]) largest = left;

      // Двигаемся вниз по дереву после самой большой ветки
      if (largest != i) {
        swap(ar, largest, i);
        i = largest;
      } else break;
    }
  }

  private static void swap(int[] ar, int i, int j) {
    int tmp = ar[i];
    ar[i] = ar[j];
    ar[j] = tmp;
  }
  
}