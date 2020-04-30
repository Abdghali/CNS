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
public class MyQueue<T> {
    //FIFO
    //enqueue adds elements to the end of the queue
    //dequeue get the first element added to the queue then delete it
    //clear
    //isEmpty
    //getHead

   private Object myQueue[] = new Object[11];
    private static int pointer = 0;

   

    public void doubleCapacity() {
        Object tmp[] = new Object[myQueue.length * 2];
        for (int i = 0; i < myQueue.length; i++) {
            tmp[i] = myQueue[i];
        }
        myQueue = tmp;

    }

    public int Size() {
        return pointer;
    }
    public boolean enqueue(T element) {
        if (pointer == myQueue.length) {
            doubleCapacity();
            myQueue[pointer++] = element;
            return true;

        }
        if (pointer < myQueue.length) {
            myQueue[pointer++] = element;
            return true;
        }
        return false;
    }

    public T dequeue() {
        if (pointer == 0) {
            return null;
        }
        
        T tmp = (T) myQueue[0];
        for (int i = 0; i < pointer - 1; i++) {
            myQueue[i] = myQueue[i + 1];
        }
        pointer--;
        return tmp;

    }

    public void clear (){
        for (int i = 0; i < pointer; i++) {
            myQueue[i]=null;
        }
    }
    
    public boolean isEmpty(){
        if (pointer ==0)
            return true;
        else
            return false;
    }
    
    public T getHead (){
       if (pointer ==0)
           return null;
        return (T) myQueue[0];
    }
}
