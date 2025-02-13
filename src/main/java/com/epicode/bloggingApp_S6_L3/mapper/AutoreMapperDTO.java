package com.epicode.bloggingApp_S6_L3.mapper;


import com.epicode.bloggingApp_S6_L3.DTO.AutoreDTO;
import com.epicode.bloggingApp_S6_L3.model.Autore;
import org.springframework.stereotype.Component;

@Component
public class AutoreMapperDTO {


    public static AutoreDTO toDTO(Autore autore){
        AutoreDTO autoreDto = new AutoreDTO();
        autoreDto.setNome(autore.getNome());
        autoreDto.setCognome(autoreDto.getCognome());
        autoreDto.setEmail(autore.getEmail());
        autoreDto.setDataDiNascita(autore.getDataDiNascita());
        autoreDto.setAvatar(autore.getAvatar());
        return autoreDto;
    }
    public static Autore toEntity(AutoreDTO autoreDto){
        Autore autore = new Autore();
        autore.setNome(autoreDto.getNome());
        autore.setCognome(autoreDto.getCognome());
        autore.setEmail(autoreDto.getEmail());
        autore.setDataDiNascita(autoreDto.getDataDiNascita());
        autore.setAvatar(autoreDto.getAvatar());
        return autore;
    }

}
