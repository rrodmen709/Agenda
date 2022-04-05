/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaGit;

import java.util.Comparator;

/**
 *
 * @author alumno
 */
public class ContactComparator implements Comparator<Contact>{

    @Override
    public int compare(Contact c, Contact c1) {
        if (c.getCity().compareToIgnoreCase(c1.getCity())==0) {
            int phoneNumber = c.getPhoneNumber() - c1.getPhoneNumber();
            return phoneNumber;
        }else{
            return c.getCity().compareToIgnoreCase(c1.getCity());
        }
    }
    
}
