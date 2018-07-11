package services;

import entities.Item;

import java.io.Serializable;
import java.util.List;

public interface ItemService {
    Item save(Item item);

    Item get(Long id);

    void update(Item item);

    int delete(Long id);

}
