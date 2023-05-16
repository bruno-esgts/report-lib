package pt.brunojesus.report.guestlist.model;

public class Guest {

    private String name;
    private String contact;
    private boolean present;

    public Guest() {
    }

    public String getName() {
        return name;
    }

    public Guest setName(String name) {
        this.name = name;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public Guest setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public Boolean getPresent() {
        return present;
    }

    public Guest setPresent(Boolean present) {
        this.present = present;
        return this;
    }
}
