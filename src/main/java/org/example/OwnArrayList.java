package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class OwnArrayList<E> {

    private static final int capacity = 5;
    private int size = 0;
    private Object[] elements;

    public OwnArrayList(){
        elements = new Object[capacity];
    }

    private void resizeArray(){
        elements = Arrays.copyOf(elements, capacity * 2);
    }

    public void add(E e){
        if (size == elements.length){
            resizeArray();
        }
        elements[size++] = e;
    }

    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        } else {
            if(size == elements.length){
                resizeArray();
            }
            size++;
            elements[index] = e;
        }
    }
    public void showAll(){
        System.out.print("[");
        for(int i = 0; i < size; i++){
            System.out.print(elements[i] + " ");
        }
        System.out.print("]");
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            return (E) elements[index];
        }
    }

    public void remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {

            for(int i = index; i < size - 1; i++){
                elements[i] = elements[i+1];
            }
            size--;
        }
    }

    public void clear(){
        elements = new Object[capacity];
        size = 0;
    }

    public void sort(Comparator<? super E> cmp){
        sort((E[]) elements,0, size - 1, cmp);
    }

    private int partitioning(E[] arr, int start, int end, Comparator<? super E> cmp) {
        E pivot = arr[end];
        int balancePoint = start;
        for (int i = start; i < end; i++) {
            if(cmp.compare(arr[i],pivot) <=0) {
                E temp = arr[i];
                arr[i] = arr[balancePoint];
                arr[balancePoint] = temp;
                balancePoint++;
            }
        }
        E temp = arr[end];
        arr[end] = arr[balancePoint];
        arr[balancePoint] = temp;
        return balancePoint;
    }

    private void sort(E[]a, int i, int j,  Comparator<? super E> cmp) {
        if (i>=j) {
            return;
        }
        int pivot = partitioning(a, i, j,cmp);
        sort(a, i, pivot-1,cmp);
        sort(a, pivot+1, j,cmp);
    }

}
