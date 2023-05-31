package com.example.springbootJPAscraping.Controllers;

import com.example.springbootJPAscraping.Models.InterestRateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interestRate")
public class InterestRateController {

    @Autowired
    private InterestRateDao interestRateDao;
    @PostMapping(value = "/add")
    public void add() {
        interestRateDao.insertCoins();
    }

}
