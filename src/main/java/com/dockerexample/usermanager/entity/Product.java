package com.dockerexample.usermanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(schema = "basic", name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "parent_id")
    private String parentId;
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
    @Column(name = "image")
    private String image;
    @Column(name = "available")
    private Boolean available;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "precis")
    private String precis;
    @Column(name = "list_price_ex_tax")
    private BigDecimal listPriceExTax;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "category")
    private String category;
    @Column(name = "stock")
    private Long stock;
    @Column(name = "created")
    private Date created;
    @Column(name = "updated")
    private Date updated;
}
