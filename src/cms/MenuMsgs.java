/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms;

public class MenuMsgs extends CMS {

    static int customerCounter = 0;
    static String uName;//employee Name
    static String adminName;
    static int exit = 0;

    static int exitFromEmpMenu = 0;

    static int exitFromAdminMenu = 0;
    String userName;

    public void homeMenu() {
        
        while (exit != -1) {
         
            System.out.println("******************************************************");

            System.out.println("Welcome to the MA Company ");
            System.out.println("Press Enter to get your waiting id");
            System.out.println("or Enter your username and password if you are registerd employee");

            System.out.println("******************************************************");
            String userName = input.nextLine();
            boolean isUserFound = false;
            int userIndex = 0;

            if (userName.equalsIgnoreCase("")) {
                System.out.println("Your waiting id is : " + (++customerCounter));
                Customers.enqueue(new Customer(customerCounter));
            } else {
                System.out.println("Now Enter your password");
                int password = input.nextInt();

                for (int i = 0; i < Emp.size(); i++) {
                    if (userName.equalsIgnoreCase(Emp.get(i).username) && password == Emp.get(i).password) {
                        userIndex = i;
                        isUserFound = true;
                        break;
                    }
                    if (i == Emp.size() - 1) {
                        System.out.println("Enter a correct username or password !!");
                        userName = input.nextLine();
                    }
                }
            }
            if (isUserFound) {
                if (Emp.get(userIndex).isAdmin) {
                    adminName = userName;
                    adminMenu();

                } else if (Emp.get(userIndex).isAdmin == false) {
                    uName = userName;
                    empMenu();

                }
            }


         
        }

    }

    public void empMenu() {

        while (exitFromEmpMenu != -1) {
            System.out.println("-----------------------------------------");
            System.out.println("Welcome " + uName + ",");
            System.out.println("1- Serve the next Customer");
            System.out.println("2-Check the last Customer");
            System.out.println("3-View all Served Customers");
            System.out.println("4- View a served customer issue by Id or name");
            System.out.println("5- Exit");
            System.out.println("-----------------------------------------");
            int choice = input.nextInt();

            if (choice == 1) {
                if (Customers.Size() > 0) {
                    Customer serveCustomer = Customers.getHead();
                    System.out.println("Your Customer id is " + serveCustomer.id);
                    System.out.println("Enter Customer Name ");
                    serveCustomer.Name = input.next();
                    input.nextLine();
                    System.out.println("Enter Customer id");
                    serveCustomer.id2 = input.next();
                    System.out.println("Enter Customer Address");
                    serveCustomer.Address = input.next();
                    System.out.println("Issue description");
                    serveCustomer.Issue = input.next();
                    input.nextLine();

                    System.out.println("is it Solved ( 1 : Yes , 0 : No");
                    serveCustomer.Status = input.nextInt();
                  
                    for (int i = 0; i < cmsTree.root.getChildren().size(); i++) {
                        if (uName.equalsIgnoreCase(cmsTree.root.getChildren().get(i).getData())){
                            cmsTree.root.getChildren().get(i).getChildren().add(new MyTree.Node<>(serveCustomer.printReport2(), new MyArray<MyTree.Node<String>>(),cmsTree.root.getChildren().get(i)));
                            break;
                        }
                    }
                    
                   
                    servedCustomers.push(serveCustomer);
                    Customers.dequeue();
                    
                } else {
                    System.out.println("No customers left");
                }
            } else if (choice == 2) {
                if (servedCustomers.Size() == 0) {
                    System.out.println("No coustmers were served today");
                } else {
                    servedCustomers.Peek().printReport();
                }

            } else if (choice == 3) {
                if (servedCustomers.Size() == 0) {
                    System.out.println("No coustmers were served today");
                } else {
                    System.out.println("You served " + servedCustomers.Size() + " customers today");
                    for (int i = 0; i < servedCustomers.Size(); i++) {

                        servedCustomers.get(i).printReport();
                    }
                }
            } else if (choice == 4) {

                if (servedCustomers.Size() == 0) {
                    System.out.println("No coustmers were served today");
                }
                System.out.println("Enter the customer id or name");
                String findIdOrName = input.next();
                for (int i = 0; i < servedCustomers.Size(); i++) {
                   
                    
                    if (servedCustomers.get(i).Name.equalsIgnoreCase(findIdOrName) || servedCustomers.get(i).id2.equalsIgnoreCase(findIdOrName)) {
                        servedCustomers.get(i).printReport();
                        break;
                    }
                  else if (servedCustomers.get(i).Name.contains(findIdOrName)){
                         servedCustomers.get(i).printReport();
                    }
                    

                }
            } else if (choice == 5) {
               userName = input.nextLine();
                homeMenu();

            }
        }

    }

