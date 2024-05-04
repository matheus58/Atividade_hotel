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
}