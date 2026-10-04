/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uned.lsi.eped.pract2023_2024;

/**
 *
 * @author super
 */
public class Query implements QueryIF{
    String titulo;
    String autor; 
    String genero; 
    String album;
    int yearMin;
    int yearMax;
    int durMin;
    int durMax;
    
    public Query(String titulo, String autor, String genero, String album, int yearMin, int yearMax, int durMin, int durMax){
        this.titulo=titulo;
        this.autor=autor;
        this.genero=genero;
        this.album=album;
        this.yearMin=yearMin;
        this.yearMax=yearMax;
        this.durMin=durMin;
        this.durMax=durMax;
    }
    
    @Override
    public String getTitle() {
        return titulo;
    }

    @Override
    public String getAuthor() {
        return autor;
    }

    @Override
    public String getGenre() {
        return genero;
    }

    @Override
    public String getAlbum() {
        return album;
    }

    @Override
    public int getMin_year() {
        return yearMin;
    }

    @Override
    public int getMax_year() {
        return yearMax;
    }

    @Override
    public int getMin_duration() {
        return durMin;
    }

    @Override
    public int getMax_duration() {
        return durMax;
    }
    
}
