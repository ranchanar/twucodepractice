package com.tw.qa.nextdate;

//Numerals that denote the following day 
import java.util.Scanner;

public class NextDate {
    int nextDateDay, nextDateMonth, nextDateYear;
    String invalidInput = "Invalid Input Date";
    String NextDAteNo;

    public boolean isValidInputs(int month, int day, int year) {
        return ((1 <= month) && (month <= 12)) && (1 <= day) && (day <= 31) && (1752 <= year) && (year <= 3000);
    }

    public String NextDateMethod(int month, int day, int year) {
        int tempMonthMapping;
        String NextDAteNo = null;
        nextDateMonth = month;
        nextDateDay = 0;
        nextDateYear = year;

        if (isValidInputs(month, day, year)) {
            tempMonthMapping = monthMappingDependingOnNumbersOfDays(month);
            switch (tempMonthMapping) {
                case 1:
                    NextDAteNo = thirtyOneDaysMonth(month, day, year);
                    break;
                case 2:
                    NextDAteNo = thityDaysMonth(month, day, year);
                    break;
                case 3:
                    NextDAteNo = feburaryMonth(month, day, year);
                    break;
            }
            return NextDAteNo;
        } else {
            return invalidInput;
        }
    }

    private int monthMappingDependingOnNumbersOfDays(int month) {
        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
            return 1;
        } else if (month == 2) {
            return 3;
        } else {
            return 2;
        }

    }

    public String thirtyOneDaysMonth(int month, int day, int year) {
        if (day == 31 && month != 12) {
            nextDateMonth = month + 1;
            nextDateDay = 1;
        } else if (day == 31 && month == 12) {
            nextDateDay = 1;
            nextDateMonth = 1;
            nextDateYear = year + 1;
        } else {
            nextDateDay = day + 1;
        }
        return NextDAteNo = nextDateMonth + " " + nextDateDay + " " + nextDateYear;
    }

    public String thityDaysMonth(int month, int day, int year) {
        if (day == 31) {
            return invalidInput;
        } else if (day == 30) {
            nextDateMonth = month + 1;
            nextDateDay = 1;
        } else {
            nextDateDay = day + 1;
        }
        return NextDAteNo = nextDateMonth + " " + nextDateDay + " " + nextDateYear;
    }

    public String feburaryMonth(int month, int day, int year) {
        if ((year % 400) == 0 || ((year % 4 == 0) && (year % 100 != 0))) {
            if (day > 29) {
                return invalidInput;
            } else if (day == 29) {
                nextDateDay = 1;
                nextDateMonth = month + 1;
            } else {
                nextDateDay = day + 1;
            }
        } else if (day > 28) {
            return invalidInput;
        } else if (day == 28) {
            nextDateDay = 1;
            nextDateMonth = month + 1;
        } else {
            nextDateDay = day + 1;
        }
        return NextDAteNo = nextDateMonth + " " + nextDateDay + " " + nextDateYear;
    }

    public static void main(String args[]) {
        NextDate nextDate = new NextDate();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter month");
        int month = sc.nextInt();
        System.out.println("Enter day");
        int day = sc.nextInt();
        System.out.println("Enter year");
        int year = sc.nextInt();
        System.out.println(nextDate.NextDateMethod(month, day, year));
    }


}
