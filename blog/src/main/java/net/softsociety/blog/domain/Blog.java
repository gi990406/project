package net.softsociety.blog.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Blog {
    private int blogseq;
    private String blogid;
    private String title;
    private String blogtext;
    private String regdate;
    private int likecnt;
}
