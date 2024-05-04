package hotel;

import java.util.List;

public class Recepcionistas extends Thread {
	//atributos
	private String nome;
	private Quartos quartos;
	private Hotel02 hotel;

	//construtores

	public  Recepcionistas(Hotel02 hotel) {
		// TODO Auto-generated constructor stub
		this.hotel = hotel;
	}
	public Recepcionistas(String nome ) {
		this.nome=nome;
	}
	public void  run() {
		while(true) {
			synchronized (hotel) {
				if(hotel.temHospedeEmEspera() && hotel.temVaga()) {
					hotel.decrementarNumeroHospedes();
					hotel.notify();//notificar os clientes em espera
				}
			}
		}
		
	}
	
	public Quartos getQuartos() {
		return quartos;
	}

	public void setQuartos(Quartos quartos) {
		this.quartos = quartos;
	}

	public Hotel02 getHotel() {
		return hotel;
	}

	public void setHotel(Hotel02 hotel) {
		this.hotel = hotel;
	}



	//get e set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	//metodos

	//verifica ocupação do quarto
	public void VerificarOcupacao(Quartos quarto) {
        if (quarto.isOcupado()) {
            System.out.println(quarto.getNumeroQuarto() + " - Quarto ocupado!");
        } else {
            System.out.println(quarto.getNumeroQuarto() + " - Quarto desocupado");
        }
	}
	//verifica se esta limpo ou não
	public void VerifcarLimpo(Quartos quartos) {
		if(quartos.getEstadoLimpeza() == true) {
			System.out.println(getNum_quartos()+"Está Limpo!");
		} else {
			System.out.println("Não está Limpo!");
		}
	}

	//alocar quarto
	public void Alocar(Quartos estado, Hospede nome, Quartos ocupado, Quartos num_quarto) {
		if(!ocupado.getOcupado() && estado.getEstadoLimpeza()) {
			ocupado.setHospede(nome);
			ocupado.setOcupado(true);
			estado.setEstadoLimpeza(false);

			System.out.println(" hospede " + nome.getNome()+" alugou quarto " + num_quarto.getNum_quarto());
		} else {
			System.out.println("Não pode alugar!");
		}
	}
    public static Quartos encontrarQuartoDisponivel(List<Quartos> quartos) {
        for (Quartos quarto : quartos) {
            if (!quarto.isOcupado()) {
                return quarto;
            }
        }
        return null; // Retorna null se nenhum quarto estiver disponível
    }

	private char[] getNum_quartos() {
		// TODO Auto-generated method stub
		return null;
	}
	private String getNum_quarto() {
		// TODO Auto-generated method stub
		return null;
	}
}