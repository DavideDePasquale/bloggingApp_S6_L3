package com.epicode.bloggingApp_S6_L3.service;

import com.epicode.bloggingApp_S6_L3.DTO.AutoreDTO;
import com.epicode.bloggingApp_S6_L3.model.Autore;
import com.epicode.bloggingApp_S6_L3.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.epicode.bloggingApp_S6_L3.mapper.AutoreMapperDTO.toEntity;

@Service
public class AutoreService {
    @Autowired
    AutoreRepository autoreRepository;


    /**
     * Metodo di inserimento di un nuovo autore
  //   * @param nuovoAutore : oggetto proveniente dal client
     * @return : id generato dal nuovo inserimento
     */
    public Long nuovoAutore(AutoreDTO nuovoAutoreDto){
      Autore autoreInserito =  toEntity(nuovoAutoreDto);
        return autoreRepository.save(autoreInserito).getId();
    }
//    public String ricercaAutoreId(Long id){
//       Optional<Autore> autoreRecuperato = autoreRepository.findById(id);




//         if(autoreRecuperato.isPresent()){
//             return "l'autore è presente nel sistema";
//         } else {
//             return "l'autore non è presente nel sistema";
//         }

//    }
    public Optional<Autore> ricercaAutoreId(Long id){
        Optional<Autore> autoreRecuperato = autoreRepository.findById(id);
        return autoreRecuperato;
    }
}
