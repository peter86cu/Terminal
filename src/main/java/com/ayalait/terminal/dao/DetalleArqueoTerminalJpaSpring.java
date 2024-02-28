package com.ayalait.terminal.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ayalait.terminal.modelo.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface DetalleArqueoTerminalJpaSpring extends JpaRepository<ArqueoTerminalDetalle, Integer>{

    @Query(value="DELETE FROM arqueos_detalle WHERE id_arqueo = :id", nativeQuery=true)
    void eliminarDetallePorIdArqueo(@Param("id") int id);


}
