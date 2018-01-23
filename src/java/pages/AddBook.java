/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import entity.Book;
import interfaces.AbstractPage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import session.BookFacade;

/**
 *
 * @author Melnikov
 */
public class AddBook implements AbstractPage {

    private BookFacade bookFacade;

    public AddBook() {
        Context context;
        try {
            context = new InitialContext();
            this.bookFacade = (BookFacade) context.lookup("java:module/BookFacade");
        } catch (Exception e) {
        }
    }

    @Override
    public void execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String year = request.getParameter("year");
        String isbn = request.getParameter("isbn");
        Book newBook = new Book(name, author, new Integer(year), isbn);
        bookFacade.create(newBook);
    }
}
