package pl.kmiecik.M7_jdbc_HOMEWORK;

public class Vehicle {
    private long id;
    private String name;

    public Vehicle(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Vehicle() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
