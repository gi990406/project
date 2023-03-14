package net.softsociety.spring7.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@ToString
public class Iris {
    private double petalLength;
    private double petalWidth;
    private double sepalLength;
    private double sepalWidth;
}
