import javax.swing.*;

class NoTree {

    int id;
    NoTree noEsquerdo;
    NoTree noDireito;
    String valor;
    NoTree tree;

    NoTree(int id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    NoTree() {}

    void adicionaPlanta(NoTree e){

        String planta = JOptionPane.showInputDialog(null, "Qual a planta que você pensou?");
        if (planta == null)
            System.exit(0);

        String caracteristica = JOptionPane
                .showInputDialog("Um(a) " + planta + "______ tem, mas um(a) " + e.valor + " não.");


        // variavel auxiliar armazena o valor antigo
        String aux = e.valor;
        e.valor = caracteristica;
        e.noDireito = new NoTree(++id, planta);
        e.noEsquerdo = new NoTree(++id, aux);
    }

    void perguntar(NoTree e){
        int pergunta = JOptionPane.showConfirmDialog(null, "A planta que você pensou é um(a)/tem " + e.valor + "?", "Confirme",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (pergunta == 0) {
            if (e.noDireito == null) {
                JOptionPane.showMessageDialog(null, "Yeah, Acertei!");
                System.exit(0);
            }
            else
                perguntar(e.noDireito);

        } else {
            if (e.noEsquerdo == null)
                adicionaPlanta(e);
            else
                perguntar(e.noEsquerdo);
        }
    }

    void setTree(NoTree e){
        this.tree = e;
    }

    NoTree getTree(){
        return this.tree;
    }
}
