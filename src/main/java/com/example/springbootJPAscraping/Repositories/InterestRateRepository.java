package com.example.springbootJPAscraping.Repositories;

import com.example.springbootJPAscraping.Models.InterestRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRateRepository extends JpaRepository<InterestRate,Integer> {

}
