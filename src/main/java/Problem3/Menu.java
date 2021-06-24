package Problem3;

import java.util.ArrayList;

public class Menu {

    private String order;

    ArrayList<String> food = new ArrayList<>();

    public Menu() {
        //initialise all the foods
        food.add("steak");
        food.add("pizza");
        food.add("spaghetti");
        food.add("salad");
        food.add("chips");
        food.add("bacon");
        food.add("chicken");
        food.add("hotdogs");
    }

    public ArrayList<String> getFood(){
        return food;
    }

    // one setter method for adding dinner
    public void setOrder(String order) throws OrderException {
        //check if the food is on the menu before assigning it to dinner
        if (!food.contains(order)){
            throw new OrderException("You have selected a meal that is not on the menu!");
        }
        //add the dinner order
        this.order = order;
    }

}
