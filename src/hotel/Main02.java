package hotel;

import java.util.ArrayList;
import java.util.List;

public class Main02 {

    public static void main(String[] args) {
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
        for (int i = 1; i <= 50; i++) { // 50 hóspedes
            String nome = "Hospede_" + i;
            Hospede hospede = new Hospede(hotel, "Familia 1 " + nome);
            Thread threadHospede = new Thread(hospede);
//            System.out.println("Hospede:" +  hospede.getNome());

            hospedes.add(threadHospede);
        }
        for (Thread hospede : hospedes) {
            hospede.start();
        }

        // Cria e adiciona famílias
        List<Familia> familias = new ArrayList<>();
        Familia familia1 = new Familia();
        for (int i = 1; i <= 6; i++) {
            String nome = "Familia 1 Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia1.adicionarMembro(hospede);
        }
        familias.add(familia1);

        Familia familia2 = new Familia();
        for (int i = 7; i <= 8; i++) {
            String nome = "Familia 2 Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia2.adicionarMembro(hospede);
        }
        familias.add(familia2);

        Familia familia3 = new Familia();
        for (int i = 9; i <= 12; i++) {
            String nome = "Familia 3 Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia3.adicionarMembro(hospede);
        }
        familias.add(familia3);

        Familia familia4 = new Familia();
        for (int i = 13; i <= 15; i++) {
            String nome = "Familia 4 Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia4.adicionarMembro(hospede);
        }
        familias.add(familia4);

        Familia familia5 = new Familia();
        for (int i = 16; i <= 18; i++) {
            String nome = "Familia 5 Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia5.adicionarMembro(hospede);
        }
        familias.add(familia5);

        Familia familia6 = new Familia();
        for (int i = 19; i <= 21; i++) {
            String nome = "Familia 6 Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia6.adicionarMembro(hospede);
        }
        familias.add(familia6);

        Familia familia7 = new Familia();
        for (int i = 22; i <= 24; i++) {
            String nome = "Familia 7 Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia7.adicionarMembro(hospede);
        }
        familias.add(familia7);

        Familia familia8 = new Familia();
        for (int i = 25; i <= 30; i++) {
            String nome = "Familia 8 Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia8.adicionarMembro(hospede);
        }
        familias.add(familia8);

        Familia familia9 = new Familia();
        for (int i = 31; i <= 34; i++) {
            String nome = "Familia 9 Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia9.adicionarMembro(hospede);
        }
        familias.add(familia9);

        Familia familia10 = new Familia();
        for (int i = 35; i <= 37; i++) {
            String nome = "Familia 10 Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia10.adicionarMembro(hospede);
        }
        familias.add(familia10);

        Familia familia11 = new Familia();
        for (int i = 38; i <= 41; i++) {
            String nome = "Familia 11 Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia11.adicionarMembro(hospede);
        }
        familias.add(familia11);

        Familia familia12 = new Familia();
        for (int i = 42; i <= 46; i++) {
            String nome = "Familia 12 Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia12.adicionarMembro(hospede);
        }
        familias.add(familia12);

        Familia familia13 = new Familia();
        for (int i = 47; i <= 48; i++) {
            String nome = "Familia 13 Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia13.adicionarMembro(hospede);
        }
        familias.add(familia13);

        Familia familia14 = new Familia();
        for (int i = 49; i <= 51; i++) {
            String nome = "Familia 14 Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia14.adicionarMembro(hospede);
        }
        familias.add(familia14);

        hotel.alocarQuartosParaFamilias(familias);
    }
}
