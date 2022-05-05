package hr.tvz.crnkovic.hardwareapp;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hardware")
public class Hardware {

    public Hardware() {

    }

    protected enum HardwareType {
        CPU, GPU, MBO, RAM, STORAGE, OTHER
    }

    @Id
    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private Double price;

    @Column(name="type")
    private HardwareType type;

    @Column(name="amount")
    private Integer amount;

    public Hardware(String name, String code, Double price, Integer amount, HardwareType type) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
        this.amount= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hardware)) return false;
        Hardware hardware = (Hardware) o;
        return getCode().equals(hardware.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    public HardwareDTO DTO(){
        return new HardwareDTO(this.name, this.price, this.code);
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
