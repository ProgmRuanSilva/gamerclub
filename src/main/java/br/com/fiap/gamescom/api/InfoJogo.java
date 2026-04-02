package br.com.fiap.gamescom.api;

public class InfoJogo {
    private InfoAPIShark info;

    public InfoJogo() {}

    public InfoJogo(InfoAPIShark info) {
        this.info = info;
    }

    public InfoAPIShark getInfo() {
        return info;
    }

    public void setInfo(InfoAPIShark info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return info != null ? info.toString() : "null";
    }
}
