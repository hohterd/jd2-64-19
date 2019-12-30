CREATE TABLE Dish
(
    dish_id         int             NOT NULL PRIMARY KEY ,
    dish_name       VARCHAR(255)    NOT NULL,
    ingredients     VARCHAR (255)   NOT NULL,
    weight          decimal         NOT NULL,
    cooking_time    int             NOT NULL,
    price           decimal         NOT NULL
);

CREATE TABLE Category
(
    category_id    int            NOT NULL PRIMARY KEY ,
    category_name  VARCHAR(100)   NOT NULL,
    dish_id        int            NOT NULL,
    CONSTRAINT FK_Dish FOREIGN KEY (dish_id) REFERENCES Dish (dish_id)
);

CREATE TABLE Food
(
    id             int            NOT NULL PRIMARY KEY AUTO_INCREMENT,
    category_id    int            NOT NULL,
    discount       decimal        NOT NULL,
    delivery       bit            NOT NULL,
    CONSTRAINT FK_Category FOREIGN KEY (category_id) REFERENCES Category (category_id)
);




