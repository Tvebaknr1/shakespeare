/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise1;

/**
 *
 * @author LouiseB
 */
public class Algorithms
{

    String[] array;
    String[] aux;

    public Algorithms(String[] array)
    {
        this.array = array;
    }

    public void selectionSort()
    {
        for (int j = 0; j < array.length - 1; j++)
        {
            String min = array[j];
            String temp;
            int minIndex = j;

            for (int i = j + 1; i < array.length; i++)
            {
                if (array[i].compareTo(min) < 0)
                {
                    min = array[i];
                    minIndex = i;
                }
            }
            temp = array[j];
            array[j] = min;
            array[minIndex] = temp;
        }
    }

    public String arrayToString()
    {
        String str = array[0] + ", ";
        for (int i = 1; i < array.length; i++)
        {
            if (!array[i].equals(array[i - 1])) 
            {
                str += array[i] + " , ";
            }
        }
        return str;
    }

    public void insertionSort()
    {
        for (int i = 1; i < array.length; i++)
        {
            String temp = array[i];
            int j;
            for (j = i - 1; (j >= 0) && (temp.compareTo(array[j]) < 1); j--)
            {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }
    }

    public void merge(String[] comparableArray, int low, int middle, int high)
    {
        int i = low, j = middle + 1;
        for (int k = low; k <= high; k++)
        {
            aux[k] = comparableArray[k];
        }
        for (int k = low; k <= high; k++)
        {
            if (i > middle)
            {
                comparableArray[k] = aux[j++];
            } else if (j > high)
            {
                comparableArray[k] = aux[i++];
            } else if (less(aux[j], aux[i]))
            {
                comparableArray[k] = aux[j++];
            } else
            {
                comparableArray[k] = aux[i++];
            }
        }
    }

    public void sort()
    {
        aux = new String[array.length];
        sort(array, 0, array.length - 1);

    }

    public void sort(String[] comparableArray, int low, int high)
    {
        if (high <= low)
        {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(comparableArray, low, mid);
        sort(comparableArray, mid + 1, high);
        merge(comparableArray, low, mid, high);
    }

    private boolean less(String v, String w)
    {
        return v.compareTo(w) < 1;
    }
}
