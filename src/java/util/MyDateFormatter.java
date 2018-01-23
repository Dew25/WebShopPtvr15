/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;

/**
 *
 * @author Melnikov
 * Compare date1 and date2.
 *  date2 > date1 return "1";
 *  date2 == date1 return "0";
 *  date2 < date1 return "2";
 */
public class MyDateFormatter {
    public static int compareDate(Date date1,Date date2){
        if(date2.getTime()>date1.getTime()){
            return 1;
        }else if(date2.getTime()==date1.getTime()){
            return 0;
        }else {
            return -1;
        }
    }
}
