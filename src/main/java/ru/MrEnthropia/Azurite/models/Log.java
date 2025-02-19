package ru.MrEnthropia.Azurite.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.sql.Timestamp;



@Entity(name = "logs_table")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public int getNumberStation() {
        return numberStation;
    }

    public void setNumberStation(int numberStation) {
        this.numberStation = numberStation;
    }

    private int numberStation;


    private Timestamp dateTime;


    private int workHours, oilTemp, oilTopping, antifreezeTopping, exhaustTempLeft, exhaustTempRight;

    private Double oilPressure;
    private String comment;

    public Log(){

    }

    public Log( int numberStation,  Timestamp dateTime, int workHours, int oilTemp, Double oilPressure, int oilTopping, int antifreezeTopping, int exhaustTempLeft, int exhaustTempRight, String comment) {


        this.numberStation = numberStation;
        this.dateTime = dateTime;
        this.workHours = workHours;
        this.oilTemp = oilTemp;
        this.oilTopping = oilTopping;
        this.antifreezeTopping = antifreezeTopping;
        this.exhaustTempLeft = exhaustTempLeft;
        this.exhaustTempRight = exhaustTempRight;
        this.oilPressure = oilPressure;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public int getOilTemp() {
        return oilTemp;
    }

    public void setOilTemp(int oilTemp) {
        this.oilTemp = oilTemp;
    }

    public int getOilTopping() {
        return oilTopping;
    }

    public void setOilTopping(int oilTopping) {
        this.oilTopping = oilTopping;
    }

    public int getAntifreezeTopping() {
        return antifreezeTopping;
    }

    public void setAntifreezeTopping(int antifreezeTopping) {
        this.antifreezeTopping = antifreezeTopping;
    }

    public int getExhaustTempLeft() {
        return exhaustTempLeft;
    }

    public void setExhaustTempLeft(int exhaustTempLeft) {
        this.exhaustTempLeft = exhaustTempLeft;
    }

    public int getExhaustTempRight() {
        return exhaustTempRight;
    }

    public void setExhaustTempRight(int exhaustTempRight) {
        this.exhaustTempRight = exhaustTempRight;
    }

    public Double getOilPressure() {
        return oilPressure;
    }

    public void setOilPressure(Double oilPressure) {
        this.oilPressure = oilPressure;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }





}