    public void adminMenu() {

        while (exitFromAdminMenu != -1) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Welcome " + adminName + ",");
            System.out.println("1- View Customers queue");
            System.out.println("2- Check last served Customer and by whom he was served");
            System.out.println("3- View all Customers issues");
            System.out.println("4- Manage employees");
            System.out.println("5- View Customer Service Tree");
            System.out.println("6- exit");
            System.out.println("-----------------------------------------------------------");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println("There are " + Customers.Size() + " customers on the waiting list ");
            } else if (choice == 2) {
                if (servedCustomers.Size() == 0) {
                    System.out.println("No coustmers were served today");
                } else {
                    System.out.println("Last served Customer was " + servedCustomers.Peek().Name + " And he was served by " + uName);
                }

            } else if (choice == 3) {
                if (servedCustomers.Size() == 0) {
                    System.out.println("No coustmers were served today");
                } else {
                    System.out.println("We solved " + servedCustomers.Size() + " customers today :");
                    for (int i = 0; i < servedCustomers.Size(); i++) {
                        servedCustomers.get(i).printReport();
                    }

                }
            } else if (choice == 4) {
                System.out.println("Your Employees :");

                MyArray<User> mngEmp = new MyArray<User>();
                for (int i = 0; i < Emp.size(); i++) {
                    if (Emp.get(i).isAdmin == false) {
                        mngEmp.add(Emp.get(i));

                    }

                }
                for (int i = 0; i < mngEmp.size(); i++) {
                    System.out.println(" -" + mngEmp.get(i).username);

                }
                System.out.println("Enter the number of the user");
                int empChoiceNum = input.nextInt();
                System.out.println("What u want to with " + mngEmp.get(empChoiceNum - 1).username);
                System.out.println("1- Disable/Enable user");
                System.out.println("2-Change Name");
                int option = input.nextInt();
                if (option == 1) {
                    System.out.println("if u want to Enable user enter 1 for disable enter 0");
                    option = input.nextInt();
                    if (option == 1) {
                        if (mngEmp.get(empChoiceNum - 1).isActive) {
                            System.out.println(mngEmp.get(empChoiceNum - 1).username + " is already Enabled ");
                        } else {
                            mngEmp.get(empChoiceNum - 1).isActive = false;
                            System.out.println(mngEmp.get(empChoiceNum - 1).username + " has been Enabled");
                        }

                    } else if (option == 0) {
                        if (mngEmp.get(empChoiceNum - 1).isActive) {
                            mngEmp.get(empChoiceNum - 1).isActive = false;
                            System.out.println(mngEmp.get(empChoiceNum - 1).username + " has been Disabled");

                        } else {
                            System.out.println(mngEmp.get(empChoiceNum - 1).username + " is already Disabled");
                        }

                    }
                } else if (option == 2) {
                    System.out.println("Enter the new name");
                    mngEmp.get(empChoiceNum - 1).username = input.next();
                   cmsTree.root.getChildren().get(empChoiceNum-1).setData(mngEmp.get(empChoiceNum-1).username);
                    System.out.println("Name is changed !!");

                }
               
                

            } 
            else if (choice == 5){
                  System.out.println(cmsTree.root.getData());
                  for (int i = 0; i < cmsTree.root.getChildren().size(); i++) {
                      System.out.println("\t"+cmsTree.root.getChildren().get(i).getData());
                      for (int j = 0; j <cmsTree.root.getChildren().get(i).getChildren().size(); j++) {
                          System.out.println("\t\t"+cmsTree.root.getChildren().get(i).getChildren().get(j).getData());
                      }
                }
                }
            
            else if (choice == 6) {

               userName = input.nextLine();
                homeMenu();

            }
        }
    }

}
