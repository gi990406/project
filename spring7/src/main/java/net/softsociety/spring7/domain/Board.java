package net.softsociety.spring7.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter     @Getter
@ToString
public class Board {
    private int boardseq;
    private String memberid;
    private String title;
    private String boardtext;
    private String regdate;
    private int hitcount;
    private String originalfile;
    private String savedfile;
}
