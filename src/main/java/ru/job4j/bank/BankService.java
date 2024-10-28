package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу системы банковских переводов
 * между счетами клиентов по паспортным данным
 * @author ALBERT GABYDULLIIN
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа MAP
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает данные нового пользователя и добавляет их в коллекцию
     * @param user экземпляр пользователя
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаляет пользователя из коллекии по паспортным данным
     * @param passport паспортные данные пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает пасспортные данные пользователя и создает реквизиты
     * если у него их еще нет, если пользователя нет, ничего не происходит
     * @param passport паспортные данные пользователя
     * @param account информация о банковских реквизитах
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспортным данным
     * @param passport паспортные данные пользователя
     * @return возвращает пользователя
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * ищет порльзователя по банковским реквизитам
     * @param passport паспортные данные пользователя
     * @param requisite информация о банковских реквизитах
     * @return возвращает пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account != null) {
                    if (account.getRequisite().equals(requisite)) {
                        return account;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Метод реализует перечесление средств от одного пользователя другому
     * @param sourcePassport паспортные данные отправителя
     * @param sourceRequisite реквизиты отправителя
     * @param destinationPassport паспортные данные получателя
     * @param destinationRequisite получателя отправителя
     * @param amount баланс на счете
     * @return возвращает был успех перевода или нет
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount == null
                || destinationAccount == null
                || (sourceAccount.getBalance() < amount || amount <= 0)) {
            return false;
        }

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        return true;

    }

    /**
     * метод get
     * @param user принимает данные пользователя
     * @return возвращает данные пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}