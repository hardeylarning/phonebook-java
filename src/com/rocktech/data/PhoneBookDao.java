package com.rocktech.data;

import com.rocktech.pojo.PhoneBook;
import com.rocktech.service.PhoneService;
import com.rocktech.service.PhoneServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PhoneBookDao {
    static Scanner input = new Scanner(System.in);
    PhoneService phoneService = new PhoneServiceImpl();

    public void chooseOption(){
        int value = 0;
        while (isOption(value)){
            printData("Enter 1 to add new Phone Book\n " +
                    "**** 2 to get a Phone Book\n " +
                    "**** 3 to check the list of Phone Books");
            int action = validateData(input);
            if (action > 0){
                switch (action){
                    case 1:
                        // insert a Phone Book
                        insertPhoneBook();
                        printData("Do you want to continue? \n 1. to continue \n 2. to exit");
                        value = validateData(input);
                        isOption(value);
                        break;

                    case 2:
                        // retrieve a Phone Book
                        getPhoneBook();
                        printData("Do you want to continue? \n 1. to continue \n 2. to exit");
                        value = validateData(input);
                        isOption(value);
                        break;

                    case 3:
                        allPhoneBook();
                        printData("Do you want to continue? \n 1. to continue \n 2. to exit");
                        value = validateData(input);
                        isOption(value);
                        break;

                    default:
                        printData("Incorrect Input");
                }
            }
            else {
                isOption(2);
                printData("Invalid input");
            }
        }
    }

    private boolean isOption(int value) {
        if (value == 2){
            System.exit(0);
            return false;
        }
        return true;
    }

    private void getPhoneBook() {
        String email;
        printData("Enter Email to retrieve existing Phone Book: ");
        email = input.next();
        PhoneBook existingPhoneBook;
        if (phoneService.getPhoneBook(email).isPresent()){
            existingPhoneBook = phoneService.getPhoneBook(email).get();
            printData(existingPhoneBook.toString());
            return;
        }
        printData("Incorrect email supplied!");
    }

    private void insertPhoneBook() {
        String name, email;
        printData("Name: ");
        name = input.next();
        //
        printData("Email: ");
        email = input.next();
        //
        LocalDate date = LocalDate.now();
        //
        PhoneBook newPhoneBook = new PhoneBook(name, email, date);
        // getting the return message to insertData
        String insertData = phoneService.insertPhoneBook(newPhoneBook);
        printData(insertData);
    }

    private void allPhoneBook(){
        List<PhoneBook> phoneBooks = phoneService.phoneBooks();
        for (PhoneBook phoneBook: phoneBooks) {
            printData(phoneBook.toString());
        }
    }

    private static int validateData(Scanner in){
        if (in.hasNextInt()){
            return in.nextInt();
        }
        return 0;
    }

    private static void printData(String data){
        System.out.println(data);
    }

}
