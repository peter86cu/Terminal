package com.ayalait.terminal.vo;

import com.ayalait.terminal.modelo.AperturasTerminal;

import java.util.List;

public class ResponseApertura {

    private String mensaje;
    private List<String> fechas;

    private List<AperturasTerminal> lstAperturas;

    public List<AperturasTerminal> getLstAperturas() {
        return lstAperturas;
    }

    public void setLstAperturas(List<AperturasTerminal> lstAperturas) {
        this.lstAperturas = lstAperturas;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<String> getFechas() {
        return fechas;
    }

    public void setFechas(List<String> fechas) {
        this.fechas = fechas;
    }
}
