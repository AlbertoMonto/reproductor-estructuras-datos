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
public class Player implements PlayerIF{
    
    private TuneCollectionIF T;
    private int maxRecentlyPlayed;
    private PlayListManagerIF playListManager;
    private PlayBackQueueIF playBackQueue;
    private RecentlyPlayedIF recentlyPlayed;
  
    
    
    /* Constructor de la clase que implementa PlayerIF */
    /* @param -una colección de canciones como un objeto TuneCollectionIF */
    /* -un entero representando el número máximo de canciones */
    /* reproducidas que se pueden almacenar */
    
    public Player(TuneCollectionIF T,int maxRecentlyPlayed){
        this.T=T;
        this.maxRecentlyPlayed= maxRecentlyPlayed;
    }

    @Override
    public ListIF<String> getPlayListIDs() {
        List<String> playlists = new List<>();
        int contador= 0;
        while(contador<T.size()) {
            T.getTune(contador);
            contador++;
            }
        return playlists;
        }
        
    

    @Override
    public ListIF<Integer> getPlayListContent(String playListID) {
        if(playListManager.contains(playListID)){
            return playListManager.getPlayList(playListID).getPlayList();
            
        }else{
           playListManager.createPlayList(playListID);
           return playListManager.getPlayList(playListID).getPlayList();
        }
        
    }

    @Override
    public ListIF<Integer> getPlayBackQueue() {
        return playBackQueue.getContent();
    }

    @Override
    public ListIF<Integer> getRecentlyPlayed() {
       return recentlyPlayed.getContent();
    }
    @Override
    public void createPlayList(String playListID) {
        playListManager.createPlayList(playListID);
    }

    @Override
    public void removePlayList(String playListID) {
        playListManager.removePlayList(playListID);
    }

    @Override
    public void addListOfTunesToPlayList(String playListID, ListIF<Integer> lT) {
        playListManager.getPlayList(playListID).addListOfTunes(lT); 
    }

    @Override
    public void addSearchToPlayList(String playListID, String t, String a, String g, String al, int min_y, int max_y, int min_d, int max_d) {
        if(!playListManager.contains(playListID)){
            return;  
        }
        ListIF<Integer> lT= new List<>();
        int contador= 0;
        Query query= new Query(t,a,g,al,min_y,max_y,min_d,max_d);
        List<String> ids = (List<String>) getPlayListIDs();
        List<Integer> canciones;
        IteratorIF<Integer> iteratorAux;
        IteratorIF<String> iterator = ids.iterator();
        while(iterator.hasNext()){
            canciones= (List<Integer>) getPlayListContent(iterator.getNext());
            iteratorAux=canciones.iterator();
            while(iteratorAux.hasNext()){
               if(T.getTune(iteratorAux.getNext()).match(query)) {
                   lT.set(contador, iteratorAux.getNext());
                   contador++;
               }
            }
        }
        addListOfTunesToPlayList(playListID, lT);
    }

    @Override
    public void removeTuneFromPlayList(String playListID, int tuneID) {
        playListManager.getPlayList(playListID).removeTune(tuneID);
    }

    @Override
    public void addListOfTunesToPlayBackQueue(ListIF<Integer> lT) {
        playBackQueue.addTunes(lT);
    }

    @Override
    public void addSearchToPlayBackQueue(String t, String a, String g, String al, int min_y, int max_y, int min_d, int max_d) {
        
        ListIF<Integer> lT= new List<>();
        int contador= 0;
        Query query= new Query(t,a,g,al,min_y,max_y,min_d,max_d);
        List<String> ids = (List<String>) getPlayListIDs();
        List<Integer> canciones;
        IteratorIF<Integer> iteratorAux;
        IteratorIF<String> iterator = ids.iterator();
        while(iterator.hasNext()){
            canciones= (List<Integer>) getPlayListContent(iterator.getNext());
            iteratorAux=canciones.iterator();
            while(iteratorAux.hasNext()){
               if(T.getTune(iteratorAux.getNext()).match(query)) {
                   lT.set(contador, iteratorAux.getNext());
                   contador++;
               }
            }
        }
        addListOfTunesToPlayBackQueue(lT);
    
    }

    @Override
    public void addPlayListToPlayBackQueue(String playListID) { 
        addListOfTunesToPlayBackQueue(playListManager.getPlayList(playListID).getPlayList());
    }

    @Override
    public void clearPlayBackQueue() {
        playBackQueue.clear();
    }

    @Override
    public void play() {
        int tune = playBackQueue.getFirstTune();
        playBackQueue.extractFirstTune();
        recentlyPlayed.addTune(tune);
    }
    
}
