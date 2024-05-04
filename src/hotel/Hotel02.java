/*
 * A classe Hotel gerencia a capacidade e a ocupação do hotel. Os métodos temVaga() e temHospedeEmEspera() verificam se há vagas 
 * disponíveis ou se o hotel está lotado, respectivamente. Os métodos incrementarNumeroHospedes() e decrementarNumeroHospedes() ajustam
 * o número de hóspedes e vagas disponíveis de forma segura para múltiplas threads, utilizando mecanismos de sincronização.
 */
package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Hotel02 {
	//variedades de estado do hotel 
	private int numVagas; //Numero de vagas disponiveis no hotel 
	private int numHospedes; //Numero de hospedes atulmente no hotel  
    private final int capacidadeMaxima; //capacidade maxima do hotel
    private List<Boolean> quartosLimpeza; // Lista para rastrear o estado de limpeza de cada quarto
    private List<Quartos> quartos;
    
    // Mecanismos de sincronizaçao
    private final Lock lock	; // Trava para controle de acesso aos recursos compartilhados
    private final Condition esperaRecepcionista; // Cria uma condição associada à trava
    
    //construtor da classe Hotel 
    public Hotel02(int capacidadeMaxima) {
    	//iniciando as variaveis de estado 
    	this.capacidadeMaxima = capacidadeMaxima;
    	this.numVagas = capacidadeMaxima;
    	this.numHospedes = 0 ;

     // Inicializa a lista de quartosLimpeza no construtor
        this.quartosLimpeza = new ArrayList<>(capacidadeMaxima);
        for (int i = 0; i < capacidadeMaxima; i++) {
            this.quartosLimpeza.add(true); // Inicialmente, todos os quartos estão limpos
        }
    	// Inicializaçao dos mecanismos de sincronizaçao 
    	this.lock = new ReentrantLock(); // Iniciando uma nova trava
    	this.esperaRecepcionista = lock.newCondition(); // cria uma condiçao associada a trava
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
    
    //verifica se a vagas no hotel 
    public boolean temVaga() {
		lock.lock(); // adquire a trava
		try {
			return numVagas > 0; // Retorna true se ha vagas disponiveis 
		} finally {
			lock.unlock(); // libera a trava
		}
	}
    
    // Verifica se ha hospedes em espera("ve se o hotel esta cheio")
    public boolean temHospedeEmEspera() {
    	lock.lock(); // adquire trava
    	try {
			return numHospedes >= capacidadeMaxima;//Retorna true se o número de hóspedes for igual ou superior à capacidade máxima
		} finally {
			// TODO: handle finally clause
			lock.unlock(); // libera a trava
		}
    }
    // Incrementa o numero de hospedes no hotel 
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
			esperaRecepcionista.signal(); //Notifica o recepcionista de que um hóspede saiu
		} finally {
			// TODO: handle finally clause
			lock.unlock();// Libera a trava
		}
    }
 // Métodos de acesso para obter o objeto de trava e a condição associada
    public Lock getLock() {
    	return lock;
    }
    public Condition getEsperaRecepcionista() {
        return esperaRecepcionista;
    }
    
    
}
