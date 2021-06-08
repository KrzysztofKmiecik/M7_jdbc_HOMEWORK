package pl.kmiecik.M7_jdbc_HOMEWORK.zad1.vehicle.domain;

public class Vehicle {
    private long id;
    private String mark;
    private String model;
    private int productionDate;

    public Vehicle(final long id, final String mark, final String model, final int productionDate) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.productionDate = productionDate;
    }

    public Vehicle() {
    }

    public long getId() {
        return id;
    }


    public String getMark() {
        return mark;
    }


    public String getModel() {
        return model;
    }


    public int getProductionDate() {
        return productionDate;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", productionDate=" + productionDate +
                '}';
    }
}
