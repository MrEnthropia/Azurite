package ru.MrEnthropia.Azurite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.MrEnthropia.Azurite.models.Item;

public interface ItemsRepository extends JpaRepository<Item,Long> {

}
