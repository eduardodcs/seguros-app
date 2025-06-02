package com.bank.seguros.core.vida.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.bank.common_web.exceptions.BusinessException;
import com.bank.seguros.core.ICobertura;
import com.bank.seguros.core.SeguroAbstract;
import com.bank.seguros.core.vida.SeguroVidaCoberturas;

public abstract class SeguroVidaAbstract extends SeguroAbstract {

    private UUID idSimulacao;
    private LocalDateTime dataHoraSimulacao;

    protected SeguroVidaAbstract(Builder<?, ?> builder) {
        super(builder);
        this.idSimulacao = obterIdSimulacao(builder);
        this.dataHoraSimulacao = obterDataHoraSimulacao(builder);
        SeguroVidaCoberturas.atribuirCoberturas(super.tipoPlano, super.coberturas);
        super.valorPremioMensal = calcularValorMensalPremio().doubleValue();
    }

    private LocalDateTime obterDataHoraSimulacao(Builder<?, ?> builder) {
        return builder.dataHoraSimulacao != null ? builder.dataHoraSimulacao : LocalDateTime.now();
    }

    private UUID obterIdSimulacao(Builder<?, ?> builder) {
        return builder.idSimulacao != null ? builder.idSimulacao : UUID.randomUUID();
    }

    public abstract static class Builder<T extends SeguroVidaAbstract, B extends Builder<T, B>>
            extends SeguroAbstract.Builder<T, B> {
        private UUID idSimulacao;
        private LocalDateTime dataHoraSimulacao;

        public B idSimulacao(UUID idSimulacao) {
            this.idSimulacao = idSimulacao;
            return self();
        }

        public B dataHoraSimulacao(LocalDateTime dataHoraSimulacao) {
            this.dataHoraSimulacao = dataHoraSimulacao;
            return self();
        }

    }

    public UUID getIdSimulacao() {
        return idSimulacao;
    }    
    
    public LocalDateTime getDataHoraSimulacao() {
        return dataHoraSimulacao;
    }

    @Override
    protected void adicionarCoberturaPlano(ICobertura cobertura) {
        if (cobertura instanceof ICoberturaVida) {
            super.coberturas.add(cobertura);
        } else {
            throw new BusinessException("Cobertura inválida para Seguro de Vida");
        }
    } 

    @Override
    public BigDecimal calcularValorMensalPremio() {
        return coberturas.stream()
                .map(c -> c.getValorPremio())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
