package com.example.springbootJPAscraping.Models;

import com.example.springbootJPAscraping.Repositories.InterestRateRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;

@Service
@EnableScheduling
public class InterestRateDao {
    private static final Logger log = LoggerFactory.getLogger(InterestRateDao.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private InterestRateRepository repository;

    @Scheduled(fixedRate = 5000 )
    public void insertCoins() {
        Document document = null;
        try {
            document = Jsoup.connect("https://www.myfxbook.com/forex-economic-calendar/interest-rates").get();
            Element table = document.select("table.interestRatesTable").first();

            for (int i = 1; i < 4 ; i++) {
                InterestRate interestRate = new InterestRate(
                        table.select("tr").get(i).select("td").get(0).text(),
                        table.select("tr").get(i).select("td").get(3).text(),
                        table.select("tr").get(i).select("td").get(7).text());
                repository.save(interestRate);
            }
            log.info("The time is now {}", dateFormat.format(new Date()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
