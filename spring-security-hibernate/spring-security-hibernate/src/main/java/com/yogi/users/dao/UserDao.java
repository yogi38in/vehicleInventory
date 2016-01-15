package com.yogi.users.dao;

import com.yogi.users.model.User;

public interface UserDao {

	User findByUserName(String username);

}