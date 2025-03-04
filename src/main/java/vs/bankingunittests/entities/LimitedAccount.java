package vs.bankingunittests.entities;

/**
 * Representa uma conta bancária com um limite máximo de saldo.
 *
 * Esta classe estende a {@link Account} e adiciona uma restrição de limite ao saldo da conta.
 * O limite define a quantidade máxima de dinheiro que pode ser depositada na conta.
 *
 * @author vasouv
 */
public class LimitedAccount extends Account {
	
	private int limit;
	
	/**
	 * Construtor para criar uma conta com limite.
	 *
	 * @param owner Nome do proprietário da conta.
	 * @param balance Saldo inicial da conta.
	 * @param accountType Tipo da conta (ex: corrente, poupança).
	 * @param limit Limite máximo permitido para o saldo da conta.
	 */
	public LimitedAccount(String owner, int balance, String accountType, int limit) {
		super(owner, balance, accountType);
		this.limit = limit;
	}
	
	/**
	 * Obtém o limite máximo permitido para o saldo da conta.
	 *
	 * @return O limite da conta.
	 */
	public int getLimit() {
		return limit;
	}
	
	/**
	 * Define um novo limite para a conta.
	 *
	 * @param limit O novo limite máximo da conta.
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	/**
	 * Retorna uma representação em string da conta limitada.
	 *
	 * @return Uma string contendo os detalhes da conta, incluindo o limite.
	 */
	@Override
	public String toString() {
		return "LimitedAccount{" +
			       "owner='" + getOwner() + '\'' +
			       ", balance=" + getBalance() +
			       ", accountType='" + getAccountType() + '\'' +
			       ", limit=" + getLimit() +
			       '}';
	}
}
