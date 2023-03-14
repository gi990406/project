package net.softsociety.spring6.service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring6.dao.GuestbookDAO;
import net.softsociety.spring6.domain.Guestbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GuestbookService {
    @Autowired
    GuestbookDAO dao;
    public int insertGuestbook(Guestbook guestbook) {

        int result = dao.insertGuestbook(guestbook);
        return result;
    }

    // selectAll ==> 시퀀스의 역순으로 전체를 조회한다.
    // 쿼리문은
    // select * from guestbook
    // order by seq desc
    public List<Guestbook> selectAll() {
        List<Guestbook> list = dao.selectAll();
        System.out.println(list);
        return list;
    }

    public int delete(int seq){
        int result = dao.deleteGuestbook(seq);

        return result;
    }

    public Guestbook selectOne(int seq) {
        Guestbook guestbook = dao.selectOne(seq);
        log.info("조회된 글 : {}", guestbook.toString());
        return guestbook;
    }

    public int updateGuestbook(Guestbook guestbook) {
        int result = dao.updateGuestbook(guestbook);

        return result;
    }

}
