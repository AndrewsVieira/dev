public class TrianguloRetangulo {
    private double lado1;
    private double lado2;
    private double hipotenusa;

    public TrianguloRetangulo(double lado1, double lado2, double hipotenusa) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.hipotenusa = hipotenusa;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public void setHipotenusa(double hipotenusa) {
        this.hipotenusa = hipotenusa;
    }

    public double getLado1() {
        return this.lado1;
    }

    public double getLado2() {
        return this.lado2;
    }

    public double getHipotenusa() {
        return this.hipotenusa;
    }

    public boolean verificarTrianguloRetangulo() {
        boolean valido = Math.pow(this.hipotenusa, 2) == (Math.pow(this.lado1, 2) + Math.pow(this.lado2, 2));

        if (!valido) {
            valido = false;
        }

        return valido;
    }
}