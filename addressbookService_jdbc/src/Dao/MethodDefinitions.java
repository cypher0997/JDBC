package Dao;

import java.util.Scanner;

public  class MethodDefinitions {
    String fname;
    String lname;
    String address;
    String city;
    String state;
    String email;
    int zip;
    int phone_number;
    String addressbook_name;
    String addressbook_type;

    public void setAttributes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter first name");
        fname = sc.nextLine();
        System.out.println("enter last name");
        lname = sc.nextLine();
        System.out.println("enter address");
        address = sc.nextLine();
        System.out.println("enter city");
        city = sc.nextLine();
        System.out.println("enter state");
        state = sc.nextLine();
        System.out.println("enter email");
        email = sc.nextLine();
        System.out.println("enter phone number");
        phone_number = sc.nextInt();
        System.out.println("enter zip");
        zip = sc.nextInt();
        
    }
    public String getFname() {
        return fname;
    }
    
    public String getLname() {
        return lname;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getCity() {
        return city;
    }
   
    public String getState() {
        return state;
    }
    public String getEmail() {
        return email;
    }
    public int getZip() {
        return zip;
    }
   
    public int getPhone_number() {
        return phone_number;
    }
    public String getAddressbook_name() {
        return addressbook_name;
    }
    public void setAddressbook_name() {
        System.out.println("enter addressbook name for this person");
        Scanner sc = new Scanner(System.in);
        addressbook_name = sc.nextLine();
        
    }
    public String getAddressbook_type() {
        return addressbook_type;
    }
    public void setAddressbook_type() {
        System.out.println("enter addressbook type for this person");
        Scanner sc = new Scanner(System.in);
        addressbook_type = sc.nextLine();
    }
    
     
}
