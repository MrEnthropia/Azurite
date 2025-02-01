package ru.MrEnthropia.UEAJ.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.MrEnthropia.UEAJ.models.Log;

import java.util.List;


public interface LogsRepository extends JpaRepository<Log, Long> {

    Iterable<Log> findByNumberStation(int i);
    List<Log> findTop7ByOrderByDateTimeDesc();
}
