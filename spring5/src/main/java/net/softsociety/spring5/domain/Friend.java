package net.softsociety.spring5.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@ToString
public class Friend {
    private String name;
    private int age;
    private String phone;
    private String active;
}
