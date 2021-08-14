package com.stackroute.commonjavaclasses;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/* Complete the class as per the requirements given in PROBLEM.md */
public class BankDeposit {

        public String getMaturityDate(String investmentDate, Period duration) {

            LocalDate investDate = LocalDate.parse(investmentDate);
            if(duration.isNegative())
                return "Invalid duration";

            LocalDate maturityTime=investDate.plus(duration);
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String strDate = format.format(maturityTime);
            return strDate;
        }

        public String getInvestmentDuration(String investmentDate, String maturityDate) {
            LocalDate investDate = LocalDate.parse(investmentDate);
            LocalDate maturityEnd = LocalDate.parse(maturityDate);
            Period investmentDuration = Period.between(investDate, maturityEnd);

            return investmentDuration.toString();

        }
    }

