package domain.models;

import domain.enums.ClientType;

import java.util.Objects;

public class Client {

    private String Identifier;
    private String fullName;
    private String email;
    private ClientType type;
    private String contact;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return getIdentifier().equals(client.getIdentifier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdentifier());
    }

    public Client(String identifier, String fullName, String email, ClientType type, String contact) {
        Identifier = identifier;
        this.fullName = fullName;
        this.email = email;
        this.type = type;
        this.contact = contact;
    }

    public Client(){

    }

    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String identifier) {
        Identifier = identifier;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
