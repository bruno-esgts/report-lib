package pt.brunojesus.report.productlist.model;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import pt.brunojesus.report.common.ReportData;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductReportData implements ReportData {

    protected String name;
    protected Date date;
    protected String address;
    protected List<Product> products;
    protected String currency;
    protected URL logo;
    protected final URL template;

    public ProductReportData() {
        ClassLoader classLoader = getClass().getClassLoader();
        this.logo = classLoader.getResource("logo.png");
        this.template = classLoader.getResource("product_list.jrxml");
    }

    public String getName() {
        return name;
    }

    public ProductReportData setName(String name) {
        this.name = name;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public ProductReportData setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ProductReportData setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public ProductReportData setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public ProductReportData setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public URL getLogo() {
        return logo;
    }

    public ProductReportData setLogo(URL logo) {
        this.logo = logo;
        return this;
    }

    @Override
    public URL getTemplate() {
        return this.template;
    }

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", getName());
        parameters.put("date", getDate());
        parameters.put("address", getAddress());
        parameters.put("products", new JRBeanCollectionDataSource(getProducts()));
        parameters.put("currency", getCurrency());
        parameters.put("logo", getLogo());

        return parameters;
    }
}
