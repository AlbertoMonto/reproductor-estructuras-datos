/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;
import es.uned.lsi.eped.DataStructures.Stack;

/**
 *
 * @author super
 */
public class RecentlyPlayed implements RecentlyPlayedIF {

    private int id;
    private Stack<Integer> canciones = new Stack<Integer>();
    private int size = 0;
    
    public RecentlyPlayed(int size){
        this.size=size;
    }    
    
    
    
    @Override
    public ListIF<Integer> getContent() {
     List<Integer> secuencia = new List<Integer>();
        IteratorIF<Integer> iterator = canciones.iterator();
        
        int contador = 0;
        while(iterator.hasNext()) {
            id = iterator.getNext();
            secuencia.set(contador,id);
            contador++;
        }
        return secuencia;
    }

    @Override
    public void addTune(int tuneID) {
        IteratorIF<Integer> iterator = canciones.iterator();
        int contador = 0;
        while(iterator.hasNext()) {
            contador++;
        }
        if (contador>size){
            System.out.println("El almacen ha llegado a su capacidad maxima");
    
        }else{
            canciones.push(tuneID);
        }
    }
}
