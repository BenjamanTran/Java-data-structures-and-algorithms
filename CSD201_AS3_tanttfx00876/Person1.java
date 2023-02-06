public class Person1{
    String id;
    String name;
    String birthPlace;
    String dob;
    public Person1() {
    }
    public Person1(String id, String name, String birthPlace, String dob) {
        this.id = id;
        this.name = name;
        this.birthPlace = birthPlace;
        this.dob = dob;
    }
    @Override
    public String toString() {
        
        return String.format("%-10s %-10s %-20s %-10s", id, name, dob, birthPlace);
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    

    
    
}