/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms;

public class Customer  {
    int id,Status;
    String Name, Address, Issue,id2;

   


    public Customer(int id) {
        this.id = id;
    }


   

   

    
    public void printReport() {
        
        System.out.println("******************************************");
      
        System.out.println("Customer Name : " + this.Name);
        System.out.println("ID ; " + this.id2);
        System.out.println("Address : " + this.Address);
        System.out.println(" Issues : " + this.Issue);
        if (Status == 1) {
            System.out.println("Issue status : solved");
        } else {
            System.out.println("Issue status  : not solved");
        }
        
        System.out.println("******************************************");

    }
    
    public String printReport2(){
        String status ;
        if (Status == 1) {
            status = "Solved";
        } else {
            status =  "Not Solved";
        }
        
        
        return  this.Name+", "+this.id2+", "+this.Address+", "+status;
        
       
    }
    
    
}
