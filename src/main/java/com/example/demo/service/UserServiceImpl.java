package com.example.demo.service;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements  UserService {

@Autowired
private FareSettingsService fareSettingsService;

@Autowired
private UserRepository userRepository;
    @Override
    public String getSubscriptionAmount(UserDTO userDTO,String type,double hours) {

            switch (type) {
                case "DAILY":
                    userDTO.setPlan("Daily");
                    userDTO.setAmount(fareSettingsService.getDailyRate());
                case "WEEKLLY":
                    userDTO.setPlan("Weekly");
                    userDTO.setAmount(fareSettingsService.getWeeklyRate());
                case "MONTHLY":
                    userDTO.setPlan("Monthly");
                    userDTO.setAmount(fareSettingsService.getMonthlyRate());
                default:
                    double PayASYouGo=fareSettingsService.getHourlyRate()*hours;
                    userDTO.setHours(hours);
                  userDTO.setAmount(PayASYouGo);
            }
              User user=new User();
            BeanUtils.copyProperties(userDTO,user);
userRepository.save(user);
        return "success";
    }
}
