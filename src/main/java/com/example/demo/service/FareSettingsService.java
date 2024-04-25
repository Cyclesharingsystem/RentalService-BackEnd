package com.example.demo.service;
import com.example.demo.dto.FareSettingsDTO;
import com.example.demo.model.FareSettings;
public interface FareSettingsService {
    double getHourlyRate();
    double getDailyRate();
    double getWeeklyRate();
    double getMonthlyRate();

    FareSettings updateFareSettings(FareSettingsDTO fareSettingsDTO);

    FareSettings createFareSettings(FareSettingsDTO fareSettingsDTO);
}