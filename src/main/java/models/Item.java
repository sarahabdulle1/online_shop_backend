package models;

public class Item {
    private String name;
    private Long price;
//    constructor
    public Item(String name, Long price) {
        this.name = name;
        this.price = price;
    }
//    getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
