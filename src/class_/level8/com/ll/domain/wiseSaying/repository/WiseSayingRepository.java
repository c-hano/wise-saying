package class_.level8.com.ll.domain.wiseSaying.repository;

import class_.level8.com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class WiseSayingRepository {

    public abstract void add(WiseSaying wiseSaying);

    public abstract List<WiseSaying> findAll();

    public abstract boolean removeById(int id);

    public abstract Optional<WiseSaying> findById(int id);

    public abstract void modify(WiseSaying wiseSaying);
}
