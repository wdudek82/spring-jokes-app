package guru.springframework.jokesapp.controllers;

import guru.springframework.jokesapp.mappings.JokeViewMappings;
import guru.springframework.jokesapp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JokeController {

    private final JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    // @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    @GetMapping({"/", ""})
    String joke(Model model) {
        model.addAttribute("randomJoke", jokeService.getRandomJoke());
        return JokeViewMappings.CHUCK_NORRIS;
    }

}
