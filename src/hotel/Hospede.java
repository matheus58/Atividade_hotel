package hotel;

public class Hospede extends Thread{
	private String nome;
	private Hotel02 hotel; //referencia o hotel que o ospede esta 
	
	//Construtores 
	public Hospede(Hotel02 hotel ,String nome) {
		this.nome = nome ;
		this.hotel = hotel ;
	}
	
	//Metodo pricipal da thred 
	public void run() {
		boolean vagaDisponovel = false;
		
		//bloco sincronizado para garantir que a manipulaçao de dados compartilhados seja segura entre as threds
		synchronized (hotel) {
			while(!hotel.temVaga()) {
				try {
					// Hospede aguarda ate uma vaga esteja disponivel
					System.out.println("Hospede "+ this.getNome() + " esta em espera.");
					hotel.wait();
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			// Quando a vaga esta disponivel, o cliente reserva a vaga  e entra no hotel 
			vagaDisponovel = true;
<<<<<<< HEAD
			System.out.println("Hospede "+ this.getNome() +"entrou no quarto ");
=======
			System.out.println("\u001B[32mHospede \u001B[0m" + this.getNome() + " \u001B[32mEntrou no Quarto");
			System.out.println("\u001B[32m---------------------------------------------\u001B[0m");
>>>>>>> origin/main
			hotel.incrementarNumeroHospedes();// Incrementa o numeros de hospedes no hotel
		}
		
		// Apos reservar a vaga, o cliente permanece no quarto por um periodo de tempo (simulado)
		try {
			Thread.sleep(1000); // Simula o cliente no quarto por 2 segundos 
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// Quando o cliente sai do quarto, ele notifica o hotel e libera o monitor 
		synchronized (hotel) {
<<<<<<< HEAD
			hotel.decrementarNumeroHospedes(); //Decrementa o numero de hospedes no hotel 
			System.out.println("cliente "+ this.getNome() +"saio do quarto");
=======
			hotel.decrementarNumeroHospedes(); //Decrementa o numero de hospedes no hotel
			System.out.println("\u001B[31mHospede \u001B[0m" + this.getNome() + " \u001B[31mSaiu do Quarto\u001B[0m");
			System.out.println("\u001B[31m---------------------------------------------\u001B[0m");
>>>>>>> origin/main
			hotel.notify(); // Notifica a camareira que o quarto esta disponivel para limpeza 
		}	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}