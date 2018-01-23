/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import entity.Book;
import interfaces.AbstractPage;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.BookFacade;

/**
 *
 * @author Melnikov
 */
public class GeneralPage implements AbstractPage {

    private BookFacade bookFacade;

    public GeneralPage() {
        Context context;
        try {
            context = new InitialContext();
            this.bookFacade = (BookFacade) context.lookup("java:module/BookFacade");
        } catch (Exception e) {
        }
    }

    @Override
    public void execute(HttpServletRequest request) {

        List<Book> books = bookFacade.findAll();
        request.setAttribute("books", books);
    }

}
