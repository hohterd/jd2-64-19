package by.it.academy.foodorder.service;

import by.it.academy.foodorder.models.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuServiceImpl {
    private static final MenuServiceImpl INSTANCE = new MenuServiceImpl();
        private final List<Menu> mainMenu;

        private MenuServiceImpl() {
            mainMenu = new ArrayList<>();
            mainMenu.add(new Menu(1L, "Pizza"));
            mainMenu.add(new Menu(2L, "Hot Meals"));
            mainMenu.add(new Menu(3L, "Fast Food"));
            mainMenu.add(new Menu(4L, "Salads and Soups"));
            mainMenu.add(new Menu(5L, "Deserts"));
        }

        public static MenuServiceImpl getService() {
            return INSTANCE;
        }

        public List<Menu> getAll() {
            return new ArrayList<>(mainMenu);
        }
}
