package com.example.purchasereceiptpdfspringapi.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product {
    private String name;
    private double price;
}
