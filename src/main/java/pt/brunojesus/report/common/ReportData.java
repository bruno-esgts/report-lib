package pt.brunojesus.report.common;

import java.net.URI;
import java.net.URL;
import java.util.Map;

public interface ReportData {

    URL getTemplate();

    Map<String,Object> toMap();
}
