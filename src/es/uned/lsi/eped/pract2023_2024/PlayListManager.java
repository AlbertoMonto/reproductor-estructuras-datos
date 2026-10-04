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
public class PlayListManager implements PlayListManagerIF{
    
    private List<PlayList> listas= new List<PlayList>();
    
    public PlayListManager(){
    
    }
    
    @Override
    public boolean contains(String playListID) {
        IteratorIF<PlayList> iterator = listas.iterator();
        PlayList playlist;
        while(iterator.hasNext()) {
            playlist = iterator.getNext();
            if(playlist.getNombre().equals(playListID)){
                return true;
            }
        }
        return false;
    }

    @Override
    public PlayListIF getPlayList(String playListID) {
        IteratorIF<PlayList> iterator = listas.iterator();
        PlayList playlist;
        while(iterator.hasNext()) {
            playlist = iterator.getNext();
            if(playlist.getNombre().equals(playListID)){
                return playlist;
            }
        }
        return null;
    }
    

    @Override
    public ListIF<String> getIDs() {
        List<String> ids= new List<String>();
        IteratorIF<PlayList> iterator = listas.iterator();
        int contador= 0;
        PlayList playlist;
        while(iterator.hasNext()){
            playlist = iterator.getNext();
            ids.set(contador,playlist.getNombre());
            contador++;
        }
        return ids;
    }

    @Override
    public void createPlayList(String playListID) {
        IteratorIF<PlayList> iterator = listas.iterator();
        int contador= 0;
        PlayList playlist;
        while(iterator.hasNext()){
            playlist = iterator.getNext();
            if(playlist.getNombre().equals(playListID)){
                return;
            }
            contador++;
        }
        listas.set(contador,new PlayList(playListID));
    }

    @Override
    public void removePlayList(String playListID) {
        IteratorIF<PlayList> iterator = listas.iterator();
        int contador= 0;
        PlayList playlist;
        while(iterator.hasNext()){
            playlist = iterator.getNext();
            if(playlist.getNombre().equals(playListID)){
                listas.remove(contador);
            }
            contador++;
        }  
    }
    
}
