package ru.MrEnthropia.Azurite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.MrEnthropia.Azurite.models.Log;

import java.util.List;


public interface LogsRepository extends JpaRepository<Log, Long> {

    Iterable<Log> findByNumberStation(int i);
    List<Log> findTop7ByOrderByDateTimeDesc();
}
