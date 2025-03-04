package vs.bankingunittests.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vs.bankingunittests.entities.Account;
import vs.bankingunittests.entities.LimitedAccount;
import vs.bankingunittests.exceptions.InsufficientFundsException;

/**
 * Classe de testes para a funcionalidade do ATM (caixa eletrônico).
 * <p>
 * Esta classe contém testes unitários para verificar operações bancárias como
 * depósitos, saques e transferências entre contas normais e contas com limite.
 * <p>
 * Utiliza JUnit 5 para estruturar os testes.
 *
 * @author vasouv
 */
public class ATMTest {
	
	/**
	 * Conta regular para testes
	 */
	Account regular;
	
	/**
	 * Conta com limite para testes
	 */
	Account limited;
	
	/**
	 * Conta de origem para testes de transferência
	 */
	Account regularSource1;
	
	/**
	 * Conta de destino para testes de transferência
	 */
	Account regularTarget1;
	
	/**
	 * Instância do ATM que será testada
	 */
	ATM atm;
	
	/**
	 * Inicializa os objetos de teste antes de cada execução.
	 */
	@BeforeEach
	void init() {
		regular = new Account("vasouv", 1000, "regular");
		limited = new LimitedAccount("mixos", 300, "limit", 500);
		regularSource1 = new Account("chris", 2000, "regular");
		regularTarget1 = new Account("geo", 5000, "regular");
		atm = new ATM();
	}
	
	// -------------------------------------------------------------
	//               TESTES EXISTÊNTES
	// -------------------------------------------------------------
	
	/**
	 * Testa o depósito de valor zero em uma conta regular.
	 */
	@Test
	@DisplayName("Depositing zero amount to a regular account")
	void deposit_regular_account_zero_amount() throws InsufficientFundsException {
		int expected = regular.getBalance();
		atm.deposit(regular, 0);
		int actual = regular.getBalance();
		assertEquals(expected, actual);
	}
	
	/**
	 * Testa o depósito de valor zero em uma conta limitada.
	 */
	@Test
	@DisplayName("Depositing zero amount to a limited account")
	void deposit_limited_account_zero_amount() throws InsufficientFundsException {
		int expected = limited.getBalance();
		atm.deposit(limited, 0);
		int actual = limited.getBalance();
		assertEquals(expected, actual);
	}
	
	/**
	 * Testa o depósito de um valor positivo em uma conta regular.
	 */
	@Test
	@DisplayName("Depositing some amount to a regular account")
	void deposit_regular_account_some_amount() throws InsufficientFundsException {
		int initialBalance = regular.getBalance();
		int amount = 100;
		int expected = initialBalance + amount;
		atm.deposit(regular, amount);
		int actual = regular.getBalance();
		assertEquals(expected, actual);
	}
	
	/**
	 * Testa o depósito de um valor abaixo do limite em uma conta limitada.
	 */
	@Test
	@DisplayName("Depositing amount below limit to limited account")
	void deposit_limited_account_amount_below_limit() throws InsufficientFundsException {
		int initialBalance = limited.getBalance();
		int amount = 100;
		int expected = initialBalance + amount;
		atm.deposit(limited, amount);
		int actual = limited.getBalance();
		assertEquals(expected, actual);
	}
	
	/**
	 * Testa o depósito de um valor exatamente no limite da conta limitada.
	 */
	@Test
	@DisplayName("Depositing amount at limit to a limited account")
	void deposit_limited_account_amount_at_limit() throws InsufficientFundsException {
		int initialBalance = limited.getBalance();
		int amount = 200;
		int expected = initialBalance + amount;
		atm.deposit(limited, amount);
		int actual = limited.getBalance();
		assertEquals(expected, actual);
	}
	
	/**
	 * Testa a tentativa de depósito acima do limite da conta limitada,
	 * que deve lançar uma exceção.
	 */
	@Test
	@DisplayName("Depositing amount above limit to limited account")
	void deposit_limited_account_amount_above_limit() {
		int amount = 500;
		Throwable exception = assertThrows(InsufficientFundsException.class, () -> {
			atm.deposit(limited, amount);
		});
		assertEquals("Cannot deposit more than your account can hold", exception.getMessage());
	}
	
