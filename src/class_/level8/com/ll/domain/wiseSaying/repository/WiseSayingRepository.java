package class_.level8.com.ll.domain.wiseSaying.repository;

import class_.level8.com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface WiseSayingRepository {

    void add(WiseSaying wiseSaying);

    List<WiseSaying> findAll();

    boolean removeById(int id);

    Optional<WiseSaying> findById(int id);

    void modify(WiseSaying wiseSaying);
}
