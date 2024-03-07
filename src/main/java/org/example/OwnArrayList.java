package org.example;

import java.util.*;
import java.util.function.Consumer;

/**
 * Реализация собственного класса `ArrayList` с использованием дженериков.
 *
 * @param <E> Тип элементов, хранящихся в списке.
 */
public class OwnArrayList<E> implements Iterable<E> {

    private static final int capacity = 5;
    private int size = 0;
    private Object[] elements;

    /**
     * Конструктор по умолчанию, создающий пустой список.
     */
    public OwnArrayList(){
        elements = new Object[capacity];
    }

    /**
     * Увеличивает размер массива элементов в два раза.
     */
    private void resizeArray(){
        elements = Arrays.copyOf(elements, capacity * 2);
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param e Элемент, который нужно добавить.
     */
    public void add(E e){
        if (size == elements.length){
            resizeArray();
        }
        elements[size++] = e;
    }

    /**
     * Добавляет элемент в указанный индекс списка.
     *
     * @param index Индекс, в который нужно добавить элемент.
     * @param e Элемент, который нужно добавить.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка.
     */
    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        } else {
            if(size == elements.length){
                resizeArray();
            }
            size++;
            for(int i = size - 1; i > index; i--){
                elements[i] = elements[i-1];
            }
            elements[index] = e;
        }
    }

    /**
     * Возвращает размер списка.
     *
     * @return Размер списка.
     */
    public int size(){
        return size;
    }

    /**
     * Возвращает список в виде неизменяемого списка.
     *
     * @return Неизменяемый список элементов.
     */
    public List<E> showAsList(){
        return Arrays.asList(Arrays.copyOf((E[]) elements,size));
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index Индекс элемента.
     * @return Элемент по указанному индексу.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            return (E) elements[index];
        }
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index Индекс элемента, который нужно удалить.
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка.
     */
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

    /**
     * Очищает список.
     */
    public void clear(){
        elements = new Object[capacity];
        size = 0;
    }

    /**
     * Сортирует список с использованием компаратора.
     *
     * @param cmp Компаратор, который будет использоваться для сортировки.
     */
    public void sort(Comparator<? super E> cmp){
        sort((E[]) elements,0, size - 1, cmp);
    }

    /**
     * Часть алгоритма быстрой сортировки, которая выполняет рекурсивную сортировку.
     *
     * @param arr Массив элементов для сортировки.
     * @param start Начальный индекс для сортировки.
     * @param end Конечный индекс для сортировки.
     * @param cmp Компаратор, который будет использоваться для сортировки.
     */
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

    /**
     * Часть алгоритма быстрой сортировки, которая выполняет рекурсивную сортировку.
     *
     * @param a Массив элементов для сортировки.
     * @param i Начальный индекс для сортировки.
     * @param j Конечный индекс для сортировки.
     * @param cmp Компаратор, который будет использоваться для сортировки.
     */
    private void sort(E[]a, int i, int j,  Comparator<? super E> cmp) {
        if (i>=j) {
            return;
        }
        int pivot = partitioning(a, i, j,cmp);
        sort(a, i, pivot-1,cmp);
        sort(a, pivot+1, j,cmp);
    }


    /**
     * Возвращает итератор для списка.
     *
     * @return Итератор для списка.
     */
    @Override
    public Iterator<E> iterator(){
        return new OwnArrayListIterator<>();
    }

    /**
     * Итератор для списка.
     *
     * @param <T> Тип элементов, хранящихся в списке.
     */
    private class OwnArrayListIterator<T> implements Iterator<T> {
        private int currentIndex = 0;

        /**
         * Проверяет, есть ли следующий элемент в списке.
         *
         * @return `true` если есть следующий элемент, иначе `false`.
         */
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        /**
         * Возвращает следующий элемент в списке.
         *
         * @return Следующий элемент в списке.
         */
        @Override
        public T next() {
            return (T) elements[currentIndex++];
        }
    }

    /**
     * Выполняет указанное действие для каждого элемента в списке.
     *
     * @param action Действие, которое нужно выполнить для каждого элемента.
     */
    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    /**
     * Возвращает разделитель для параллельной обработки элементов списка.
     *
     * @return Разделитель для параллельной обработки.
     */
    @Override
    public Spliterator<E> spliterator() {
        return Iterable.super.spliterator();
    }

}
