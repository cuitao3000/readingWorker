package com.cc.readingWorker.dao;

import com.cc.readingWorker.pojo.UserWord;

import java.util.List;

public interface UserWordDao {

    List<UserWord> findByUserId(Integer userId);

}
