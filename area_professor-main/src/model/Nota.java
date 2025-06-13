package model;

public class Nota extends RegistroAcademico {
    private double valor;

    public Nota(String alunoMatricula, String descricao, double valor) {
        super(alunoMatricula, descricao);
        this.valor = valor;
    }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    @Override
    public String exibir() {
        return "Nota - " + alunoMatricula + ": " + descricao + " - " + valor;
    }
}