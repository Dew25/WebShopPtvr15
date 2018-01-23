/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Melnikov
 */
public interface AbstractPage {
    public void execute(HttpServletRequest request);
}
