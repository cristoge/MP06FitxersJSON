import java.io.Serializable;
public class Ordinador implements Serializable{
    //no debe ser serializable
    private transient int numSerie;
    private String marca;
    private String model;
    private int memoria;
    private int discDur;
    private String processador;

    //Constructor
    public Ordinador(){}

    public Ordinador(int numSerie, String marca, String model, int memoria, int discDur, String processador){
        this.numSerie = numSerie;
        this.marca = marca;
        this.model = model;
        this.memoria = memoria;
        this.discDur = discDur;
        this.processador = processador;
    }

    //Getters y Setters
    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public int getDiscDur() {
        return discDur;
    }

    public void setDiscDur(int discDur) {
        this.discDur = discDur;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public String toString(){
        return "Ordinador{" + "marca=" + marca + ", model=" + model + ", memoria=" + memoria + ", discDur=" + discDur + ", processador=" + processador + '}';
    }
}
