package pt.brunojesus.report.guestlist;

import pt.brunojesus.report.common.Report;
import pt.brunojesus.report.common.ReportCompiler;
import pt.brunojesus.report.common.ReportData;
import pt.brunojesus.report.common.ReportViewer;
import pt.brunojesus.report.guestlist.model.Guest;
import pt.brunojesus.report.guestlist.model.GuestReportData;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ReportData reportData = generateGuestReport();

        final ReportCompiler compiler = new ReportCompiler();
        Report report = compiler.apply(reportData);

        final ReportViewer viewer = new ReportViewer();
        viewer.accept(report);
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