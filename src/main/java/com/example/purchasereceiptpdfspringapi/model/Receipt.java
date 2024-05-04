package com.example.purchasereceiptpdfspringapi.model;


import lombok.*;

import java.util.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Receipt {
    private String market;
    private String client;
    private List<Product> products;
    private Status status;
}
