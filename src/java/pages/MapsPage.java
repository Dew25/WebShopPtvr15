/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import entity.Maps;
import entity.Reader;
import interfaces.AbstractPage;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import session.BookFacade;
import session.MapsFacade;

/**
 *
 * @author jvm
 */
public class MapsPage implements AbstractPage{
    private MapsFacade mapsFacade;
    public MapsPage() {
        Context context;
        try {
            context = new InitialContext();
            this.mapsFacade = (MapsFacade) context.lookup("java:module/MapsFacade");
        } catch (Exception e) {
        }
    }

    @Override
    public void execute(HttpServletRequest request) {
        Map<Reader,List<Maps>> mapReaderWithBooks = mapsFacade.getMapReaderWithBooks();
            request.setAttribute("mapReaderWithBooks", mapReaderWithBooks);
            Calendar c = new GregorianCalendar();
            request.setAttribute("today", c.getTime());
    }
    
}
