package vs.bankingunittests.controller;

import vs.bankingunittests.entities.Account;
import vs.bankingunittests.entities.LimitedAccount;
import vs.bankingunittests.exceptions.InsufficientFundsException;

/**
 * Classe que representa um caixa eletrônico (ATM) para operações bancárias.
 * Permite depósitos, saques e transferências entre contas.
 *
 * @author vasouv
 */
public class ATM {

  /**
   * Realiza um depósito na conta informada.
   * Se a conta for limitada, verifica se o valor excede o limite permitido.
   *
   * @param account Conta onde o depósito será realizado.
   * @param amount Valor a ser depositado.
   * @throws InsufficientFundsException Se o depósito ultrapassar o limite da conta.
   */
  public void deposit(Account account, int amount) throws InsufficientFundsException {
    if (account instanceof LimitedAccount) {
      if (amount > (((LimitedAccount) account).getLimit() - account.getBalance())) {
        throw new InsufficientFundsException("Cannot deposit more than your account can hold");
      } else {
        System.out.println("Depositing " + amount + " to " + account.toString());
        account.setBalance(account.getBalance() + amount);
        System.out.println("New account balance: " + account.toString());
      }
    } else {
      account.setBalance(account.getBalance() + amount);
    }
  }

  /**
   * Realiza um saque na conta informada.
   *
   * @param account Conta de onde o valor será sacado.
   * @param amount Valor a ser sacado.
   * @throws InsufficientFundsException Se o saldo for insuficiente.
   */
  public void withdraw(Account account, int amount) throws InsufficientFundsException {
    if (amount > account.getBalance()) {
      throw new InsufficientFundsException("Cannot withdraw more money than you have");
    } else {
      System.out.println("Withdrawing " + amount + " from " + account.toString());
      account.setBalance(account.getBalance() - amount);
      System.out.println("New account balance: " + account.toString());
    }
  }

  /**
   * Realiza uma transferência de uma conta para outra.
   * Se a conta de destino for limitada, verifica se o valor ultrapassa o limite permitido.
   *
   * @param source Conta de origem.
   * @param target Conta de destino.
   * @param amount Valor a ser transferido.
   * @throws InsufficientFundsException Se o saldo for insuficiente ou se a conta de destino não puder receber o valor.
   */
  public void transfer(Account source, Account target, int amount) throws InsufficientFundsException {
    if (amount < source.getBalance()) {
      if (target instanceof LimitedAccount) {
        if (amount <= ((LimitedAccount) target).getLimit() - target.getBalance()) {
          System.out.println("Transferring " + amount + " from " + source + " to " + target);
          withdraw(source, amount);
          deposit(target, amount);
          System.out.println("Transfer successfully");
        } else {
          throw new InsufficientFundsException("Target account can't hold that amount");
        }
      } else {
        System.out.println("Transferring " + amount + " from " + source + " to " + target);
        withdraw(source, amount);
        deposit(target, amount);
        System.out.println("Transfer successfully");
      }
    } else {
      throw new InsufficientFundsException("Can't transfer more money than your balance");
    }
  }
}
