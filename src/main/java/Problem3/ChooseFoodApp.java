package Problem3;

import java.util.Scanner;

public class ChooseFoodApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Menu dinner = new Menu();
        boolean flag = false;
        do{
            System.out.println("Please choose the dinner you would like to order: " + dinner.getFood());
            String inputFood = scanner.nextLine();
            try{
                dinner.setOrder(inputFood.toLowerCase());
                System.out.println("Your Dinner choice has been successfully ordered!");
                flag = true;
            }catch(OrderException ex){
                System.out.println(ex.getMessage());
                System.out.println("Please try again!");
            }finally{
                System.out.println("Thank You");
            }
        }while(!flag);
        scanner.close();
    }
}