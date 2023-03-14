package net.softsociety.test3.domain;

import lombok.*;

@NoArgsConstructor // public class Fitness() {}
@AllArgsConstructor
@Setter @Getter
@ToString
public class Fitness {
    private String usrname;
    private String gender;
    private double height;
    private double weight;
    private double bmi;

//    @Override
//    public String toString() {
//        return "Fitness{" +
//                "usrname='" + usrname + '\'' +
//                ", gender='" + gender + '\'' +
//                ", height=" + height +
//                ", weight=" + weight +
//                ", bmi=" + bmi +
//                '}';
//    }
//
//    public String getUsrname() {
//        return usrname;
//    }
//
//    public void setUsrname(String usrname) {
//        this.usrname = usrname;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public double getHeight() {
//        return height;
//    }
//
//    public void setHeight(double height) {
//        this.height = height;
//    }
//
//    public double getWeight() {
//        return weight;
//    }
//
//    public void setWeight(double weight) {
//        this.weight = weight;
//    }
//
//    public double getBmi() {
//        return bmi;
//    }
//
//    public void setBmi(double bmi) {
//        this.bmi = bmi;
//    }
//
//    public Fitness() {
//    }
//
//    public Fitness(String usrname, String gender, double height, double weight, double bmi) {
//        this.usrname = usrname;
//        this.gender = gender;
//        this.height = height;
//        this.weight = weight;
//        this.bmi = bmi;
//    }
}
