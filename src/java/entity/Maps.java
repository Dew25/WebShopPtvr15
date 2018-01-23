/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Melnikov
 */

@Entity
public class Maps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Book book;
    @OneToOne
    private Reader reader;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Temporal(TemporalType.TIMESTAMP)
    private Date backTime;

    public Maps() {
    }

    public Maps(Book book, Reader reader, Date date, Date backTime) {
        this.book = book;
        this.reader = reader;
        this.date = date;
        this.backTime=backTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getBackTime() {
        
        return this.backTime;
    }

    public void setBackTime(Date backTime) {
        
        this.backTime=backTime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.book);
        hash = 97 * hash + Objects.hashCode(this.reader);
        hash = 97 * hash + Objects.hashCode(this.date);
        hash = 97 * hash + Objects.hashCode(this.backTime);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Maps other = (Maps) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.reader, other.reader)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.backTime, other.backTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Maps{" + "id=" + id + ", book=" + book.getName() + ", reader=" + reader.getName() +" " + reader.getSurname() +  ", date=" + date.toString() + ", backTime=" + backTime.toString() + '}';
    }
    
    
}