	/**
	 * Testa a tentativa de saque de valor zero em uma conta regular.
	 */
	@Test
	@DisplayName("Withdrawing zero amount from regular account")
	void withdraw_regular_account_zero_amount() throws InsufficientFundsException {
		int initialBalance = regular.getBalance();
		atm.withdraw(regular, 0);
		int actual = regular.getBalance();
		assertEquals(initialBalance, actual);
	}
	
	/**
	 * Testa a tentativa de saque de valor zero em uma conta limitada.
	 */
	@Test
	@DisplayName("Withdrawing zero amount from limited account")
	void withdraw_limited_account_zero_amount() throws InsufficientFundsException {
		int initialBalance = limited.getBalance();
		atm.withdraw(limited, 0);
		int actual = limited.getBalance();
		assertEquals(initialBalance, actual);
	}
	
	/**
	 * Testa o saque de um valor normal em uma conta regular.
	 */
	@Test
	@DisplayName("Withdrawing normal amount from regular account")
	void withdraw_regular_account_normal_amount() throws InsufficientFundsException {
		int initialBalance = regular.getBalance();
		int amount = 250;
		int expected = initialBalance - amount;
		atm.withdraw(regular, amount);
		int actual = regular.getBalance();
		assertEquals(expected, actual);
	}
	
	/**
	 * Testa o saque do valor total disponível na conta regular.
	 */
	@Test
	@DisplayName("Withdrawing amount exactly as balance from regular account")
	void withdraw_regular_account_amount_exactly_balance() throws InsufficientFundsException {
		int amount = 1000;
		int expected = 0;
		atm.withdraw(regular, amount);
		int actual = regular.getBalance();
		assertEquals(expected, actual);
	}
	
	/**
	 * Testa a tentativa de saque de um valor maior do que o saldo disponível,
	 * que deve resultar em uma exceção.
	 */
	@Test
	@DisplayName("Withdrawing amount more than balance from regular account")
	void withdraw_regular_account_amount_more_than_balance() {
		int amount = 1200;
		Throwable exception = assertThrows(InsufficientFundsException.class, () -> {
			atm.withdraw(regular, amount);
		});
		assertEquals("Cannot withdraw more money than you have", exception.getMessage());
	}
	
	/**
	 * Testa a transferência de valor zero entre duas contas regulares.
	 */
	@Test
	@DisplayName("Transferring zero amount from regular account to regular account")
	void transfer_regular_source_regular_target_zero_amount() throws InsufficientFundsException {
		int expectedSourceBalance = regularSource1.getBalance();
		int expectedTargetBalance = regularTarget1.getBalance();
		
		atm.transfer(regularSource1, regularTarget1, 0);
		assertEquals(expectedSourceBalance, regularSource1.getBalance());
		assertEquals(expectedTargetBalance, regularTarget1.getBalance());
	}
	
	/**
	 * Testa a transferência de um valor válido entre duas contas regulares.
	 */
	@Test
	@DisplayName("Transferring normal amount from regular account to regular account")
	void transfer_regular_source_regular_target_normal_amount() throws InsufficientFundsException {
		int amount = 350;
		int expectedSourceBalance = regularSource1.getBalance() - amount;
		int expectedTargetBalance = regularTarget1.getBalance() + amount;
		
		atm.transfer(regularSource1, regularTarget1, amount);
		assertEquals(expectedSourceBalance, regularSource1.getBalance());
		assertEquals(expectedTargetBalance, regularTarget1.getBalance());
	}
	
	/**
	 * Testa a tentativa de transferência de um valor maior do que o saldo disponível,
	 * o que deve resultar em uma exceção.
	 */
	@Test
	@DisplayName("Transferring amount more than balance from regular account to regular account")
	void transfer_regular_source_regular_target_amount_more_than_balance() {
		int amount = 2350;
		
		Throwable exception = assertThrows(InsufficientFundsException.class, () -> {
			atm.transfer(regularSource1, regularTarget1, amount);
		});
		assertEquals("Can't transfer more money than your balance", exception.getMessage());
	}
	
	/**
	 * Testa a transferência de um valor zero de uma conta regular para uma conta limitada.
	 * Falta implementar...
	 */
	@Test
	@DisplayName("Transferring amount zero from regular account to limited account")
	void transfer_regular_source_limited_target_zero_amount() throws InsufficientFundsException {}
	
	// -------------------------------------------------------------
	//          NOVOS TESTES PARA AUMENTAR A COBERTURA
	// -------------------------------------------------------------
	
}
