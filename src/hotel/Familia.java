package hotel;

import java.util.ArrayList;
import java.util.List;

public class Familia {
    private List<Hospede> membros;

    public Familia() {
        membros = new ArrayList<>();
    }

    public List<Hospede> getMembros() {
        return membros;
    }

    public void adicionarMembro(Hospede hospede) {
        membros.add(hospede);
    }

    public static List<Familia> criarFamilias(Hotel02 hotel) {
        List<Familia> familias = new ArrayList<>();

        // Família 1 - 6 pessoas
        Familia familia1 = new Familia();
        for (int i = 1; i <= 6; i++) {
            String nome = "F1_Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia1.adicionarMembro(hospede);
        }
        familias.add(familia1);

        // Família 2 - 2 pessoas
        Familia familia2 = new Familia();
        for (int i = 1; i <= 2; i++) {
            String nome = "F2_Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia2.adicionarMembro(hospede);
        }
        familias.add(familia2);

        // Família 3 - 4 pessoas
        Familia familia3 = new Familia();
        for (int i = 1; i <= 4; i++) {
            String nome = "F3_Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia3.adicionarMembro(hospede);
        }
        familias.add(familia3);

        // Família 4 - 3 pessoas
        Familia familia4 = new Familia();
        for (int i = 1; i <= 3; i++) {
            String nome = "F4_Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia4.adicionarMembro(hospede);
        }
        familias.add(familia4);

        // Família 5 - 3 pessoas
        Familia familia5 = new Familia();
        for (int i = 1; i <= 3; i++) {
            String nome = "F5_Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia5.adicionarMembro(hospede);
        }
        familias.add(familia5);

        // Família 6 - 3 pessoas
        Familia familia6 = new Familia();
        for (int i = 1; i <= 3; i++) {
            String nome = "F6_Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia6.adicionarMembro(hospede);
        }
        familias.add(familia6);

        // Família 7 - 3 pessoas
        Familia familia7 = new Familia();
        for (int i = 1; i <= 3; i++) {
            String nome = "F7_Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia7.adicionarMembro(hospede);
        }
        familias.add(familia7);

        // Família 8 - 5 pessoas
        Familia familia8 = new Familia();
        for (int i = 1; i <= 5; i++) {
            String nome = "F8_Hospede_" + i;
            Hospede hospede = new Hospede(hotel, nome);
            familia8.adicionarMembro(hospede);
        }
        familias.add(familia8);

        return familias;
    }
}
