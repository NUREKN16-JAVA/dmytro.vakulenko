package ua.nure.kn16.vakulenko.usermanagement;

import java.time.LocalDate;


class User {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;


    User(long id, String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    String getFullName() {
        return lastName + ", " + firstName;
    }

    long getAge() {
        LocalDate date = LocalDate.now();
        int age = date.getYear() - dateOfBirth.getYear();
        if (date.getMonthValue() < dateOfBirth.getMonthValue() ||
                (date.getMonthValue() == dateOfBirth.getMonthValue() && date.getDayOfMonth() < dateOfBirth.getDayOfMonth())) {
            --age;
        }

        return age;
    }
}