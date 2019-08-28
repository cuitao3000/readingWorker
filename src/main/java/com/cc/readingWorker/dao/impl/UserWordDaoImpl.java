package com.cc.readingWorker.dao.impl;

import com.cc.readingWorker.dao.UserWordDao;
import com.cc.readingWorker.pojo.UserWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserWordDaoImpl implements UserWordDao {

    @Autowired
    @Qualifier("readingJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    private RowMapper<UserWord> rowMapper;

    public UserWordDaoImpl() {
        this.rowMapper = new BeanPropertyRowMapper<>(UserWord.class);
    }

    @Override
    public List<UserWord> findByUserId(Integer userId) {
        String sql = "select id,user_id,word from user_word where id = ?";
        List<UserWord> query = jdbcTemplate.query(sql , ps -> ps.setInt(1,userId), rowMapper);

        return query;
    }
}
