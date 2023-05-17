package pt.brunojesus.report.common;

import java.net.URL;
import java.util.Map;

/**
 * Interface for a ReportData to be compiled
 *
 * @author Bruno Jesus
 * @version 1.0
 * @see ReportCompiler
 * @since 2023-05-17
 */
public interface ReportData {

    /**
     * Gets the URL for the report template
     * The URL should point to a <b>jrxml</b> file
     *
     * @return the URL for the report template
     */
    URL getTemplate();

    /**
     * Puts all the report attributes into a {@link Map} to be parsed by
     * the {@link ReportCompiler}
     *
     * @return the {@link Map} that fills the Report template.
     */
    Map<String, Object> toMap();
}
