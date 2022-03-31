package hr.tvz.crnkovic.hardwareapp;

public class Hardware {
    protected enum HardwareType {
        CPU, GPU, MBO, RAM, STORAGE, OTHER
    }

    private String name;
    private String code;
    private Double price;
    private HardwareType type;
    private static Integer amount;

    public Hardware(String name, String code, Double price, HardwareType type) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
    }

    public Integer getAmount(){
        return this.amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public HardwareType getType() {
        return type;
    }

    public void setType(HardwareType hardwareType) {
        this.type = hardwareType;
    }

    public void setAmount(Integer amount){
        this.amount=amount;
    }
}
