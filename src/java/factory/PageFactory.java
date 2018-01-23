/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import interfaces.AbstractPage;
import pages.GeneralPage;
import router.CommandEnum;

/**
 *
 * @author Melnikov
 */
public class PageFactory {
    
    
    public AbstractPage page(String command){
        command = command.toUpperCase();
        try {
           CommandEnum currentPageEnum =  CommandEnum.valueOf(command.toUpperCase());
            AbstractPage currentPage = currentPageEnum.getAbstractPage();
            return currentPage;
        } catch (Exception e) {
            AbstractPage currentPage = new GeneralPage();
            return currentPage;
        }
        
    }
}
