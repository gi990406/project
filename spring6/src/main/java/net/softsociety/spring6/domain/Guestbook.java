package net.softsociety.spring6.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Guestbook {
    private int seq;
    private String writer;
    private String text;
    private String regdate;
}
