package task10;

import java.math.BigDecimal;

public class Parcela {
    private BigDecimal valorParcela;
    private BigDecimal valorSaldoDevedor;
    private BigDecimal valorJuros;
    private BigDecimal valorAmortizacao;

    public BigDecimal getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(BigDecimal valorParcela) {
        this.valorParcela = valorParcela;
    }

    public BigDecimal getValorSaldoDevedor() {
        return valorSaldoDevedor;
    }

    public void setValorSaldoDevedor(BigDecimal valorSaldoDevedor) {
        this.valorSaldoDevedor = valorSaldoDevedor;
    }

    public BigDecimal getValorJuros() {
        return valorJuros;
    }

    public void setValorJuros(BigDecimal valorJuros) {
        this.valorJuros = valorJuros;
    }

    public BigDecimal getValorAmortizacao() {
        return valorAmortizacao;
    }

    public void setValorAmortizacao(BigDecimal valorAmortizacao) {
        this.valorAmortizacao = valorAmortizacao;
    }
}