/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package router;

import interfaces.AbstractPage;
import pages.AddBook;
import pages.AddReader;
import pages.GeneralPage;
import pages.MapsPage;

/**
 *
 * @author Melnikov
 */
public enum CommandEnum {
    WEBCONTROLLER{{this.page = new GeneralPage();}},
    ADDBOOK{{this.page = new AddBook();}},
    ADDREADER{{this.page = new AddReader();}},
    MAPS{{this.page = new MapsPage();}},
    ;
    
    AbstractPage page;
    public AbstractPage getAbstractPage(){
        return page;
    }
    
}
