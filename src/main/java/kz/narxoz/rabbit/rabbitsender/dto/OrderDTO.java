package kz.narxoz.rabbit.rabbitsender.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {

    private String restaurant;
    private String courier;
    private List<String> foods;
    private String region;
    private String status;
}
