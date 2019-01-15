package com.example.demo;

import com.example.demo.yelp.Business;
import com.example.demo.yelp.YelpClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
// TODO: change back to @controller once ready to bind to views
public class ListOptionsController {

    @GetMapping("listOptions")
    public String greeting(
            @RequestParam(name = "location", required = false, defaultValue = "Seattle") String location,
            @RequestParam(name = "category", required = false, defaultValue = "sushi") String category,
            @RequestParam(name = "limit", required = false, defaultValue = "2") int limit,
            Model model
    ) throws IOException, URISyntaxException {
        model.addAttribute("location", location);
        model.addAttribute("category", category);

        List<Business> businesses = new ArrayList<>();
        Business b1 = new Business("test1");
        Business b2 = new Business("test2");
        businesses.add(b1);
        businesses.add(b2);

        model.addAttribute("businesses", businesses);


        // Find me the return val:
        YelpClient yelpClient = new YelpClient();
        String yelpClientData = yelpClient.getData(location, category, limit);

        // TODO: change back to controller once ready to bind to views
        return "restaurantList";

    }
}
