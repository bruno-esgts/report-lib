package pt.brunojesus.report.productlist.model;

/**
 * Represents a Product entry in the {@link ProductReportData}
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2023-05-17
 */
public class Product {
    private String id;
    private String name;
    private Integer quantity;
    private Double price;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public Product setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Product setPrice(Double price) {
        this.price = price;
        return this;
    }
}
