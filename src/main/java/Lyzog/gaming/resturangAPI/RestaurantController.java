package Lyzog.gaming.resturangAPI;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RestaurantController {

    private Restaurants restaurants = new Restaurants();

    //private Personnels personnels = new Personnels();

    @RequestMapping(value = "/restaurants",method = GET)
    public List<Restaurant> getResturants(@RequestParam(value="searchString", defaultValue = "") String searchString){

        return restaurants.getRestaurants(searchString);
    }

    @RequestMapping(value = "/restaurants",method = RequestMethod.POST)
    public Restaurant postRestaurant(@RequestBody Restaurant rest){

        restaurants.addRest(rest);
        return rest;
    }

//    @RequestMapping(value = "/restaurants/{id}", method = GET)
//    public Restaurant getResturant(@PathVariable("id") String restId) {
//
//        Restaurant rest = restaurants.getRestaurant(restId);
//
//        return rest;
//    }

    @RequestMapping(value = "/restaurants/{id}",method = DELETE)
    public Restaurant deleteRestaurant(@PathVariable("id") String restId){

        return restaurants.deleteRest(restId);
    }


    /*------------------------------------------------------------------------------------------------------------------------------------------------*/


    @RequestMapping(value = "/restaurants/{id}/personnel", method = GET)
    public Personnels getPersonnels(@PathVariable("id") String restId){

        Restaurant restaurant = restaurants.getRestaurant(restId);

        return restaurant.getPersonnels();

    }

    @RequestMapping(value = "/restaurants/{id}/personnel",method = RequestMethod.POST)
    public Personnel postPersonnel(@PathVariable("id") String persId, @RequestBody Personnel pers){

        Restaurant restaurant = restaurants.getRestaurant(persId);

        Personnels p = restaurant.getPersonnels();

        p.addPers(pers);

        return pers;
    }

//    @RequestMapping(value = "/restaurants/{id}/personnel/{id}", method = GET)
//    public Personnel getPersonnel(@PathVariable("id") String persId){
//
//        Restaurant restaurant = restaurants.getRestaurant(persId);
//
//        Personnels p = restaurant.getPersonnels();
//
//        return p.getPersonnel(persId);
//
//    }

    @RequestMapping(value = "/restaurants/{restId}/personnel/{personId}",method = DELETE)
    public Personnel deletePersonnel(@PathVariable("restId") String restId, @PathVariable("personId") String persId){

        Restaurant restaurant = restaurants.getRestaurant(restId);

        Personnels p = restaurant.getPersonnels();

        return p.deletePers(persId);
    }

}
