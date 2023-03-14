package net.softsociety.spring5.service;

import net.softsociety.spring5.dao.FriendDAO;
import net.softsociety.spring5.domain.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {
    @Autowired
    FriendDAO dao;
    public int insertFriend(Friend friend) {

        int result = dao.insertFriend(friend);
        System.out.println(result + "명의 정보가 저장");

        return result;
    }

    public List<Friend> selectAll() {
        List<Friend> list = dao.selectAll();
        System.out.println(list);
        return list;
    }
}
