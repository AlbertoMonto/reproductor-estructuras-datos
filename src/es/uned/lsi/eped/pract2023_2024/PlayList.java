/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uned.lsi.eped.pract2023_2024;

import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.ListIF;

/**
 *
 * @author super
 */
public class PlayList implements PlayListIF{
    
    private String nombre;
    private List<Integer> canciones = new List<Integer>();
    private int contador = 0;
    
    public PlayList(String nombre){
        this.nombre=nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    @Override
    public ListIF<Integer> getPlayList() {
        return canciones;
    }

    @Override
    public void addListOfTunes(ListIF<Integer> lT) {
        IteratorIF<Integer> iterator = lT.iterator();
        int id;
        while(iterator.hasNext()) {
            id = iterator.getNext();
            canciones.set(contador,id);
            contador++;
        }
    }

    @Override
    public void removeTune(int tuneID) {
        IteratorIF<Integer> iterator = canciones.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            if(iterator.getNext()==tuneID){
                canciones.remove(i);
            }
            i++;
        }
    }
    
}
