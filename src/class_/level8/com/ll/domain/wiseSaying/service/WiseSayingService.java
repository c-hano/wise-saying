package class_.level8.com.ll.domain.wiseSaying.service;

import class_.level8.com.ll.domain.wiseSaying.entity.WiseSaying;
import class_.level8.com.ll.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();

    }

    public WiseSaying add(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(1, content, author);

        wiseSayingRepository.add(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public boolean removeID(int id) {
       return wiseSayingRepository.removeById(id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void modify(WiseSaying wiseSaying, String newContent, String newAuthor) {

        wiseSaying.SetContent(newContent);
        wiseSaying.SetAuthor(newAuthor);

        wiseSayingRepository.modify(wiseSaying);
    }
}
