package com.tw.qa.nextdate;

import com.tw.qa.nextdate.NextDate;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class NextDateTest {

    @Before
    public void setUp(){
        NextDate nextDate=new NextDate();
    }

    @Test
    public void testMonthWithThirtyOneDaysShouldReturnNextDate(){
        NextDate nextDate=new NextDate();
        assertEquals("1 1 2012",nextDate.NextDateMethod(12,31,2011));
        assertEquals("1 2 2002",nextDate.NextDateMethod(1,1,2002));
        assertEquals("4 1 2003",nextDate.NextDateMethod(3,31,2003));
        assertEquals("12 12 2001",nextDate.NextDateMethod(12,11,2001));
        assertEquals("5 5 2005",nextDate.NextDateMethod(5,4,2005));
    }

    @Test
    public void testMonthWithThirtyDaysShouldReturnNextDate(){
        NextDate nextDate=new NextDate();
        assertEquals("Invalid Input Date",nextDate.NextDateMethod(4,31,2005));
        assertEquals("4 6 2003",nextDate.NextDateMethod(4,5,2003));
        assertEquals("5 1 2000",nextDate.NextDateMethod(4,30,2000));
    }

    @Test
    public void testFebruaryMonthShouldReturnNextDate(){
        NextDate nextDate=new NextDate();
        assertEquals("Invalid Input Date",nextDate.NextDateMethod(29,2,2001));
        assertEquals("Invalid Input Date",nextDate.NextDateMethod(29,2,1900));
        assertEquals("3 1 2012",nextDate.NextDateMethod(2,29,2012));
        assertEquals("2 24 2005",nextDate.NextDateMethod(2,23,2005));
    }

    @Test
    public void testInputDate(){
        NextDate nextDate=new NextDate();
        assertTrue(nextDate.isValidInputs(3,30,2004));
	    assertTrue(nextDate.isValidInputs(3,30,3004));
        assertFalse(nextDate.isValidInputs(2,37,2003));
        assertTrue(nextDate.isValidInputs(3,25,1751));
    }
}
