package hotel;

import java.util.ArrayList;
import java.util.List;

public class Main02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Hotel02 hotel = new Hotel02(10); // Cria um hotel com 10 quartos

        // Cria e inicia threads para os funcionários do hotel
        List<Thread> funcionarios = new ArrayList<>();
        for (int i = 0; i < 5; i++) { // 5 recepcionistas
            Recepcionistas recepcionista = new Recepcionistas(hotel);
            Thread threadRecepcionista = new Thread(recepcionista);
            funcionarios.add(threadRecepcionista);
        }
        for (int i = 0; i < 10; i++) { // 10 camareiras
            Camareiras camareira = new Camareiras(hotel);
            Thread threadCamareira = new Thread(camareira);
            funcionarios.add(threadCamareira);
        }
        for (Thread funcionario : funcionarios) {
            funcionario.start();
        }

        // Cria e inicia threads para os hóspedes
        List<Thread> hospedes = new ArrayList<>();
        for (int i = 1; i <= 11; i++) { // 50 hóspedes
        	String nome  =  "Hospede_"+i;
            Hospede hospede = new Hospede(hotel ,nome );
            Thread threadHospede = new Thread(hospede);
            System.out.println("Hospede:" +  hospede.getNome());
            hospedes.add(threadHospede);
        }
        for (Thread hospede : hospedes) {
            hospede.start();
        }
       hotel.incrementarNumeroHospedes();
       //hotel.temQuartosParaLimpar();
    }

}
