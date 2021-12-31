package com.rocktech.service;

import com.rocktech.pojo.PhoneBook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PhoneServiceImpl implements PhoneService{

    List<PhoneBook> phoneBookList;

    public PhoneServiceImpl() {
        this.phoneBookList = new ArrayList<>();
        initiatePhoneBook();
    }



    @Override
    public String insertPhoneBook(PhoneBook phoneBook) {
        PhoneBook existingPhoneBook = phoneBookList.stream()
                .filter(pb -> phoneBook.getEmail().equals(pb.getEmail()))
                .findAny()
                .orElse(null);

        if (existingPhoneBook == null){
            phoneBookList.add(phoneBook);
            return "Phone Book is successfully added";
        }
        return "Email is already exists";

    }

    @Override
    public List<PhoneBook> phoneBooks() {
        return phoneBookList;
    }

    @Override
    public Optional<PhoneBook> getPhoneBook(String phoneNumber) {
        for (PhoneBook phoneBook: phoneBookList)
            if (phoneNumber.equalsIgnoreCase(phoneBook.getEmail()))
                return Optional.of(phoneBook);
        return Optional.empty();
    }

    void initiatePhoneBook(){
        phoneBookList.add(new PhoneBook("Roqeeb", "hardeylarning@gmail.com", LocalDate.now()));
        phoneBookList.add(new PhoneBook("Adelani", "adelani@gmail.com", LocalDate.now()));
        phoneBookList.add(new PhoneBook("Roqade", "roqade@gmail.com", LocalDate.now()));
    }
}
