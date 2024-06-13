package ua.thecoon.lawsys.model.dto;

import lombok.Data;

@Data
public class ClientItemDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNum;
}
