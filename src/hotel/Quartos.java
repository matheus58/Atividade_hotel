package hotel;

public class Quartos {
	//atributos
	private String numeroQuarto;
	private boolean ocupado;
	private boolean estadoLimpeza;
	private EstadoChave estadoChave;


	//construtor
	
	public Quartos(String numeroQuarto, boolean ocupado, boolean estadoLimpeza) {
		this.numeroQuarto = numeroQuarto;
		this.ocupado = ocupado;
		this.estadoLimpeza = estadoLimpeza;
	}
	public Quartos(String num_quarto, boolean ocupado, boolean estado, EstadoChave estadoChave, String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
		this.ocupado = ocupado;
		this.estadoLimpeza = estadoLimpeza;
		this.estadoChave = estadoChave.Disponivel;
	}

	//get
	public String getNum_quarto() {
		return numeroQuarto;
	}
    public boolean isOcupado() {
        return ocupado;
    }
	public boolean getOcupado() {
		return ocupado;
	}
	public String getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public boolean getEstadoLimpeza() {
		return estadoLimpeza;
	}
	public EstadoChave getEstadoChave() {
		return estadoChave;
	}
	
	//set
	public void numeroQuarto(String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado=ocupado;
	}
	public void setEstadoLimpeza(boolean estadoLimpeza) {
		this.estadoLimpeza=estadoLimpeza;
	}
	public void setEstadoChave(EstadoChave estadoChave) {
		this.estadoChave = estadoChave;
	}
	public void setHospede(Hospede nome) {
		// TODO Auto-generated method stub
		
	}
	public void setFamilia(Familia familia) {
		// TODO Auto-generated method stub
		
	}

}