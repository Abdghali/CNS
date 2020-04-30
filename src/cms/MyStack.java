/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms;

/**
 *
 * @author ArchTasneem
 */
public class MyStack<T> {

    private Object myStack[] = new Object[10];
    static int pointer = 0;

    public Object[] getMyStack() {
        return myStack;
    }

    public void clear() {
        for (int i = 0; i < myStack.length; i++) {
            myStack[i] = null;
        }
    }

    public T push(T element) {

        T tmp = element;
        if (pointer == myStack.length) {
            doubleCapacity();
            myStack[pointer++] = element;
        }
        myStack[pointer++] = element;
        return tmp;
    }

    public void doubleCapacity() {
        Object tmp[] = new Object[myStack.length * 2];
        for (int i = 0; i < myStack.length; i++) {
            tmp[i] = myStack[i];
        }
        myStack = tmp;

    }

    public T Peek() {
        if (pointer == 0) {
            return null;
        }

        return (T) myStack[pointer - 1];
    }

    public T pop() {
        if (pointer == 0) {
            return null;
        }

        T tmp = (T) myStack[pointer - 1];
        myStack[pointer - 1] = null;
        pointer--;
        return tmp;
    }

    public boolean isEmpty() {
        if (pointer == 0) {
            return true;
        }
        return false;
    }

    public int Size() {
        return pointer;
    }

     public T get(int index) {
        if (index < 0 || index == myStack.length) {
            return null;
        }
        return (T)myStack[index];
    }
    
}
