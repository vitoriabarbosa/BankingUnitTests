package vs.bankingunittests;

import vs.bankingunittests.entities.Account;
import vs.bankingunittests.entities.LimitedAccount;

/**
 * Classe principal que demonstra a criação de contas bancárias.
 *
 * Esta classe cria uma conta bancária comum e uma conta com limite,
 * apenas para fins de teste e demonstração.
 *
 * @author vasouv
 */
public class Main {
	
	/**
	 * Método principal que inicia a aplicação e demonstra a criação de contas.
	 *
	 * @param args Argumentos da linha de comando (não utilizados).
	 */
	public static void main(String[] args) {
		Account account = new Account("vasouv", 1000, "regular");
		Account withLimit = new LimitedAccount("mixos", 300, "limit", 500);
	}
}
