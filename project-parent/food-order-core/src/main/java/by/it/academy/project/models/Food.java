package by.it.academy.project.models;

import java.util.Objects;

public class Food {

    private Long id;
    private String name;
    private Long price;
    private String ingredients;
    private Long discount;
    private Long weight;
    private Long cookingTime;
    private boolean delivery;

    public Food() {
    }

    public Food(Long id, String name, Long price, String ingredients, Long discount, Long weight, Long cookingTime, boolean delivery) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.discount = discount;
        this.weight = weight;
        this.cookingTime = cookingTime;
        this.delivery = delivery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Long cookingTime) {
        this.cookingTime = cookingTime;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return delivery == food.delivery &&
                Objects.equals(id, food.id) &&
                Objects.equals(name, food.name) &&
                Objects.equals(price, food.price) &&
                Objects.equals(ingredients, food.ingredients) &&
                Objects.equals(discount, food.discount) &&
                Objects.equals(weight, food.weight) &&
                Objects.equals(cookingTime, food.cookingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, ingredients, discount, weight, cookingTime, delivery);
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", ingredients='" + ingredients + '\'' +
                ", discount=" + discount +
                ", weight=" + weight +
                ", cookingTime=" + cookingTime +
                ", delivery=" + delivery +
                '}';
    }
}
