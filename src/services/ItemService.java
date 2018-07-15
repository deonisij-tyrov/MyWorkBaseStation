package services;

import entities.Item;

public interface ItemService {
    Item save(Item item);

    Item get(Long id);

    void update(Item item);

    int delete(Long id);

}
