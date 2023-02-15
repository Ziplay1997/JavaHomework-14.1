import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    Book item1 = new Book(11, "Пророк", 210, "Пушкин");
    Smartphone item2 = new Smartphone(12, "Ботнарь>", 220, "Samsung");
    Product item3 = new Product(13, "Клубника", 230);
    Product item4 = new Product(14, "Хлеб", 240);
    Product item5 = new Product(15, "Шоколад", 250);
    Product item6 = new Product(16, "Шоколад", 250);

    @Test
    public void shouldAddProduct() {
        ProductRepository repository = new ProductRepository();

        repository.saveProduct(item1);

        Product[] expected = {item1};
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteProduct() {
        ProductRepository repository = new ProductRepository();

        repository.saveProduct(item1);
        repository.saveProduct(item2);
        repository.saveProduct(item3);

        repository.removeById(12);

        Product[] expected = {item1, item3};
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowMessageIfRemoveIdDoesNotExist() {
        ProductRepository repository = new ProductRepository();

        repository.saveProduct(item1);
        repository.saveProduct(item2);
        repository.saveProduct(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(6);

        });
    }

}