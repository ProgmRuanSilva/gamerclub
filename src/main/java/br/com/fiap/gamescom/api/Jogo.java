package br.com.fiap.gamescom.api;

public class Jogo {
    private String titulo;
    private String capa;
    private String descricao;

    public Jogo() {
    }

    public Jogo(String titulo, String capa) {
        this.titulo = titulo;
        this.capa = capa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Jogo: \n Título: " + titulo + ", \n Capa: " + capa + ", \n Descricao: " + descricao + " \n";
    }
}
