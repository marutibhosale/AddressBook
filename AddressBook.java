import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;


public class AddressBook {

    private static Scanner in = new Scanner(System.in);
    static List<Person> people = new ArrayList<>();


    private static void showMainMenu() {
        System.out.println("1. Add person");
        System.out.println("2. Find person");
        System.out.println("3. Show all contacts");
        System.out.println("4. Show all contacts sort by name");
        System.out.println("5. Show all contacts sort by surname");
        System.out.println("6. Show all contacts sort by email");
        System.out.println("7. Exit");

        String choice;

        choice = in.nextLine();
        switch (choice) {
            case "1":
                addPerson();
                showMainMenu();
            case "2":
                findPerson();
                showMainMenu();
            case "3":
                System.out.println(people);
                System.out.println();
                showMainMenu();
            case "4":
                 System.out.println(".....Before sorting.....");
                 System.out.println(people);
                 Collections.sort(people, new Comparator<Person>(){
                     @Override
                     public int compare(Person o1, Person o2){
                               return o1.getName().compareTo(o2.getName());

                     }
                 });
                 System.out.println(".....After sorting.....");
                 System.out.println(people);
                 System.out.println();
                 showMainMenu();

            case "5":
                 System.out.println(".....Before sorting.....");
                 System.out.println(people);
                 Collections.sort(people, new Comparator<Person>(){
                     @Override
                     public int compare(Person o1, Person o2){
                            return o1.getSurname().compareTo(o2.getSurname());
                          }
                 });
                 System.out.println(".....After sorting.....");
                 System.out.println(people);
                 System.out.println();
                 showMainMenu();
            case "6":
                 System.out.println(".....Before sorting.....");
                 System.out.println(people);
                 Collections.sort(people, new Comparator<Person>(){
                     @Override
                     public int compare(Person o1, Person o2){
                            return o1.getEmail().compareTo(o2.getEmail());
                          }
                 });
                 System.out.println(".....After sorting.....");
                 System.out.println(people);
                 System.out.println();
                 showMainMenu();


            case "7":
                System.exit(0);
            default:
                System.out.println("Enter numer from 1 to 7");
                showMainMenu();
        }
    }

     private static void addPerson(){
        System.out.println("Enter name: ");
        String name = in.nextLine();
        System.out.println("Enter surname: ");
        String surname = in.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = in.nextLine();
        System.out.println("Enter email: ");
        String email = in.nextLine();
        System.out.println("Enter addres: ");
        String address = in.nextLine();

        Person person = new Person(name, surname, phoneNumber, email, address);
        people.add(person);
        System.out.println("Added person detail: " + person);
        System.out.println();
    }

     private static void findPerson(){
        // looking for a person using either name or surname
        System.out.println("1. Find with name");
        System.out.println("2. Find with surname");
        System.out.println("3. Find with phone number");
        System.out.println("4. Find with email");
        System.out.println("5. Main Menu");

        String choice;
        choice = in.nextLine();   //choices to search the person
        switch (choice) {
              case "1":
                  findByName();
                  break;
              case "2":
                  findBySurname();
                  break;
              case "3":
                  findByPhoneNumber();
                  break;
              case "4":
                  findByEmail();
                  break;
              case "5":
                  showMainMenu();
                  break;
              default:
                  System.out.println("Enter numer from 1 to 5");
                  findPerson();
       }
    }

    private static void findByName(){
          System.out.println("Enter name: ");
          String nameToFind = in.nextLine();
          int matches=0;
           for(Person person: people){
               if(person.getName().equals(nameToFind)) {
                   System.out.println(person);
                   matches++;
               }
           }
           if(matches<=0){
               System.out.println("There is no person with this name ");
           }

   }


   private static void findBySurname() {				//finding person based on surname
        System.out.print("Enter surname: ");
        String surnameToFind = in.nextLine();
        int matches = 0;
        for(Person person : people) {
            if(person.getSurname().equals(surnameToFind)) {
                System.out.println(person);
                matches++;
            }
        }
         if(matches<=0) {
            System.out.println("There is no person with this surname");
        }
    }


     private static void findByPhoneNumber() {                                //finding person based on phone number
        System.out.print("Enter phone number: ");
        String phoneToFind = in.nextLine();
        int matches = 0;
        for(Person person : people) {
            if(person.getPhoneNumber().equals(phoneToFind)) {
                System.out.println(person);
                matches++;
            }
        }
         if(matches<=0) {
            System.out.println("There is no person with this phone number");
        }
    }


    private static void findByEmail() {                                //finding person based on email
        System.out.print("Enter email id: ");
        String emailToFind = in.nextLine();
        int matches = 0;
        for(Person person : people) {
            if(person.getEmail().equals(emailToFind)) {
                System.out.println(person);
                matches++;
            }
        }
         if(matches<=0) {
            System.out.println("There is no person with this email id");
        }
    }



    public static void main(String[] args) {
     AddressBook addressBook = new AddressBook();
		addressBook.showMainMenu();


  }

}
