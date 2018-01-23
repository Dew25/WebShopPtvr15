/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Book;
import entity.Maps;
import entity.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Melnikov
 */
@Stateless
public class MapsFacade extends AbstractFacade<Maps> {

    @EJB ReaderFacade readerFacade;
    
    @PersistenceContext(unitName = "NewWebShopPtvr15PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MapsFacade() {
        super(Maps.class);
    }
    public Map<Reader,List<Maps>> getMapReaderWithBooks(){
        Map<Reader,List<Maps>> mapReaderWithBooks = new HashMap<>();
        List<Maps> mapsList = this.findAll();//список карточек
        List<Reader> Readers = readerFacade.findAll();
        
        for (int i = 0; i < Readers.size(); i++) {
            Reader reader = Readers.get(i);
            List<Maps> listMaps = new ArrayList<>();
            for (int j = 0; j < mapsList.size(); j++) {
                Maps maps = mapsList.get(j);
                if(reader.equals(maps.getReader())){
                    listMaps.add(maps);
                }
            }
            mapReaderWithBooks.put(reader, listMaps);
            
        }
        return mapReaderWithBooks;
    }
}
