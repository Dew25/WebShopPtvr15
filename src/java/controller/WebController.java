/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Book;
import entity.Maps;
import entity.Reader;
import factory.PageFactory;
import interfaces.AbstractPage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pages.AddBook;
import pages.AddReader;
import pages.GeneralPage;
import session.BookFacade;
import session.MapsFacade;
import session.ReaderFacade;
import util.MyDate;

/**
 *
 * @author Melnikov
 */
@WebServlet(name = "WebController", urlPatterns = {"/webcontroller","/addBook","/addReader","/maps","/addMap","/addBookToReader"})
public class WebController extends HttpServlet {

    @EJB BookFacade bookFacade;
    @EJB ReaderFacade readerFacade;
    @EJB MapsFacade mapsFacade;
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        String newPath = path.substring(1);
        PageFactory factory = new PageFactory();
        AbstractPage abstractPage = factory.page(newPath);
        abstractPage.execute(request);
        if("/webcontroller".equals(path)){
            request.getRequestDispatcher("general.jsp").forward(request, response);
        }else if("/addBook".equals(path)){
            request.getRequestDispatcher("webcontroller").forward(request, response);
        }else if("/addReader".equals(path)){
            request.getRequestDispatcher("webcontroller").forward(request, response);
        }else if("/maps".equals(path)){
            request.getRequestDispatcher("maps.jsp").forward(request, response);
        }else if("/addMap".equals(path)){
            List<Reader> readers = readerFacade.findAll();
            List<Book> books = bookFacade.findAll();
            request.setAttribute("readers", readers);
            request.setAttribute("books", books);
            request.getRequestDispatcher("addMap.jsp").forward(request, response);
        }else if("/addBookToReader".equals(path)){
            String readerId = request.getParameter("reader_id");
            String bookId = request.getParameter("book_id");
            String backTime = request.getParameter("back_time");
            Reader reader = readerFacade.find(new Long(readerId));
            Book book = bookFacade.find(new Long(bookId));
            Calendar date = new GregorianCalendar();
            int intBackTime= Integer.parseInt(backTime);
            MyDate myDate = new MyDate();
            Date datePlus = myDate.getDatePlus(date.getTime(), intBackTime);
            Maps maps = new Maps(book, reader, date.getTime(), datePlus);
            mapsFacade.create(maps);
            request.getRequestDispatcher("webcontroller").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
