package hotel;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//criando hotel:
		Hotel ibis = new Hotel("Ibis");
		
		
        // Criando e adicionando 50 hóspedes ao hotel:
        // Criando famílias
        List<Familia> familias = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // Por exemplo, criaremos 10 famílias
            Familia familia = new Familia();
            for (int j = 0; j < (int)(Math.random() * 3) + 2; j++) { // Entre 2 e 4 membros por família
                String nomeHospede = "Hospede_" + i + "_" + j;
                Hospede hospede = new Hospede(nomeHospede);
                familia.adicionarMembro(hospede);
            }
            familias.add(familia);
        }
		//criando recepcionista
		for (int i = 1; i <= 5 ; i++) {
		    String nomeRecepicionista = "Recepicionista_" + i;
		    Recepcionistas recepcionista = new Recepcionistas(nomeRecepicionista);
		    ibis.getRecepcionistas().add(recepcionista);
		}
		//criando quartos
		for (int i = 1; i <= 10 ; i++) {
		    String numeroquarto = "Quarto_" + i;
		    Quartos quartos = new Quartos(numeroquarto,false,true);
		    ibis.getQuartos().add(quartos);
		}
		//criando camareiras
		for (int i = 1; i <= 10 ; i++) {
		    String camareiras = "camareira_" + i;
		    Camareiras camareira = new Camareiras(camareiras,false);
		    ibis.getCamareiras().add(camareira);
		}				
		//mostrar os clientes:
		/*
        System.out.println("Hóspedes no hotel:");
        for (Hospede hospede : ibis.getHospedes()) {
            System.out.println(hospede.getNome());
        }
		*/
		//mostrar os recepicionista
		/*
        for (Recepcionistas recepicionista : ibis.getRecepcionistas()) {
            System.out.println(recepicionista.getNome());
        }
        */
		/*
		 //mostra camareiras 
        for ( Camareiras camareir: ibis.getCamareiras()) {
            System.out.println(camareir.getNome());
        }
        */
		//simulando entrada no hotel
		for (Familia familia : familias) {
		    Quartos quartoDisponivel = ibis.encontrarQuartoDisponivel();
		    if (quartoDisponivel != null) {
		        quartoDisponivel.setFamilia(familia);
		        System.out.println("Família alocada ao quarto " + quartoDisponivel.getNumeroQuarto());
		    } else {
		        System.out.println("Não há quartos disponíveis para a família.");
		        // Lógica para lidar com a situação em que não há quartos disponíveis
		    }
		    ibis.alocarQuartoParaFamilia(familia);
		}
		ibis.getRecepcionistas().get(0).VerificarOcupacao(ibis.getQuartos().get(0));
		ibis.getRecepcionistas().get(0).Alocar(ibis.getQuartos().get(0), ibis.getHospedes().get(0), ibis.getQuartos().get(0), ibis.getQuartos().get(0));
		ibis.getRecepcionistas().get(0).VerificarOcupacao(ibis.getQuartos().get(0));


	}

}
