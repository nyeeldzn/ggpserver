package com.sunonrails.ggpserver.model;

public enum PedidoStatus {
    PENDENTE(1, "Aguardando Listagem"),
    TRIAGEM(2, "Em coleta"),
    CHECKOUT(3, "Checkout Finalizado"),
    SAIU_PARA_ENTREGA(4, "Saiu para Entrega"),
    FINALIZADO(5, "Finalizado");

    private int cod;
    private String desc;

    PedidoStatus(int cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public int getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static PedidoStatus toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (PedidoStatus x : PedidoStatus.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}
