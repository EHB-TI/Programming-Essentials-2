package entity;

public class NoSuchItem extends Exception {
    private Media media;

    public NoSuchItem(Media media) {
        super(media.getTitel()+" niet aanwezig.");
        this.media = media;
    }

    public Media getMedia() {
        return media;
    }

}
