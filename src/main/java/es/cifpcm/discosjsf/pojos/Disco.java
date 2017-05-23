/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.discosjsf.pojos;

/**
 *
 * @author omarl
 */
public class Disco {

    private int idDisco;
    private String titulo;
    private int agno;
    private int idInterprete;

    public Disco() {
    }

    public Disco(String titulo, int agno, int idInterprete) {
        this.titulo = titulo;
        this.agno = agno;
        this.idInterprete = idInterprete;
    }

    public Disco(int idDisco, String titulo, int agno, int idInterprete) {
        this(titulo, agno, idInterprete);
        this.idDisco = idDisco;
    }

    public int getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(int IdDisco) {
        this.idDisco = IdDisco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String Titulo) {
        this.titulo = Titulo;
    }

    public int getAgno() {
        return agno;
    }

    public void setAgno(int Agno) {
        this.agno = Agno;
    }

    public int getIdInterprete() {
        return idInterprete;
    }

    public void setIdInterprete(int IdInterprete) {
        this.idInterprete = IdInterprete;
    }

}
