/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms;

public class MyTree<T> {

    Node<T> root;

    public MyTree(Node<T> root) {
        this.root = root;
    }

    static public class Node<T>{

        
       private T data;
       private  MyArray<Node<T>> children;
       private Node<T> parent;
        
        public void setData(T data) {
            this.data = data;
        }

        public void setChildren(MyArray<Node<T>> children) {
            this.children = children;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }


        public Node(T data, MyArray<Node<T>> children, Node<T> parent) {
            this.data = data;
            this.children = children;
            this.parent = parent;
        }

        public T getData() {
            return data;
        }

        public MyArray<Node<T>> getChildren() {
            return children;
        }

        public Node<T> getParent() {
            return parent;
        }
        

    }

}
