package task10;

import java.math.BigDecimal;
import java.math.MathContext;

public class TabelaPrice {

    private Parcela[] parcelasEmprestimo;
    private BigDecimal valorEmprestimo;
    private BigDecimal taxaJuros;
    private int quantMeses;
    private BigDecimal valorParcela;
    private static BigDecimal CEM = new BigDecimal(100);

    public TabelaPrice(BigDecimal valorEmprestimo, BigDecimal taxaJuros, int quantMeses) {
        this.valorEmprestimo = valorEmprestimo;
        this.taxaJuros = taxaJuros;
        this.quantMeses = quantMeses;
    }

    private void  calculaValorParcela() {
        BigDecimal taxaJurosConvertida = this.taxaJuros.divide(CEM);
        BigDecimal valor1 = (BigDecimal.ONE.add(taxaJurosConvertida)).pow(this.quantMeses);
        this.valorParcela = this.valorEmprestimo.multiply((valor1.multiply(taxaJurosConvertida)).divide((valor1.subtract(BigDecimal.ONE)), MathContext.DECIMAL128));
    }

    private BigDecimal calculaJurosParcela(BigDecimal saldoDevedor) {
        BigDecimal taxaJurosConvertida = this.taxaJuros.divide(CEM);
        return saldoDevedor.multiply(taxaJurosConvertida);
    }

    private BigDecimal calculaAmortizacao(Parcela parc) {
        return parc.getValorParcela().subtract(parc.getValorJuros());
    }

    public void calculaTabelaPrice() {
        BigDecimal saldoDevedor = this.valorEmprestimo;
        calculaValorParcela();
        for (int i = 0; i < this.quantMeses; i++) {
            Parcela parc = new Parcela() ;
            parc.setValorParcela(this.valorParcela);
            parc.setValorJuros(calculaJurosParcela(saldoDevedor));
            parc.setValorAmortizacao(calculaAmortizacao(parc));
            saldoDevedor = saldoDevedor.subtract(parc.getValorAmortizacao());
            parc.setValorSaldoDevedor(saldoDevedor.abs());
            this.parcelasEmprestimo[i] = parc;
        }
    }

    public void imprimeTabelaPrice() {
        if (this.parcelasEmprestimo != null && this.parcelasEmprestimo.length > 0) {
            BigDecimal valorPrestacao = this.valorParcela.multiply(new BigDecimal(this.quantMeses));
            BigDecimal somatorioJuros = BigDecimal.ZERO;
            BigDecimal somatorioAmortizacao = BigDecimal.ZERO;
            System.out.printf("\nValor fixo da parcela R$ %.2f, Saldo devedor total R$ %.2f\n\n", this.valorParcela, this.valorEmprestimo);
            for (int i = 1; i <= this.parcelasEmprestimo.length; i++) {
                Parcela parc = this.parcelasEmprestimo[i-1];
                somatorioJuros = somatorioJuros.add(parc.getValorJuros());
                somatorioAmortizacao = somatorioAmortizacao.add(parc.getValorAmortizacao());
                System.out.printf("Parcela %d | Juros: R$ %.2f | Amortização: R$ %.2f | Saldo devedor: R$ %.2f\n", i, parc.getValorJuros(), parc.getValorAmortizacao(), parc.getValorSaldoDevedor());
            }
            System.out.printf("\nTotal: Prestação R$ %.2f, Juros R$ %.2f, Amortização R$ %.2f\n", valorPrestacao, somatorioJuros, somatorioAmortizacao);
        }
    }

    public Parcela[] getParcelasEmprestimo() {
        return parcelasEmprestimo;
    }

    public void setParcelasEmprestimo(Parcela[] parcelasEmprestimo) {
        this.parcelasEmprestimo = parcelasEmprestimo;
    }
}