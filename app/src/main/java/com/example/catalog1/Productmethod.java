package com.example.catalog1;

public class Productmethod {
    String product_id,getcategory_id,product_name,product_price,productqauntity,productdiscription,product_image;

    public Productmethod(String product_id, String getcategory_id, String product_name, String product_price,
                         String productqauntity, String productdiscription, String product_image) {
        this.product_id = product_id;
        this.getcategory_id = getcategory_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.productqauntity = productqauntity;
        this.productdiscription = productdiscription;
        this.product_image = product_image;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getGetcategory_id() {
        return getcategory_id;
    }

    public void setGetcategory_id(String getcategory_id) {
        this.getcategory_id = getcategory_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProductqauntity() {
        return productqauntity;
    }

    public void setProductqauntity(String productqauntity) {
        this.productqauntity = productqauntity;
    }

    public String getProductdiscription() {
        return productdiscription;
    }

    public void setProductdiscription(String productdiscription) {
        this.productdiscription = productdiscription;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
   }
}
