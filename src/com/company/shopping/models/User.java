package com.company.shopping.models;

/**
 * Created by admin on 13.04.2017.
 */
public class User {
    private Integer id_user;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private int limit;
    private static long serialVersionUID = 1L;

    public User(String fistname, String lastname, String mail, String password, int limit) {
        this.firstName = fistname;
        this.lastName = lastname;
        this.mail = mail;
        this.password = password;
        this.limit = limit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof User))
            return false;

        if (!this.id_user.equals(((User) obj).id_user))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id_user.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", limit=" + limit +
                '}';
    }

    public User getUser(String mail) {
        return new User("Ray", "Charles", "Ray@mail.ru", "asdfasdf", 10000);
    }

    public User getUser(int id) {
        return new User("Ray", "Charles", "Ray@mail.ru", "asdfasdf", 10000);
    }

    public int getId_user() {
        return id_user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
