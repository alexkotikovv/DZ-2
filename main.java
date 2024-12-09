/**
 * Класс для представления товара с его количеством, ценой и скидкой.
 * Этот класс позволяет вычислить общую сумму покупки как без скидки, так и со скидкой.
 */
class Product {
    // Количество товаров
    private int quantity; // целочисленное значение - количество товаров
    
    // Цена товара
    private double price; // вещественное значение - цена товара
    
    // Скидка на товар в процентах
    private double discount; // вещественное значение - скидка на товар

    /**
     * Конструктор для создания объекта Product.
     *
     * @param quantity количество товаров
     * @param price цена товара
     * @param discount скидка на товар в процентах
     */
    public Product(int quantity, double price, double discount) {
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    /**
     * Метод для вычисления и вывода общей суммы покупки.
     *
     * @param product объект типа Product
     */
    public static void calculateTotal(Product product) {
        double totalWithoutDiscount = product.quantity * product.price; // общая сумма без скидки
        double totalDiscountAmount = (product.discount / 100) * totalWithoutDiscount; // сумма скидки
        double totalWithDiscount = totalWithoutDiscount - totalDiscountAmount; // общая сумма со скидкой

        // Округление итоговых сумм до 2 знаков после запятой
        totalWithoutDiscount = Math.round(totalWithoutDiscount * 100.0) / 100.0;
        totalWithDiscount = Math.round(totalWithDiscount * 100.0) / 100.0;

        System.out.printf("Общая сумма покупки без скидки: %.2f%n", totalWithoutDiscount);
        System.out.printf("Общая сумма покупки со скидкой: %.2f%n", totalWithDiscount);
    }
}

/**
 * Главный класс для запуска программы.
 */
public class Main {
    public static void main(String[] args) {
        // Создание объектов Product с различными параметрами
        Product product1 = new Product(10, 50.0, 0.75); // 10 товаров по 50 с 0.75% скидкой
        Product product2 = new Product(5, 200.0, 42.575); // 5 товаров по 200 с 42.575% скидкой
        Product product3 = new Product(3, 150.0, 59.1); // 3 товара по 150 с 59.1% скидкой

        // Вызов метода calculateTotal для каждого продукта
        Product.calculateTotal(product1);
        Product.calculateTotal(product2);
        Product.calculateTotal(product3);
    }
}
