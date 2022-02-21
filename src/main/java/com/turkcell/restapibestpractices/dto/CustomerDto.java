package com.turkcell.restapibestpractices.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private long id;
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty(value = "birth-date")
    private LocalDate birthDate;
    private CityDto city;
    private String email;

}
