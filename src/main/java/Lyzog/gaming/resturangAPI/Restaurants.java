package Lyzog.gaming.resturangAPI;


import java.util.ArrayList;
import java.util.List;

public class Restaurants{

    private List<Restaurant> restaurant;

    public Restaurants(){
        this.restaurant = new ArrayList<>();
        addMockData();
    }

    public List<Restaurant> getRestaurants(String searchString){

        if (searchString.equals(""))
            return restaurant;


        ArrayList<Restaurant> rests = new ArrayList<>();
        for (Restaurant rest : restaurant){
            if (rest.getName().toLowerCase().contains(searchString.toLowerCase()))
                rests.add(rest);
        }

        return rests;
    }

    public Restaurant getRestaurant(String id){
        return findRestById(id);
    }

    public Restaurant deleteRest(String id){
        Restaurant rest = findRestById(id);

        restaurant.remove(rest);

        return rest;
    }

    public void addRest(Restaurant rest){
        restaurant.add(rest);
    }

    public void replaceRestWithId(String id, Restaurant newRest){
        Restaurant oldRest = findRestById(id);

        restaurant.remove(oldRest);

        newRest.setId(oldRest.getId());

        restaurant.add(newRest);
    }

    private Restaurant findRestById(String id){
        for (Restaurant rest : restaurant){
            if (rest.getId().equals(id))
                return rest;
        }
        return null;
    }

    private void  addMockData() {

        Restaurant rest1 = new Restaurant("0","Restaurant daniel");
        Restaurant rest2 = new Restaurant("1","Restaurant david");

        restaurant.add(rest1);
        restaurant.add(rest2);
    }
}
