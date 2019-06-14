import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        int id = 1;
        NoTree principal = new NoTree();

       int aux2 = JOptionPane.showConfirmDialog((Component)null, "Pense em uma planta.", "Jogo das Plantas", 2);

       if (aux2 == -1)
           System.exit(0);

        // Preenche a arvore caso ela esteja vazia
        if (aux2 != 2) {
            if (principal.getTree() == null){
                principal.setTree(new NoTree(id, "vive na água?"));
                principal.getTree().noDireito = new NoTree(++id, "lotus");
                principal.getTree().noEsquerdo = new NoTree(++id, "rosa");
            }

        } else
            System.exit(0);

        // Variavel de parada
        int aux = 1;

        do {
            int resposta = JOptionPane.showConfirmDialog(null, "A planta que você pensou " + principal.getTree().valor,
                    "Confirme", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (resposta == 0)
                principal.perguntar(principal.getTree().noDireito);
            else
                principal.perguntar(principal.getTree().noEsquerdo);

            if (resposta == -1)
                aux = 0;

        } while (aux == 1);
    }
}
