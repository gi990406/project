package net.softsociety.spring4.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class Member {
    private String usrid;
    private String usrpwd;
    private String usrname;
    private String gender;
    private String birthyear;
    private String hobby;
    private String introduce;
}
