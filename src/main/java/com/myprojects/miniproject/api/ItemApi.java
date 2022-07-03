package com.myprojects.miniproject.api;


import com.myprojects.miniproject.domain.Item;
import com.myprojects.miniproject.domain.dto.ItemDto;
import com.myprojects.miniproject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping(value = "/items")
public class ItemApi {

    @Autowired
    private ItemService itemService;

    /**
     * @author 심규민
     * CRUD: Read(Get)
     * 전체 목록 조회
     */
    @GetMapping
    public String allItems(Model model){
        List<Item> items = itemService.findAllItems();
        model.addAttribute("items",items);
        return "item/items";
    }

    /**
     * @author 심규민
     * CRUD: Read(Get)
     * 단일 아이템 수정 조회
     */
    @GetMapping(value = "/{itemId}/edit")
    public String editForm(@PathVariable("itemId")Long itemId,Model model){
        Item findItem = itemService.findOneItemById(itemId);
        model.addAttribute("item",findItem);
        return "item/itemedit";
    }

    /**
     * @author 심규민
     * CRUD: Update(Post)
     * 단일 아이템 수정
     */
    @PostMapping(value = "/{itemId}/edit")
    public String edit(@ModelAttribute("item") ItemDto itemDto, @PathVariable("itemId") Long itemId){
        itemService.updateItem(itemId,itemDto);
        return "redirect:/items/{itemId}";
    }

    @GetMapping(value = "/{itemId}")
    public String inform(@PathVariable("itemId")Long id,Model model){
        model.addAttribute("item",itemService.findOneItemById(id));
        return "item/iteminformation";
    }

    @PostMapping(value = "/{itemId}")
    public String informToEdit(@PathVariable("itemId")Long id,
                               @ModelAttribute("item") ItemDto item){
        return "redirect:/items/{itemId}/edit";
    }

    @GetMapping(value = "/item-add")
    public String itemAdd(){
        return "item/itemadd";
    }

    @PostConstruct
    public void init(){
        Item item1 = new Item("item1",10000,10);
        Item item2 = new Item("item2",20000,20);
        itemService.saveItem(item1);
        itemService.saveItem(item2);
    }
}
