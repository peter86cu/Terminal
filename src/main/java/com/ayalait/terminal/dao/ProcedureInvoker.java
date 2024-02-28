package com.ayalait.terminal.dao;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProcedureInvoker {

	private final EntityManager entityManager;

    @Autowired
    public ProcedureInvoker(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void ejecutarUno() {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("actualizarTransaccionTarjetaVenta");
     // Registrar los parámetros de entrada y salida
        storedProcedureQuery.registerStoredProcedureParameter("idVenta", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("id_transaccion", String.class, ParameterMode.IN);
       // storedProcedureQuery.registerStoredProcedureParameter("OUTPUT_PROCEDURE_PARAMETER_NAME2", Long.class, ParameterMode.OUT);

        // Configuramos el valor de entrada
        storedProcedureQuery.setParameter("INPUT_PROCEDURE_PARAMETER_NAME", "value");

        // Realizamos la llamada al procedimiento
        storedProcedureQuery.execute();

    }

}
