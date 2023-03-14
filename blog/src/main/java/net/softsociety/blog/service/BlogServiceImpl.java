package net.softsociety.blog.service;

import net.softsociety.blog.dao.BlogDAO;
import net.softsociety.blog.domain.Blog;
import net.softsociety.blog.util.PageNavigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogDAO blogDAO;
    @Override
    public int write(Blog blog) {
        int result = blogDAO.insertBlog(blog);
        return result;
    }

    @Override
    public Blog read(int blogseq) {
        return null;
    }

    @Override
    public List<Blog> list(PageNavigator navi, String searchItem, String searchWord) {
        Map<String, Object> map = new HashMap<>();

        map.put("srow", navi.getStartRecord());
        map.put("erow", navi.getEndRecord());
        map.put("searchItem", searchItem);
        map.put("searchWord", searchWord);

        System.out.println("srow: " + navi.getStartRecord());
        System.out.println("erow: " + navi.getEndRecord());
        System.out.println("searchItem: " + searchItem);
        System.out.println("searchWord: " + searchWord);

        List<Blog> list = blogDAO.selectBlogList(map);

        return list;
    }

    @Override
    public int getBlogCount(String searchItem, String searchWord) {
        Map<String, Object> map = new HashMap<>();

        map.put("searchItem", searchItem);
        map.put("searchWord", searchWord);

        int total = blogDAO.getBlogCount(map);
        return total;
    }

    @Override
    public int delete(int blogseq) {
        return 0;
    }

    @Override
    public int update(Blog blog) {
        return 0;
    }

    @Override
    public int updateLikecnt(int blogseq) {
        return 0;
    }
}
