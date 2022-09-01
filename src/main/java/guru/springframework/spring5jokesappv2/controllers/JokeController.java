package guru.springframework.spring5jokesappv2.controllers;

import guru.springframework.spring5jokesappv2.services.JokeService;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yuriy Tsarkov (yurait6@gmail.com) on 01.09.2022
 */
@RestController
public class JokeController {

  private final JokeService jokeService;

  public JokeController(JokeService jokeService) {
    this.jokeService = jokeService;
  }

  @GetMapping( value = {"/", ""}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public String showJoke(Model model) {
    model.addAttribute("joke", jokeService.getJoke());

    return "index";
  }
}
