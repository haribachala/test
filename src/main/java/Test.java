package main.java;

public class Test {
    public static void main(String[] args) {
        WeekYear weekYear_1=new WeekYear();
        weekYear_1.setWeek(null);
        weekYear_1.setYear(0);
        WeekYear weekYear_2=new WeekYear();
        weekYear_1.setWeek("35");
        weekYear_1.setYear(2017);
        System.out.println(!weekYear_1.equals(weekYear_2));

    }
}
