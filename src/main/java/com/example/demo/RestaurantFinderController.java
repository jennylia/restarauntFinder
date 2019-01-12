package com.example.demo;

import com.example.demo.yelp.YelpClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
// TODO: change back to @controller once ready to bind to views
public class RestaurantFinderController {

    @GetMapping("listOptions")
    public String greeting(@RequestParam(name = "location", required = false, defaultValue = "Seattle") String name, Model model) {
        model.addAttribute("location", name);

        // Find me the return val:
        YelpClient yelpClient = new YelpClient();
        String yelpClientData = yelpClient.getData();

        // TODO: change back to controller once ready to bind to views
//        return "restaurantList";
        return yelpClientData;

    }
}
