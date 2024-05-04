package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hotel02 {
    // Variáveis de estado do hotel
    private int numVagas; // Número de vagas disponíveis no hotel
    private int numHospedes; // Número de hóspedes atualmente no hotel
    private final int capacidadeMaxima; // Capacidade máxima do hotel
    private List<Boolean> quartosLimpeza; // Lista para rastrear o estado de limpeza de cada quarto
    private List<Quartos> quartos;

    // Mecanismos de sincronização
    private final Lock lock; // Trava para controle de acesso aos recursos compartilhados
    private final Condition esperaRecepcionista; // Cria uma condição associada à trava

    // Construtor da classe Hotel
    public Hotel02(int capacidadeMaxima) {
        // Inicializando as variáveis de estado
        this.capacidadeMaxima = capacidadeMaxima;
        this.numVagas = capacidadeMaxima;
        this.numHospedes = 0;

        // Inicialização da lista de quartosLimpeza no construtor
        this.quartosLimpeza = new ArrayList<>(capacidadeMaxima);
        for (int i = 0; i < capacidadeMaxima; i++) {
            this.quartosLimpeza.add(true); // Inicialmente, todos os quartos estão limpos
        }

        // Inicialização dos mecanismos de sincronização
        this.lock = new ReentrantLock(); // Inicializando uma nova trava
        this.esperaRecepcionista = lock.newCondition(); // Cria uma condição associada à trava

        // Inicialização dos quartos do hotel
        this.quartos = new ArrayList<>();
        for (int i = 0; i < capacidadeMaxima; i++) {
            Quartos quarto = new Quartos("Quarto " + (i + 1), false, true);
            this.quartos.add(quarto);
        }
    }

    public synchronized boolean temQuartosParaLimpar() {
        return quartosLimpeza.contains(false); // Retorna true se houver algum quarto sujo
    }

    // Método para limpar um quarto
    public synchronized void limparQuarto() {
        // Encontra o primeiro quarto sujo e o limpa
        for (int i = 0; i < quartosLimpeza.size(); i++) {
            if (!quartosLimpeza.get(i)) { // Se o quarto estiver sujo
                System.out.println("Camareira está limpando o quarto " + (i + 1));
                quartosLimpeza.set(i, true); // Define o quarto como limpo
                return; // Termina o método após limpar um quarto
            }
        }
    }

    // Verifica se há vagas no hotel
    public boolean temVaga() {
        lock.lock(); // Adquire a trava
        try {
            return numVagas > 0; // Retorna true se há vagas disponíveis
        } finally {
            lock.unlock(); // Libera a trava
        }
    }

    // Verifica se há hóspedes em espera ("vê se o hotel está cheio")
    public boolean temHospedeEmEspera() {
        lock.lock(); // Adquire trava
        try {
            return numHospedes >= capacidadeMaxima; // Retorna true se o número de hóspedes for igual ou superior à capacidade máxima
        } finally {
            lock.unlock(); // Libera a trava
        }
    }

    // Incrementa o número de hóspedes no hotel
    public void incrementarNumeroHospedes() {
        lock.lock(); // Adquire a trava
        try {
            numHospedes++; // Incrementa o número de hóspedes
            numVagas--; // Decrementa o número de vagas
        } finally {
            lock.unlock(); // Libera a trava
        }
    }

    // Decrementa o número de hóspedes no hotel
    public void decrementarNumeroHospedes() {
        lock.lock();
        try {
            numHospedes--;// Incrementa o número de hóspedes
            numVagas++;// Decrementa o número de vagas
            esperaRecepcionista.signal(); // Notifica o recepcionista de que um hóspede saiu
        } finally {
            lock.unlock();// Libera a trava
        }
    }

    // Método para alocar quartos para famílias
    public void alocarQuartosParaFamilias(List<Familia> familias) {
        for (Familia familia : familias) {
            int numQuartosNecessarios = (int) Math.ceil((double) familia.getMembros().size() / 4);

            if (temVaga() && !temHospedeEmEspera()) {
                int contadorMembros = 0;
                for (int i = 0; i < numQuartosNecessarios; i++) {
                    Quartos quarto = encontrarQuartoDisponivel();
                    if (quarto != null) {
                        for (int j = 0; j < 4; j++) {
                            if (contadorMembros < familia.getMembros().size()) {
                                quarto.setHospede(familia.getMembros().get(contadorMembros));
                                quarto.setOcupado(true);
                                decrementarNumeroHospedes();
                                System.out.println(familia.getMembros().get(contadorMembros).getNome() + " alocado para o quarto " + quarto.getNum_quarto());
                                contadorMembros++;
                            } else {
                                break;
                            }
                        }
                    } else {
                        System.out.println("Não há quartos disponíveis para a família " + (familias.indexOf(familia) + 1));
                        break;
                    }
                }
            } else {
                System.out.println("Não há quartos disponíveis para a família " + (familias.indexOf(familia) + 1));
            }
        }
    }

    // Método para encontrar um quarto disponível
    public Quartos encontrarQuartoDisponivel() {
        for (Quartos quarto : quartos) {
            if (!quarto.isOcupado()) {
                return quarto;
            }
        }
        return null; // Retorna null se nenhum quarto estiver disponível
    }

    // Métodos de acesso para obter o objeto de trava e a condição associada
    public Lock getLock() {
        return lock;
    }

    public Condition getEsperaRecepcionista() {
        return esperaRecepcionista;
    }
}
