package ua.thecoon.lawsys.model.dto;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ClientItemDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNum;
}
