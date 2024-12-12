package class_.level8.com.ll.domain.wiseSaying.entity;

public class WiseSaying {


    private int id;
    private String content;
    private String author;

    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void SetContent(String content) {
        this.content = content;
    }

    public void SetAuthor(String author) {
        this.author = author;
    }
}

