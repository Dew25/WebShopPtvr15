/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Melnikov
 */
public class MyDate {
    private Date firstDate;
    private Date secondDate;

    public MyDate() {
    }

    public MyDate(Date firstDate, Date secondDate) {
        this.firstDate = firstDate;
        this.secondDate = secondDate;
    }
    public String getCountDey(){
        Long first=firstDate.getTime();
        Long second = secondDate.getTime();
        Long countSec = second - first;
        //24 часа/в сутках * 3600 секунд/сек в часе
        Long d = 24L*3600L*1000L;
        Long res = countSec/d;
        return res.toString();
    }
    public Date getDatePlus(Date date, int deys){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, deys);
        return c.getTime();
    }
 
   
}
