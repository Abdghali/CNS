/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms;

import java.util.Scanner;

public class CMS {

    static Scanner input = new Scanner(System.in);

    public static MyQueue<Customer> Customers;
    public static MyStack<Customer> servedCustomers;

    public static MyArray<User> Emp;
    public static MyTree<String> cmsTree;

    static {
        Emp = new MyArray<User>();
        Emp.add(new User("Mohamed", 123, true, true));
        Emp.add(new User("Abd", 123, false, true));
        Emp.add(new User("khaled", 123, false, true));

        Customers = new MyQueue<Customer>();
        servedCustomers = new MyStack<Customer>();
       
        MyTree.Node<String> root = new MyTree.Node<>(Emp.get(0).username, new MyArray<MyTree.Node<String>>(), null);//The Admin is the root
        cmsTree = new MyTree<>(root);
        MyTree.Node<String> emp1= new MyTree.Node<String>(Emp.get(1).username, new MyArray<MyTree.Node<String>>(), root);
        root.getChildren().add(emp1);
        MyTree.Node<String> emp2 = new MyTree.Node<String>(Emp.get(2).username, new MyArray<MyTree.Node<String>>(), root);
        root.getChildren().add(emp2);

    }

/////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        MenuMsgs Menu = new MenuMsgs();

        Menu.homeMenu();

    }

}
