package vs.bankingunittests.entities;

/**
 * Representa uma conta bancária genérica.
 *
 * Esta classe contém informações sobre o proprietário da conta, saldo e tipo de conta.
 * Métodos para acessar e modificar o saldo também estão disponíveis.
 *
 * @author vasouv
 */
public class Account {

  private String owner;
  private int balance;
  private String accountType;

  /**
   * Construtor para criar uma conta bancária.
   *
   * @param owner Nome do proprietário da conta.
   * @param balance Saldo inicial da conta.
   * @param accountType Tipo da conta (ex: corrente, poupança).
   */
  public Account(String owner, int balance, String accountType) {
    this.owner = owner;
    this.balance = balance;
    this.accountType = accountType;
  }

  /**
   * Obtém o nome do proprietário da conta.
   *
   * @return O nome do proprietário.
   */
  public String getOwner() {
    return owner;
  }

  // O método setOwner foi comentado para evitar alterações no proprietário da conta.
	//   public void setOwner(String owner) {
	//    // this.owner = owner;
	//   }

  /**
   * Obtém o saldo atual da conta.
   *
   * @return O saldo da conta.
   */
  public int getBalance() {
    return balance;
  }

  /**
   * Atualiza o saldo da conta.
   *
   * @param balance O novo saldo da conta.
   */
  public void setBalance(int balance) {
    this.balance = balance;
  }

  /**
   * Obtém o tipo da conta.
   *
   * @return O tipo da conta (ex: corrente, poupança).
   */
  public String getAccountType() {
    return accountType;
  }

  // O método setAccountType foi comentado para evitar alterações no tipo de conta.
	//	public void setAccountType(String accountType) {
	//		this.accountType = accountType;
	//	}

  /**
   * Retorna uma representação em string da conta bancária.
   *
   * @return Uma string contendo os detalhes da conta.
   */
  @Override
  public String toString() {
    return "Account{" +
      "owner='" + owner + '\'' +
      ", balance=" + balance +
      ", accountType='" + accountType + '\'' +
      '}';
  }
}
