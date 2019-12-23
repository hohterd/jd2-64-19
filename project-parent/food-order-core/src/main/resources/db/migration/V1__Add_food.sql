CREATE TABLE Food
(
    id             int            NOT NULL UNIQUE AUTO_INCREMENT,
    category_id    int            NOT NULL PRIMARY KEY,
    discount       decimal        NOT NULL,
    delivery       bit            NOT NULL
);

CREATE TABLE Category
(
    category_id    int            NOT NULL,
    category_name  VARCHAR(100)   NOT NULL,
    dish_id        int            NOT NULL PRIMARY KEY,
    CONSTRAINT FK_Category FOREIGN KEY (category_id) REFERENCES Food (category_id)
);

CREATE TABLE Dish
(
    dish_id         int             NOT NULL,
    dish_name       VARCHAR(255)    NOT NULL,
    ingredients     VARCHAR (255)   NOT NULL,
    weight          decimal         NOT NULL,
    cooking_time    int             NOT NULL,
    price           decimal         NOT NULL,
    CONSTRAINT FK_Dish FOREIGN KEY (dish_id) REFERENCES Category (dish_id)
);
