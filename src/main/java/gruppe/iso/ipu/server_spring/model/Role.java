package gruppe.iso.ipu.server_spring.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Role {
    @Id
    @GeneratedValue
    private Long id;

    public Role() {
    }

    private String name;
    private String code;

    public Role(String name, String code) {
        this.name = name;
        this.code = code;
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
}
