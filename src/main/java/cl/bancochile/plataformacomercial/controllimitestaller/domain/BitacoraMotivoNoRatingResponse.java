package cl.bancochile.plataformacomercial.controllimitestaller.domain;

import cl.bancochile.plataformacomercial.lib.controllimites.common.domain.Bitacora;

public class BitacoraMotivoNoRatingResponse extends Bitacora {

    private BitacoraMotivoNoRatingObject data;

    public BitacoraMotivoNoRatingObject getData() {
        return data;
    }

    public void setData(BitacoraMotivoNoRatingObject data) {
        this.data = data;
    }
}
