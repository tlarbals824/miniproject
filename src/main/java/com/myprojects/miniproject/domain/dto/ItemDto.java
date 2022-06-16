package com.myprojects.miniproject.domain.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class ItemDto {

    private String name;
    private int price;
    private int quantity;
}
