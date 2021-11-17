package com.company.bpmr2.providers;

import com.company.bpmr2.entity.User;
import io.jmix.bpm.provider.UserProvider;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

@UserProvider(value = "bpmr2_MyUserProvider")
public class MyUserProvider {
    @Autowired
    private DataManager dataManager;


    public String getUser(String username) {
        return dataManager.load(User.class)
                .query("select u from bpmr2_User  u where u.username like :username")
                .parameter("username", username)
                .one()
                .getUsername();
    }

    public String getUserByEmailLikeAndNameStartingWith(String email, String username) {
        List<User> userList = dataManager.load(User.class)
                .query("select u from bpmr2_User u where u.email like :email and u.username like :username")
                .parameter("email", "%" + email + "%")
                .parameter("username", username + "%")
                .list();
        if (!CollectionUtils.isEmpty(userList)) {
            return userList.get(0).getUsername();
        } else {
            return "";
        }
    }
}