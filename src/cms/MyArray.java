/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms;

import java.util.Arrays;

public class MyArray<E> {

    private Object Array[] = new Object[10];
    private int pointer = 0;

    

    public void add(E element) {
        if (pointer < Array.length) {
            Array[pointer++] = element;
        } else {
            doubleCapacity();
            Array[pointer++] = element;
        }
    }

    


    public void doubleCapacity() {
        Object tmpArray[] = new Object[Array.length + Array.length / 2];
        for (int i = 0; i < Array.length; i++) {
            tmpArray[i] = Array[i];
        }
    //   Arrays.copyOf(Array, (double)(Array.length*1.5));
        Array = tmpArray;

    }

    public void remove(int index) {
        if (index < 0 || index >= Array.length) {
            return;
        }
        if (index == Array.length - 1) {
            Array[index] = null;
            pointer--;
        }

        for (int i = index; i < pointer - 1; i++) {
            Array[i] = Array[i + 1];
            
        }
        pointer--;

    }

    public boolean contain(Object e) {
        for (int i = 0; i < pointer; i++) {
            if (Array[i] == e) {
                return true;
            }
        }

        return false;
    }

    public boolean isEmpty() {
        if (pointer == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return pointer;
    }

    public E get(int index) {
        if (index < 0 || index == Array.length) {
            return null;
        }
        return (E)Array[index];
    }
    
    

}
