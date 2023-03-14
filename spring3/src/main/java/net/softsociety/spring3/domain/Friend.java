package net.softsociety.spring3.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@ToString
public class Friend {
    private String name;
    private int age;
    private String phone;
    private boolean active;
}
