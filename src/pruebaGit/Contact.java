/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaGit;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author alumno
 */
public class Contact implements Serializable,Comparable{
    private String name;
    private String surName;
    private String address;
    private String city;
    private int phoneNumber;

    public Contact() {
    }

    public Contact(String name, String surName, String address, String city, int phoneNumber) {
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        if (this.phoneNumber != other.phoneNumber) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Contact{" + "name=" + name + ", surName=" + surName + ", address=" + address + ", city=" + city + ", phoneNumber=" + phoneNumber + '}';
    }

    @Override
    public int compareTo(Object t) {
       Contact ct = (Contact) t;
        if (this.surName.compareToIgnoreCase(ct.getSurName())==0) {
            return this.name.compareToIgnoreCase(ct.getSurName());
        }else{
            return this.surName.compareToIgnoreCase(ct.getSurName());
        }
    }
    
}
