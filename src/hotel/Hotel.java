package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nome;
    private List<Quartos> quartos;
    private List<Camareiras> camareiras;
    private List<Recepcionistas> recepcionistas;
    private List<Hospede> hospedes;
    //teste
    private int numVagas;
    private int numHospedes;
    private final int capacidadeMaxima;
    
    public Hotel(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.numVagas = capacidadeMaxima;
        this.numHospedes = 0;
    }


    public Hotel(String nome) {
        this.capacidadeMaxima = 0;
		this.nome = nome;
        this.quartos = new ArrayList<>();
        this.camareiras = new ArrayList<>();
        this.recepcionistas = new ArrayList<>();
        this.hospedes = new ArrayList<>();
    }
    //teste
    public synchronized boolean temVaga() {
        return numVagas > 0;
    }

    public synchronized boolean temHospedeEmEspera() {
        return numHospedes >= capacidadeMaxima;
    }

    public synchronized void incrementarNumeroHospedes() {
        numHospedes++;
        numVagas--;
    }

    public synchronized void decrementarNumeroHospedes() {
        numHospedes--;
        numVagas++;
    }
    
    // Método para encontrar um quarto disponível
    private Quartos encontrarQuartoDisponivel() {
        for (Quartos quarto : quartos) {
            if (!quarto.isOcupado()) {
                return quarto;
            }
        }
        return null; // Retorna null se nenhum quarto estiver disponível
    }

    // Método público para alocar um quarto disponível
    public void alocarQuartoParaFamilia(Familia familia) {
        Quartos quartoDisponivel = encontrarQuartoDisponivel();
        if (quartoDisponivel != null) {
            quartoDisponivel.setFamilia(familia);
            System.out.println("Família alocada ao quarto " + quartoDisponivel.getNumeroQuarto());
        } else {
            System.out.println("Não há quartos disponíveis para a família.");
            // Lógica para lidar com a situação em que não há quartos disponíveis
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Quartos> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quartos> quartos) {
        this.quartos = quartos;
    }

    public List<Camareiras> getCamareiras() {
        return camareiras;
    }

    public void setCamareiras(List<Camareiras> camareiras) {
        this.camareiras = camareiras;
    }

    public List<Recepcionistas> getRecepcionistas() {
        return recepcionistas;
    }

    public void setRecepcionistas(List<Recepcionistas> recepcionistas) {
        this.recepcionistas = recepcionistas;
    }

    public List<Hospede> getHospedes() {
        return hospedes;
    }

    public void setHospedes(List<Hospede> hospedes) {
        this.hospedes = hospedes;
    }
}
