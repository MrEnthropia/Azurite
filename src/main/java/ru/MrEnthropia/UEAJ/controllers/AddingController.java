package ru.MrEnthropia.UEAJ.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.MrEnthropia.UEAJ.models.Log;
import ru.MrEnthropia.UEAJ.repositories.LogsRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Controller
public class AddingController {

    @Autowired
    private LogsRepository logsRepository;

    @GetMapping("/add-log")
    public String addLog (Model model){

        return "add-log";
    }

    @PostMapping("/add-log")
    public String saveLog(
                          @RequestParam int numberStation,
                          @RequestParam int workHours,
                          @RequestParam int oilTemp,
                          @RequestParam Double oilPressure,
                          @RequestParam int oilTopping,
                          @RequestParam int antifreezeTopping,
                          @RequestParam int exhaustTempLeft,
                          @RequestParam int exhaustTempRight,
                          @RequestParam String comment,
                          Model model){


        Timestamp dateTime = Timestamp.valueOf(LocalDateTime.now());


        Log log = new Log(numberStation, dateTime, workHours, oilTemp, oilPressure, oilTopping, antifreezeTopping, exhaustTempLeft, exhaustTempRight, comment);
        logsRepository.save(log);

        return "redirect:/";
    }
}
