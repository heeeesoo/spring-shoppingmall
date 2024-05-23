package com.example.shoppingmall.product;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private int id;
    @NotBlank(message = "이름은 필수 입력입니다.")
    private String name;
    @NotBlank(message = "가격은 필수 입력입니다.")
    private int price;
    @NotBlank(message = "설명은 필수 입력입니다.")
    private String description;
    @NotBlank(message = "카테고리 아이디는 필수 입력입니다.")
    private int categoryId;

    public Product convertToEntity() {
        return new Product(name, price, description, categoryId);
    }
}
