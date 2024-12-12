package class_.level8.com.ll.domain.wiseSaying.service;

import class_.level8.com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingService {
    private final List<WiseSaying> wiseSayings;

    public int getCount() {
        return count;
    }

    private int count;

    public WiseSayingService() {
        this.wiseSayings = new ArrayList<>();
        this.count = 1;
    }

    public  void addWiseSaying(String content, String author) {
        wiseSayings.add(new WiseSaying(count, content, author));
        count++;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public boolean removeID(int id) {
       return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayings.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public void modify(WiseSaying foundWiseSaying, String newContent, String newAuthor) {

        foundWiseSaying.SetContent(newContent);
        foundWiseSaying.SetAuthor(newAuthor);
    }
}
