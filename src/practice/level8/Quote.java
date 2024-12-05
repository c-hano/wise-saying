package practice.level8;

public class Quote {

    private String author;
    private String comment;
    private int indexNumber;

    public Quote(String author, String comment, int indexNumber) {
        this.author = author;
        this.comment = comment;
        this.indexNumber = indexNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    @Override
    public String toString() {
        return indexNumber + " / " + author + " / " + comment;
    }
}
