/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uned.lsi.eped.pract2023_2024;

/**
 *
 * @author super
 */
public class Tune implements TuneIF{
    
    private String titulo;
    private String autor;
    private String genero;
    private String album;
    private int year;
    private int duracion;
    
    /* Constructor de la clase que implementa TuneIF */
    /* @param -una cadena de caracteres con el título de la canción */
    /* -una cadena de caracteres con el autor de la canción */
    /* -una cadena de caracteres con el género de la canción */
    /* -una cadena de caracteres con el álbum al que pertenece */
    /* -un entero con el año de publicación de la canción */
    /* -un entero con la duración en segundos de la canción */
    /* @pre -titulo != "" && a != "" && g != "" && al != "" && y > 0 && d > 0 */
    Tune(String t, String a, String g, String al, int y, int d){
        this.titulo=t;
        this.autor=a;
        this.genero=g;
        this.album=al;
        this.year=y;
        this.duracion=d;
    }

    
    @Override
    public boolean match(QueryIF q) {
        return titulo.equals(q.getTitle()) &&
                autor.equals(q.getAuthor())&&
                genero.equals(q.getGenre())&&   
                album.equals(q.getAlbum())&&
                q.getMin_year()<= year && year <= q.getMax_year() &&
                q.getMin_duration()<= duracion && duracion <= q.getMax_duration();
    }
}
