import java.util.*;
public void quickSortC(T[] list, int length)
{
    recQuickSortC(list, 0, length - 1);
}//end quickSort

private void recQuickSortC(T[] list, int first, int last)
{
  if (first < last)
  {
	  Scanner scan = new Scanner(System.in);
	  int num = scan.nextInt();
	  int pivotIndex = partitionA(list, first, last);
      if ((pivotIndex - 1) >= num)
          recQuickSortC(list, first, pivotIndex - 1);
      else
          insertionSort(list,pivotIndex -1);

      if ((pivotIndex - 1) >= num)
          recQuickSortC(list, pivotIndex + 1, last);
      else
          insertionSort(list, pivotIndex + 1);
  }
}
	


private int partitionA(T[] list, int first, int last)
{
    T pivot;

    int smallIndex;

    swap(list, first, (first + last) / 2);

    pivot = list[first];
    smallIndex = first;

    for (int index = first + 1; index <= last; index++)
    {
        if (list[index].compareTo(pivot) < 0)
        {
            smallIndex++;
            swap(list, smallIndex, index);
        }
    }

    swap(list, first, smallIndex);

    return smallIndex;
}//end partition


    public void insertionSort(T[] list, int length)
{
    for (int unsortedIndex = 1; unsortedIndex < length;
                                unsortedIndex++)
    {
        Comparable<T> compElem =
                  (Comparable<T>) list[unsortedIndex];

        if (compElem.compareTo(list[unsortedIndex - 1]) < 0)
        {
            T temp = list[unsortedIndex];

            int pos = unsortedIndex;

            do
            {
                list[pos] = list[pos - 1];
                pos--;
            }
            while (pos > 0 &&
                   temp.compareTo(list[pos - 1]) < 0);

            list[pos] = (T) temp;
        }
    }
}
    }
