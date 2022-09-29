package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin{
    //... imports class definition...

    // Inside class:

    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<>();

    AdminUser(Integer id, String role) {
        super(id);
        this.role = role;
    }


    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!

    public void newIncident(String notes) {
        String report = String.format(
                "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
                new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
                "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
                new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return securityIncidents;
    }

    @Override
    public boolean assignPin(int pin) {

        return String.valueOf(pin).length() == 6;
    }


    public boolean accessAuthorized(Integer confirmedAuthID) {
        authIncident();
        return Objects.equals(confirmedAuthID, this.id);
    }

    // TO DO: Setters & Getters

}

