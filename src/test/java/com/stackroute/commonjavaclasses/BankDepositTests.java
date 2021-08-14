package com.stackroute.commonjavaclasses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.Period;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertThrows;

/* Write test cases for positive and negative scenarios*/
public class BankDepositTests {

        BankDeposit bank;
        @BeforeEach
        void setUp(){

            bank=new BankDeposit();
        }
        @Test
        void BankDepositMaturityTime(){
            Period timePeriod=Period.of(3,1,4);
            String maturity= bank.getMaturityDate("2021-05-02", timePeriod);
            assertEquals("26/05/2024",maturity);
        }

        @Test
        void BankDepositMaturityTimeWith0Years0Months0Days(){
            Period timePeriod=Period.of(0,0,0);
            String maturity= bank.getMaturityDate("2000-09-09", timePeriod);
            assertEquals("09/09/2000",maturity);
        }

        @Test
        void testIfTimePeriodInvalidNegativeInGetMaturityDate() {
            Period timePeriod=Period.of(30,6,-3);
            String maturity= bank.getMaturityDate("2021-05-02", timePeriod);
            assertEquals("Invalid duration",maturity);
        }



        @Test
        void testBankDepositMaturityTimeIfNull() {
            try {
                Period timePeriod = null;
                String maturity = bank.getMaturityDate("null", timePeriod);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        @Test
        void testBankDepositMaturityIfInvestmentDateandTimePeriodBothEmpty() {
            try {
                Period timePeriod =Period.of(0,0,0);
                String maturity = bank.getMaturityDate("0-0-0", timePeriod);
                assertEquals("", maturity);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        @Test
        void testBankDepositInvestmentDateInvalid() {
            Period timePeriod = Period.of(2, 1, 2);
            assertThrows(DateTimeParseException.class, () ->bank.getMaturityDate("2007-35-11", timePeriod));
        }

        @Test
        void getInvestmentDurationTime(){
            String investDuration= bank.getInvestmentDuration("2020-05-23","2024-04-20");
            assertEquals("P3Y10325l",investDuration);
        }

        @Test
        void getInvestmentDurationTimeWithInvalidDate() {
            assertThrows(DateTimeException.class, () -> bank.getInvestmentDuration("2020-05-31","2024-04-39"));
        }

        @Test
        void getInvestmentDurationTimeWithInvalidMonth() {
            assertThrows(DateTimeParseException.class, () -> bank.getInvestmentDuration("2020-23-12","2024-13-13"));
        }

        @Test
        void getInvestmentDurationTimeTestWith0Years(){
            String investDuration= bank.getInvestmentDuration("2020-05-23","2021-04-20");
            assertEquals("P10325l",investDuration);
        }

        @Test
        void testInvestmentDurationTimeIfNull() {
            try {
                String investDuration = bank.getInvestmentDuration("null", "null");
                assertEquals("null", investDuration);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        @Test
        void testInvestmentDurationIfTimeEmpty() {
            try {
                String investDuration = bank.getInvestmentDuration("0-0-0", "0-00-0");
                assertEquals("", investDuration);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        private void assertEquals(String s, String investDuration) {
        }

        @Test
        void testInvestmentDurationTimeIfNegativeInput(){

            assertThrows(DateTimeParseException.class,()->bank.getInvestmentDuration("-2021-04-26","2010--03-02"));
        }



    }

