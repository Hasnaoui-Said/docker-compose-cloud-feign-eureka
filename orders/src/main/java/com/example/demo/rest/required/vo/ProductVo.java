package com.example.demo.rest.required.vo;

import java.util.UUID;

public class ProductVo {
    private UUID uuid;
    private String name;
    private String description;
    private String ref;
    private String quantity;
    private String price;
    private String idStock;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIdStock() {
        return idStock;
    }

    public void setIdStock(String idStock) {
        this.idStock = idStock;
    }

    @Override
    public String toString() {
        return "ProductVo{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ref='" + ref + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                ", idStock='" + idStock + '\'' +
                '}';
    }
}
