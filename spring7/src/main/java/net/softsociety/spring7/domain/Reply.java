package net.softsociety.spring7.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@ToString
public class Reply {
    private int replyseq;
    private int boardseq;
    private String memberid;
    private String replytext;
    private String regdate;



}
