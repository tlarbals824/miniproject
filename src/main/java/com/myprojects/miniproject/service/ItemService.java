package com.myprojects.miniproject.service;


import com.myprojects.miniproject.domain.Item;
import com.myprojects.miniproject.domain.dto.ItemDto;
import com.myprojects.miniproject.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {

    @Autowired
    ItemRepository itemRepository;


    /**
     * 아이템 등록
     * @author 심규민
     * @return
     */
    public Long saveItem(Item item){
        itemRepository.save(item);
        return item.getId();
    }

    /**
     * 아이템 전체 조회
     * @author 심규민
     *
     */
    public List<Item> findAllItems(){
        return itemRepository.findAll();
    }

    /**
     * 아이템 검색(아이디)
     * @author 심규민
     *
     */
    public Item findOneItemById(Long itemId){
        Optional<Item> findItem = itemRepository.findById(itemId);
        return findItem.get();
    }
    /**
     * 아이템 검색(이름)
     * @author 심규민
     *
     */
    public List<Item> findItemsByName(String name){
        List<Item> findItems = itemRepository.findByName(name);
        return findItems;
    }

    /**
     * 아이템 수정
     * @author 심규민
     * @return
     */
    public Item updateItem(Long itemId, ItemDto item){
        Item findItem = itemRepository.findById(itemId).get();
        findItem.update(item);
        return findItem;
    }

}
