package pt.brunojesus.report.common;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import java.util.function.Function;

/**
 * Compiles and fills a report with the given {@link ReportData}
 *
 * @author Bruno Jesus
 * @version 1.1
 * @since 2022-03-30
 */
public class ReportCompiler implements Function<ReportData, Report> {

    /**
     * Compiles and fills a report with the given {@link ReportData}
     *
     * @param reportData the report data to include in the report
     * @return The compiled and filled {@link Report}
     */
    @Override
    public Report apply(ReportData reportData) {
        final JasperReport compiledReport = compile(reportData.getTemplate());
        final JasperPrint filledReport = fill(compiledReport, reportData);

        return new Report(filledReport);
    }

    private JasperReport compile(URL template) {
        JasperReport jasperReport;
        try (InputStream is = template.openStream()) {
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
        } catch (IOException | JRException e) {
            throw new RuntimeException("Error compiling report", e);
        }
        return jasperReport;
    }

    private JasperPrint fill(JasperReport report, ReportData reportInput) {
        JasperPrint jasperPrint;
        try {
            jasperPrint = JasperFillManager.fillReport(
                    report,
                    reportInput.toMap(),
                    new JREmptyDataSource()
            );
        } catch (JRException e) {
            throw new RuntimeException("Error while filling report", e);
        }

        return jasperPrint;
    }
}
