package pt.brunojesus.report;

import pt.brunojesus.report.common.Report;
import pt.brunojesus.report.common.ReportCompiler;
import pt.brunojesus.report.common.ReportData;
import pt.brunojesus.report.common.ReportViewer;
import pt.brunojesus.report.guestlist.model.Guest;
import pt.brunojesus.report.guestlist.model.GuestReportData;
import pt.brunojesus.report.productlist.model.Product;
import pt.brunojesus.report.productlist.model.ProductReportData;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ReportData reportData = generateProductReport();

        final ReportCompiler compiler = new ReportCompiler();
        Report report = compiler.apply(reportData);

        final ReportViewer viewer = new ReportViewer();
        viewer.accept(report);
    }

    private static ReportData generateProductReport() {
        return new ProductReportData()
                .setName("Software Engineering Exam")
                .setDate(new Date())
                .setAddress("ESGTS\nIPSantarem")
                .setCurrency("€")
                .setProducts(
                        List.of(
                                new Product()
                                        .setId("978020137962")
                                        .setName("Pringles Original")
                                        .setQuantity(20)
                                        .setPrice(10d),
                                new Product()
                                        .setId("495020137962")
                                        .setName("Sagres Mini Pack 9")
                                        .setQuantity(30)
                                        .setPrice(8d)
                        )
                );
    }

    private static ReportData generateGuestReport() {
        return new GuestReportData()
                .setEventName("Teste de Engenharia de Software")
                .setEventDate(new Date())
                .setAddress("ESGTS\nIPSantarem")
                .setGuests(
                        List.of(
                                new Guest().setName("Bruno Jesus").setContact("+351911234567").setPresent(true),
                                new Guest().setName("Manel Jesus").setContact("+351911234568").setPresent(false),
                                new Guest().setName("Some student").setContact("student@ipsantarem.pt")
                        )
                );
    }
}