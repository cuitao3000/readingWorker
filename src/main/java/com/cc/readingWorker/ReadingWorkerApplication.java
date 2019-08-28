package com.cc.readingWorker;

import com.cc.readingWorker.dao.UserWordDao;
import com.cc.readingWorker.pojo.UserWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ReadingWorkerApplication implements CommandLineRunner{

    @Autowired
    private UserWordDao userWordDao;

    public void run(String ... args) {
        List<UserWord> userWordList = userWordDao.findByUserId(1);

        for (UserWord userWord : userWordList) {
            System.out.println(userWord.toString());
            System.out.println(userWord.getUserId());
        }
        System.out.println("hello");
    }




    public static void main(String[] args) {

        SpringApplication.run(ReadingWorkerApplication.class, args);

	}

}
