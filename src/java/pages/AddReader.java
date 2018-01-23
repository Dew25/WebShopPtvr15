/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import entity.Reader;
import interfaces.AbstractPage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import session.ReaderFacade;

/**
 *
 * @author Melnikov
 */
public class AddReader implements AbstractPage {

    private ReaderFacade readerFacade;
   

    public AddReader() {
        Context context;
        try {
            context = new InitialContext();
            this.readerFacade = (ReaderFacade) context.lookup("java:module/ReaderFacade");
        } catch (Exception e) {
        }
    }

    

    @Override
    public void execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String code = request.getParameter("code");
        Reader newReader = new Reader(name, surname, code);
        readerFacade.create(newReader);
    }

}
