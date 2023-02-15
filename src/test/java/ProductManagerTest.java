import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Book item1 = new Book(11, "Пророк", 210, "Пушкин");
    Smartphone item2 = new Smartphone(12, "Phone", 220, "Samsung");
    Product item3 = new Product(13, "Шоколад", 230);
    Product item4 = new Product(14, "Хлеб", 240);
    Product item5 = new Product(15, "Шоколад", 250);
    Product item6 = new Product(16, "Шоколад", 250);


    @Test
    public void shouldSearchSomeProduct() {                    ///Находим несколько товаров
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Product[] expected = {item3, item5, item6};
        Product[] actual = manager.searchBy("Шоколад");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneProducts() {                        // Находим только один товар
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Product[] expected = {item2};
        Product[] actual = manager.searchBy("Phone");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNullProduct() {                        // Должен ничего не найти
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Картофель");

        assertArrayEquals(expected, actual);
    }

}