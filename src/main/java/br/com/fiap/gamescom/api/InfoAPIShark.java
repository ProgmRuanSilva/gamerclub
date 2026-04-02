package br.com.fiap.gamescom.api;

public class InfoAPIShark {
    private String title;
    private String thumb;

    public InfoAPIShark() {}

    public InfoAPIShark(String title, String thumb) {
        this.title = title;
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    @Override
    public String toString() {
        return "InfoAPIShark{" +
                "title='" + title + '\'' +
                ", thumb='" + thumb + '\'' +
                '}';
    }
}
