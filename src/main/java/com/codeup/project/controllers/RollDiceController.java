package com.codeup.project.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    @ResponseBody
    public String showDice() {
        return "<h4>What is your guess?</h4>" +
                "<ul>" +
                "<li><a href='/roll-dice/1'>1</a></li>"+
                "<li><a href='/roll-dice/2'>2</a></li>"+
                "<li><a href='/roll-dice/3'>3</a></li>"+
                "<li><a href='/roll-dice/4'>4</a></li>"+
                "<li><a href='/roll-dice/5'>5</a></li>"+
                "<li><a href='/roll-dice/6'>6</a></li>"+
                "</ul>";
    }

    @GetMapping("/roll-dice/{x}")
    @ResponseBody
    public String guessedDice(@PathVariable int x) {
        String response = "<h4>You guessed " + x + "</h4>";
        int diceRollResult = (int) (Math.random() * 6) + 1;
        if (diceRollResult == x) {
            response += "<h4>You guessed CORRECT!</h4>";
        } else{
            response += "<h4>You guessed WRONG! The dice roll resulted in " + diceRollResult + "</h4>";
        }
        response += "<a href='/roll-dice'>Try Again</a>";
        return response;
    }


}
