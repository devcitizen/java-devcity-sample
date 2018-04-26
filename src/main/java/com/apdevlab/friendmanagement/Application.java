package com.apdevlab.friendmanagement;

import com.apdevlab.friendmanagement.model.Account;
import com.apdevlab.friendmanagement.model.Bookmark;
import com.apdevlab.friendmanagement.repository.AccountRepository;
import com.apdevlab.friendmanagement.repository.BookmarkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository) {
        return (evt) -> Arrays.asList("holmes,poirot,kudo,hattori,kindaichi".split(","))
                .forEach(a -> {
                    Account account = accountRepository.save(new Account(a, "P@ssw0rd"));
                    bookmarkRepository.save(new Bookmark(account, "http://example.com/1/" + a, "A description"));
                    bookmarkRepository.save(new Bookmark(account, "http://example.com/2/" + a, "A description"));
                });
    }
}
