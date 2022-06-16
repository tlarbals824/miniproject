package com.myprojects.miniproject.domain;

import com.myprojects.miniproject.domain.dto.ItemDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter@Setter
@ToString(of = {"name","price","quantity"})
public class Item {

    @Id@GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int quantity;

    public Item() {
    }

    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void update(ItemDto item){
        this.price=item.getPrice();
        this.name=item.getName();
        this.quantity=item.getQuantity();
    }
}
