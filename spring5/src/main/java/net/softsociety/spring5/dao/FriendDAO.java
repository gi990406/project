package net.softsociety.spring5.dao;

import net.softsociety.spring5.domain.Friend;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FriendDAO {
    public int insertFriend(Friend friend);
    public int updateFriend(Friend friend);
    public List<Friend> allFriend();

    List<Friend> selectAll();
}
