package com.rocktech.service;

import com.rocktech.pojo.PhoneBook;

import java.util.List;
import java.util.Optional;

public interface PhoneService {

    String insertPhoneBook (PhoneBook phoneBook);

    List<PhoneBook> phoneBooks();

    Optional<PhoneBook> getPhoneBook(String phoneNumber);
}
