package com.examly;
import java.util.Scanner;

import com.examly.entity.Eyewear;
import com.examly.service.EyewearService;
import com.examly.service.EyewearServiceImpl;

public class MainModule{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EyewearService Impl = new EyewearServiceImpl();

        while(true)
        {
            System.out.println("\n\nEyewear Invertory System\n");
            System.out.println("1. Add Eyewear ");
            System.out.println("2. Update Eyewear");
            System.out.println("3. Delete Eyewear");
            System.out.println("4. Get Eyewear By Id ");
            System.out.println("5. Get All Eyewear");
            System.out.println("6. Search By Brand");
            System.out.println("7. Filter by Gender  ");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice : ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 ->{
                        System.out.print("Brand: ");
                        String brand = sc.nextLine();
                        System.out.print("Frame Type: ");
                        String frameType = sc.nextLine();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        sc.nextLine(); 
                        System.out.print("Gender: ");
                        String gender = sc.nextLine();
                        System.out.print("Stock: ");
                        int stock = sc.nextInt();
                        sc.nextLine(); 

                    String result = Impl.addEyewear(new Eyewear(0,brand,frameType,price,gender,stock));
                    System.out.print(result);
                    break;
                }
                case 2 ->{
                    System.out.print("Enter the eyewearId : ");
                    int eyewearId = sc.nextInt(); sc.nextLine();
                    System.out.print("New Brand : ");
                    String brand = sc.nextLine();
                    System.out.print("New Frame Type: ");
                    String frameType = sc.nextLine();
                    System.out.print("New Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); 
                    System.out.print("New Gender: ");
                    String gender = sc.nextLine();
                    System.out.print("new Stock: ");
                    int stock = sc.nextInt();
                    sc.nextLine(); 

                    String result = Impl.updateEyewear(new Eyewear(eyewearId, brand, frameType, price, gender, stock));
                    System.out.println(result);
                    break;
                    
                }
                case 3 ->{
                    System.out.print("Enter the eyewearId : ");
                    int eyewearId = sc.nextInt(); sc.nextLine();

                    String result = Impl.deleteEyewear(eyewearId);
                    System.out.println(result);
                    break;
                }
                case 4 ->{
                    System.out.print("Enter the eyewearId : ");
                    int eyewearId = sc.nextInt(); sc.nextLine();

                    Eyewear result = Impl.getEyewearById(eyewearId);
                    System.out.println(result);
                    break;
                }
                case 5 ->{
                   System.out.println(Impl.getAllEyewear());
                   break;
                }
                case 6 ->{
                    System.out.print("Enter the brand to search : ");
                    String brand = sc.nextLine();

                    System.out.println(Impl.searchByBrand(brand));
                    break;
                }
                case 7 ->{
                    System.out.print("Enter the gender to filter : ");
                    String gender = sc.nextLine();

                    System.out.println(Impl.filterBygender(gender));
                    break;
                }
                case 8 ->{
                    System.out.println("Invalid choice.");
                    System.exit(choice);
                    sc.close();
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}