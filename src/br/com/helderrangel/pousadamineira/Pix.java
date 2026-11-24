package br.com.helderrangel.pousadamineira;

public class Pix implements PagamentoTipo{
    @Override
    public boolean pagar(String chave) {

  /*      System.out.println("Iforme sua chave pix");
        String chave = ent.nextLine();
        if (forma.pagar(chave)) {
            System.out.println("Recebemos do Pix " + chave);
        } else {
            System.out.println("Pagamento inválido");
        }*/
        return false;
    }
}
