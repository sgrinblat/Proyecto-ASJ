package com.petersen.llegahoy.repositories;

import com.petersen.llegahoy.entidades.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iFormularioRepo extends JpaRepository <Formulario, Long> {


}
