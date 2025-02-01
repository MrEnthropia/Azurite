package ru.MrEnthropia.UEAJ.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.MrEnthropia.UEAJ.models.Log;
import ru.MrEnthropia.UEAJ.repositories.LogsRepository;


import java.util.List;

@Controller
public class MainController {

    @Autowired
    private LogsRepository logsRepository;



    @GetMapping("/")
    public String home( Model model){
        Iterable<Log> logs = logsRepository.findTop7ByOrderByDateTimeDesc();
        model.addAttribute("logs", logs);

        return "home";
    }

    @GetMapping("/instruction")
    public String instruction( Model model){
        return "instruction";

    }

    @GetMapping("/view")
    public String view( Model model){
        Iterable<Log> logsStation1 = logsRepository.findByNumberStation(1);
        Iterable<Log> logsStation2 = logsRepository.findByNumberStation(2);
        model.addAttribute("logsStation1", logsStation1);
        model.addAttribute("logsStation2", logsStation2);

        return "view";

    }

    @GetMapping("/test")
    public String test( Model model){
        model.addAttribute("title", "Тестовая страница");
        return "test";

    }

}
