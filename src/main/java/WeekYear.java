package main.java;

public class WeekYear {

    private int year;
    private String week;

    public WeekYear() {
    }

    public WeekYear(int year, String week) {
        super();
        this.year = year;
        this.week = week;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((week == null) ? 0 : week.hashCode());
        result = prime * result + year;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WeekYear other = (WeekYear) obj;
        if (week == null) {
            if (other.week != null)
                return false;
        } else if (!week.equals(other.week))
            return false;
        if (year != other.year)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "WeekYear [year=" + year + ", week=" + week + "]";
    }
}
