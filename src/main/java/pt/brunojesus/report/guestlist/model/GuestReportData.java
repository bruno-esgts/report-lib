package pt.brunojesus.report.guestlist.model;


import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import pt.brunojesus.report.common.ReportData;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuestReportData implements ReportData {
    protected String eventName;
    protected Date eventDate;
    protected String address;
    protected List<Guest> guests;
    protected URL logo;
    protected final URL template;

    public GuestReportData() {
        ClassLoader classLoader = getClass().getClassLoader();
        this.logo = classLoader.getResource("logo.png");
        this.template = classLoader.getResource("guest_list.jrxml");
    }

    public String getEventName() {
        return eventName;
    }

    public GuestReportData setEventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public GuestReportData setEventDate(Date eventDate) {
        this.eventDate = eventDate;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public GuestReportData setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public GuestReportData setGuests(List<Guest> guests) {
        this.guests = guests;
        return this;
    }

    public URL getLogo() {
        return logo;
    }

    public GuestReportData setLogo(URL logo) {
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
        parameters.put("eventName", getEventName());
        parameters.put("eventDate", getEventDate());
        parameters.put("address", getAddress());
        parameters.put("guests", new JRBeanCollectionDataSource(getGuests()));
        parameters.put("logo", getLogo());

        return parameters;
    }
}
