/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaGit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class AgendaMain {

    private static ObjectInputStream input;
    private static ObjectOutputStream output;

    public static void main(String[] args) {
        ArrayList<Contact> Contacts = new ArrayList();
        Contact c;
        Scanner sc = new Scanner(System.in);
        Scanner scc = new Scanner(System.in);
        int option, phoneNumber, index, option1, option2;
        String name, surName, address, city;
        File preAgenda = new File("agenda.ser");
        if (preAgenda.exists()) {
            try {
                input = new ObjectInputStream(new FileInputStream("agenda.ser"));
                while ((c = (Contact) input.readObject()) != null) {
                    Contacts.add(c);
                }
            } catch (IOException ex) {
                try {
                    input.close();
                } catch (IOException ex1) {
                    System.out.println("error");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AgendaMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        do {
            System.out.println("*****MENU*****");
            System.out.println("1.-Insert a new contact into the Agenda");
            System.out.println("2.-Search a contact in the Agenda");
            System.out.println("3.-Edit a contact of the Agenda");
            System.out.println("4.-Remove a contact of the Agenda");
            System.out.println("5.-Sort the Agenda by different fields");
            System.out.println("6.-Exit");
            System.out.println("Introduce an option");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Type the name of the contact");
                    name = scc.nextLine();
                    System.out.println("Type the surname of the contact");
                    surName = scc.nextLine();
                    System.out.println("Type the address of the contact");
                    address = scc.nextLine();
                    System.out.println("Type the city of the contact");
                    city = scc.nextLine();
                    System.out.println("Type the phone number of the contact");
                    phoneNumber = sc.nextInt();
                    if (Contacts.contains(new Contact(name, phoneNumber))) {
                        System.out.println("The contact alredy exists");
                    } else {
                        Contacts.add(new Contact(name, surName, address, city, phoneNumber));
                        System.out.println("The contact has been added");
                    }
                    break;
                case 2:
                    System.out.println("The list of contact are: ");
                    for (int i = 0; i < Contacts.size(); i++) {
                        System.out.println(i + 1 + " " + Contacts.get(i).getSurName() + " , " + Contacts.get(i).getName());
                    }
                    do {
                        System.out.println("What contact do you want to search?");
                        index = sc.nextInt();
                    } while (index < 1 || index > Contacts.size());
                    System.out.println(Contacts.get(index - 1));
                    break;
                case 3:
                    System.out.println("The list of contact are: ");
                    for (int i = 0; i < Contacts.size(); i++) {
                        System.out.println(i + 1 + " " + Contacts.get(i).getName() + " , " + Contacts.get(i).getSurName());
                    }
                    do {
                        System.out.println("What contact do you want to edit?");
                        index = sc.nextInt();
                    } while (index < 1 || index > Contacts.size());
                    do {
                        System.out.println("What option do you want to edit?");
                        System.out.println("1.-Name");
                        System.out.println("2.-Surname");
                        System.out.println("3.-Address");
                        System.out.println("4.-City");
                        System.out.println("5.-Phone number");
                        System.out.println("6.-Exit");
                        System.out.println("Introduce an option");
                        option1 = sc.nextInt();
                        switch (option1) {
                            case 1:
                                System.out.println("Type the new name");
                                name = scc.nextLine();
                                Contacts.get(index - 1).setName(name);
                                System.out.println("The contact has been changed");

                                break;
                            case 2:
                                System.out.println("Type the new surname");
                                surName = scc.nextLine();
                                Contacts.get(index - 1).setName(surName);
                                System.out.println("The contact has been changed");
                                break;
                            case 3:
                                System.out.println("Type the new address");
                                address = scc.nextLine();
                                Contacts.get(index - 1).setAddress(address);
                                System.out.println("The contact has been changed");
                                break;
                            case 4:
                                System.out.println("Type the new city");
                                city = scc.nextLine();
                                Contacts.get(index - 1).setCity(city);
                                System.out.println("The contact has been changed");
                                break;
                            case 5:
                                System.out.println("Type the new phone number");
                                phoneNumber = sc.nextInt();
                                Contacts.get(index - 1).setPhoneNumber(phoneNumber);
                                System.out.println("The contact has been changed");
                                break;
                        }
                    } while (!(option1 < 1 || option1 > 5));
                    break;
                case 4:
                    System.out.println("The list of contact are: ");
                    for (int i = 0; i < Contacts.size(); i++) {
                        System.out.println(i + 1 + " " + Contacts.get(i).getName() + " , " + Contacts.get(i).getSurName());
                    }
                    do {
                        System.out.println("What contact do you want to remove?");
                        index = sc.nextInt();
                    } while (index < 1 || index > Contacts.size());
                    System.out.println(Contacts.remove(index - 1));
                case 5:
                    System.out.println("The ways to compare are:");
                    System.out.println("1.-Compare by surnames");
                    System.out.println("2.-Compare by cities");
                    System.out.println("Type the way for sorting the Agenda");
                    option2 = sc.nextInt();
                    switch (option2) {
                        case 1:
                            Collections.sort(Contacts);
                            break;
                        case 2:
                            Collections.sort(Contacts, new ContactComparator());
                            break;
                    }
                    break;
            }

        } while (!(option < 1 || option > 5));
        try {
            output = new ObjectOutputStream(new FileOutputStream("agenda.ser"));
            ArrayList<Contact> agendaC = Contacts;
            for (Contact contact : agendaC) {
                System.out.println(contact);
                output.writeObject(contact);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AgendaMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AgendaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
