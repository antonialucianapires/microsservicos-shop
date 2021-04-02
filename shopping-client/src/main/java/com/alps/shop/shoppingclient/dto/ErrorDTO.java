package com.alps.shop.shoppingclient.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    private int status;
    private String message;
    private Date timestamp;

}
