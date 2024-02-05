# Report Generation Library
**Generate reports and exports them to multiple formats**

## Getting started

### Importing the library
In order to use this library you first need to add the maven dependency
on your project.

You can do it by adding this in your projects `pom.xml`
```xml
<dependency>
  <groupId>pt.brunojesus</groupId>
  <artifactId>report-lib</artifactId>
  <version>1.1</version>
</dependency>
```

The dependency listed above is not on maven central, so you need to make
sure you add the repository to your project's `pom.xml` as well.
```xml
    <repositories>
        <repository>
            <id>mvn-brunojesus</id>
            <name>Bruno Jesus MVN Repo</name>
            <url>https://mvn.brunojesus.pt/releases</url>
        </repository>
    </repositories>
```

### Generating a report
This library generates the following reports:
  - ProductReport
  - GuestReport

#### Generating a ProductReport
In order to generate a ProductReport you need to fill a `ReportData` object:

```java
import pt.brunojesus.report.common.ReportData;

class MyReportGenerator {
    public static void main(String[] args) {
        ReportData reportData = new ProductReportData()
                .setName("Software Engineering Party")
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
                                        .setName("Coffee")
                                        .setQuantity(30)
                                        .setPrice(8d)
                        )
                );
    }
}
```

#### Generating a GuestReport 
```java
import pt.brunojesus.report.common.ReportData;

class MyReportGenerator {
    public static void main(String[] args) {
        ReportData reportData = new GuestReportData()
                .setEventName("My event name")
                .setEventDate(new Date())
                .setAddress("ESGTS\nIPSantarem")
                .setGuests(
                        List.of(
                                new Guest().setName("Bruno Jesus").setContact("+351911234567").setPresent(true),
                                new Guest().setName("Guest 1").setContact("+351911234568").setPresent(false),
                                new Guest().setName("Guest 2").setContact("student@ipsantarem.pt")
                        )
                );
    }
}
```

#### Compiling the report
After the `ReportData` is created we need to **compile** the `Report`:
```java
final ReportCompiler compiler = new ReportCompiler();
Report report = compiler.apply(reportData);
```
This code will return a `Report` object that can be exported.

#### Exporting the report
A compiled `Report` can be exported to a file or a `byte[]`.

The file exporters implement the `ReportFileExporter` **interface**.

The following file exporters are available:
 - `ReportFileHtmlExporter`
 - `ReportFilePdfExporter`
 - `ReportFileXmlExporter`

Example of exporting to a `html` document:
```java
final ReportFileExporter exporter = new ReportFileHtmlExporter();
exporter.accept(report, "report.html");
```

If you do not want to export directly to the file system there's also
the `ReportArrayExporter` that returns a `byte[]` instead.

The following `ReportArrayExporter`s are available:
 - `ReportArrayPdfExporter`
 - `ReportArrayXmlExporter`

#### Viewing the report
There's also a `ReportViewer` that takes a `Report` and opens a preview
window displaying the compiled report.

```java
final ReportViewer viewer = new ReportViewer();
viewer.accept(report);
```