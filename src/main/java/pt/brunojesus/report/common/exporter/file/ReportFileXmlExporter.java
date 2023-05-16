package pt.brunojesus.report.common.exporter.file;

import pt.brunojesus.report.common.Report;
import pt.brunojesus.report.common.exporter.array.ReportArrayExporter;
import pt.brunojesus.report.common.exporter.array.ReportArrayXmlExporter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Exports the provided {@link Report} to XML and saves it in the filesystem.
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-03-30
 */
public class ReportFileXmlExporter implements ReportFileExporter {

    private final ReportArrayExporter reportArrayExporter;

    public ReportFileXmlExporter() {
        reportArrayExporter = new ReportArrayXmlExporter();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(Report report, String targetFileName) {
        try {
            Files.write(
                    Path.of(targetFileName),
                    reportArrayExporter.apply(report)
            );
        } catch (IOException e) {
            throw new RuntimeException("Error exporting XML report");
        }
    }
}
