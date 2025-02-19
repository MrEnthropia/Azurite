package ru.MrEnthropia.Azurite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.MrEnthropia.Azurite.models.Log;
import ru.MrEnthropia.Azurite.repositories.LogsRepository;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        List<Log> logsStation1 = StreamSupport.stream(logsRepository.findByNumberStation(1).spliterator(), false)
                .sorted(Comparator.comparing(Log::getDateTime).reversed()) // Сортировка от новой к старой
                .collect(Collectors.toList());

        List<Log> logsStation2 = StreamSupport.stream(logsRepository.findByNumberStation(2).spliterator(), false)
                .sorted(Comparator.comparing(Log::getDateTime).reversed())
                .collect(Collectors.toList());
        model.addAttribute("logsStation1", logsStation1);
        model.addAttribute("logsStation2", logsStation2);

        return "view";

    }

}
