package pl.kmiecik.M7_jdbc_HOMEWORK;

public class Vehicle {
    private long id;
    private String mark;
    private String model;
    private int productionDate;

    public Vehicle(long id, String mark, String model, int productionDate) {
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

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(int productionDate) {
        this.productionDate = productionDate;
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
