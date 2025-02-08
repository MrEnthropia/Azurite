package ru.MrEnthropia.UEAJ.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.MrEnthropia.UEAJ.models.Log;
import ru.MrEnthropia.UEAJ.repositories.LogsRepository;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Controller
public class AddingController {

    public AddingController(){
        readLastWorkHours();
    }

    @Autowired
    private LogsRepository logsRepository;

    // Хранит последние рабочие часы для каждой станции
    private final Map<Integer, Integer> lastWorkHours = new HashMap<>();

    private static final String FILE_NAME = "src/main/resources/last_work_hours.txt";


    public void readLastWorkHours() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    int stationNumber = Integer.parseInt(parts[0].trim());
                    int hours = Integer.parseInt(parts[1].trim());
                    lastWorkHours.put(stationNumber, hours);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeLastWorkHours() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<Integer, Integer> entry : lastWorkHours.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

        int lastHours = lastWorkHours.getOrDefault(numberStation, 0);


        if (workHours < lastHours) {
            model.addAttribute("error", "Ошибка: введённые рабочие часы меньше последнего значения " +
                    "(" + lastHours + ")");
            return "add-log";
        }

            lastWorkHours.put(numberStation, workHours);

            writeLastWorkHours();

            Timestamp dateTime = Timestamp.valueOf(LocalDateTime.now());


            Log log = new Log(numberStation, dateTime, workHours, oilTemp, oilPressure, oilTopping, antifreezeTopping,
                    exhaustTempLeft, exhaustTempRight, comment);
            logsRepository.save(log);

            return "redirect:/";
    }
}
