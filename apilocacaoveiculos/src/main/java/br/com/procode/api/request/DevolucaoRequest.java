package br.com.procode.api.request;

import java.time.LocalDate;

public class DevolucaoRequest {
    private LocalDate dataDevolucaoReal;

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }
}
