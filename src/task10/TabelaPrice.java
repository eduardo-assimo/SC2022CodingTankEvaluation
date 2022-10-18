package task10;

public class TabelaPrice {

    private Parcela[] parcelasEmprestimo;
    private double valorEmprestimo;
    private double taxaJuros;
    private int quantMeses;
    private double valorParcela;

    public TabelaPrice(double valorEmprestimo, double taxaJuros, int quantMeses) {
        this.valorEmprestimo = valorEmprestimo;
        this.taxaJuros = taxaJuros;
        this.quantMeses = quantMeses;
    }

    private void  calculaValorParcela() {
        double taxaJurosConvertida = this.taxaJuros / 100;
        double valor1 = Math.pow((1+ taxaJurosConvertida), this.quantMeses);
        this.valorParcela = this.valorEmprestimo * ((valor1 * taxaJurosConvertida ) / (valor1 - 1));
    }

    private double calculaJurosParcela(Double saldoDevedor) {
        double taxaJurosConvertida = this.taxaJuros / 100;
        return saldoDevedor * taxaJurosConvertida;
    }

    private double calculaAmortizacao(Parcela parc) {
        return parc.getValorParcela()-parc.getValorJuros();
    }

    public void calculaTabelaPrice() {
        double saldoDevedor = this.valorEmprestimo;
        calculaValorParcela();
        for (int i = 0; i < this.quantMeses; i++) {
            Parcela parc = new Parcela() ;
            parc.setValorParcela(this.valorParcela);
            parc.setValorJuros(calculaJurosParcela(saldoDevedor));
            parc.setValorAmortizacao(calculaAmortizacao(parc));
            saldoDevedor = saldoDevedor - parc.getValorAmortizacao();
            parc.setValorSaldoDevedor(Math.abs(saldoDevedor));
            this.parcelasEmprestimo[i] = parc;
        }
    }

    public void imprimeTabelaPrice() {
        if (this.parcelasEmprestimo != null && this.parcelasEmprestimo.length > 0) {
            double valorPrestacao = this.valorParcela*this.quantMeses;
            double somatorioJuros = 0.0;
            double somatorioAmortizacao = 0.0;
            System.out.printf("\nValor fixo da parcela R$ %.2f, Saldo devedor total R$ %.2f\n\n", this.valorParcela, this.valorEmprestimo);
            for (int i = 1; i <= this.parcelasEmprestimo.length; i++) {
                Parcela parc = this.parcelasEmprestimo[i-1];
                somatorioJuros += parc.getValorJuros();
                somatorioAmortizacao += parc.getValorAmortizacao();
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