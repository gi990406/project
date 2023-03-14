package net.softsociety.spring6.dao;

import net.softsociety.spring6.domain.Guestbook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GuestbookDAO {
    public int insertGuestbook(Guestbook guestbook);
    public List<Guestbook> selectAll();
    public int updateGuestbook(Guestbook guestbook);
    public int deleteGuestbook(int seq);
    public Guestbook selectOne(int seq);
}
