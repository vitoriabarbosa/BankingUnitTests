package vs.bankingunittests.exceptions;

/**
 * Exceção lançada quando uma operação bancária não pode ser concluída
 * devido a fundos insuficientes na conta.
 *
 * Essa exceção é usada para indicar que um saque, transferência ou depósito
 * ultrapassou o saldo disponível ou excedeu os limites da conta.
 *
 * @author vasouv
 */
public class InsufficientFundsException extends Exception {
	
	/**
	 * Constrói uma nova exceção de fundos insuficientes com uma mensagem especificada.
	 *
	 * @param message A mensagem detalhando o motivo da exceção.
	 */
	public InsufficientFundsException(String message) {
		super(message);
	}
	
}
