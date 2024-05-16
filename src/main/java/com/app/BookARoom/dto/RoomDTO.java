package com.app.BookARoom.dto;

public class RoomDTO {
    private Long id;
    private int number;
    private int type;
    private boolean isAvailable;
    private int price;
    public RoomDTO(){

    }
    public RoomDTO(Long id, int number,int type, boolean isAvailable, int price){
        this.id=id;
        this.number=number;
        this.type=type;
        this.isAvailable=isAvailable;
        this.price=price;
    }
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public int getType() {
        return type;
    }
    
    public void setType(int type) {
        this.type = type;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
}
