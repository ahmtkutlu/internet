/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author Kutlu
 * @param <T>
 */
public interface DAO <T>{
    public List<T> findAll() ;
    public void insert (T Entity) ;
    public void update (T Entity) ;
    public void delete (T Entity) ;
    public T find (Long id) ;
    public List<T> findAll(int page , int pageSize) ;
}
