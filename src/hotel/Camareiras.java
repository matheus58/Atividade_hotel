package hotel;

public class Camareiras extends Thread {
	
	private Hotel02 hotel;
	
	//Construtor 
	public Camareiras(Hotel02 hotel) {
		this.hotel = hotel;
	}
	//metodo principal da Thred ;
	public void run() {
		while (true) {
			synchronized (hotel) {
				// Enquanto hover quartos para limpar, a camereira continua lipando os quartos 
				while (!hotel.temQuartosParaLimpar()) {
					try {
						hotel.wait();
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				// Quando ha um quarto para limpar , a camareira lipa o quarto 
				hotel.limparQuarto();
				//Apos limpar o quarto,a camareira notifica os clientes que estao esperando 
				hotel.notifyAll();
				
			}
		}
	}
	
}