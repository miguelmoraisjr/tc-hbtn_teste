public class OperacaoBasicaTeste {

    public static boolean testar_soma() {
        double soma = OperacaoBasica.somar(5, 3);
        if (soma == 8 ) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean testar_subtracao(){
        double subtracao = OperacaoBasica.subtrair(5,3);
        if (subtracao == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean testar_multiplicacao() {
        double multiplicacao = OperacaoBasica.multiplicar(5,3);
        if (multiplicacao == 15) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean testar_divisao() {
        double divisao = OperacaoBasica.dividir(9,3);
        if (divisao == 3) {
            return true;
        } else {
            return false;
        }
    }
}
