/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.Queue;

import java.util.NoSuchElementException;

/**
 *
 * @author super
 */
public class PlayBackQueue implements PlayBackQueueIF {
    
    private Queue<Integer> lista = new Queue<>();
    
    
    
    
    public PlayBackQueue(){
        
    }
    
    @Override
    public ListIF<Integer> getContent() {
        List<Integer> secuencia = new List<>();
        IteratorIF<Integer> iterator = lista.iterator();
        int id;
        int contador = 0;
        while(iterator.hasNext()) {
            id = iterator.getNext();
            secuencia.set(contador,id);
            contador++;
        }
        return secuencia;
    }

    @Override
    public boolean isEmpty() {
        if(lista.getFirst()!=null){
            return false;
        }
        return true;
    }

    @Override
    public int getFirstTune() {
        if(lista.isEmpty()){
            throw new NoSuchElementException("La lista esta vacia");
        }else{
          return lista.getFirst();  
        }
    }
    

    @Override
    public void extractFirstTune() {
        if(!lista.isEmpty()){
           lista.getFirst();
           lista.dequeue();
        }
        
    
    }

    @Override
    public void addTunes(ListIF<Integer> lT) {
        IteratorIF<Integer> iterator = lT.iterator();
        int id;
        while(iterator.hasNext()) {
            id = iterator.getNext();
            lista.enqueue(id);
        }
    }

    @Override
    public void clear() {
        lista.clear();
    }
    
}
