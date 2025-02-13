package com.epicode.bloggingApp_S6_L3.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AutoreDTO {


    @NotBlank(message = "'nome' non può essere dei caratteri vuoti")
    @NotNull(message = "'nome' non può essere vuota")
    private String nome;
    @NotBlank(message = "'cognome' non può essere dei caratteri vuoti")
    @NotNull(message = "'cognome' non può essere vuota")
    private String cognome;
    @NotBlank(message = "'email' non può essere dei caratteri vuoti")
    @NotNull(message = "'email' non può essere vuota")
    private String email;
    @NotNull(message = "'dataDiNascita' non può essere vuota")
    private LocalDate dataDiNascita;
    private String avatar;


}
