import notes.*;

import java.util.Scanner;

public class ATM {
    private static int atm_sum = 1_000_000;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Card userCard = cardInput(sc);
        while (true) {
            menu();
            int action = sc.nextInt();
            switch (action) {
                case 1: withdrawMoney(sc, userCard);
                        break;
                case 2: loadMoney(sc, userCard);
                        break;
                case 3: checkBalance(userCard);
                        break;
                case 4: break;
                default:
                    System.out.println("Неверный ввод");
                    break;
            }
            if (action == 4) break;
        }
    }

    private static void menu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Снять деньги");
        System.out.println("2. Пополнить счет");
        System.out.println("3. Проверить баланс");
        System.out.println("4. Выйти");
    }

    private static void checkBalance(Card userCard) {
        System.out.println("Баланс вышей карты: " + userCard.getBalance() + " рублей");
    }

    private static Card cardInput(Scanner sc) {
        System.out.println("Введите номер карты");
        String cardNum = sc.nextLine();
        System.out.println("Введте пин-код для карты: " + cardNum);
        int pinCode = sc.nextInt();
        return new Card(cardNum, pinCode);
    }

    private static void loadMoney(Scanner sc, Card userCard) {
        System.out.println("Введите сумму пополнения");
        int sumToLoad = sc.nextInt();
        if (sumToLoad > 200000 || sumToLoad % 100 != 0) {
            System.out.println("Сумма должна быть меньше 200000 и кратна 100");
            return;
        }
        userCard.setBalance(userCard.getBalance() + sumToLoad);
    }

    private static void withdrawMoney(Scanner sc, Card userCard) {
        System.out.println("Введите сумму для снятия");
        int sumToWithdraw = sc.nextInt();
        if (sumToWithdraw > userCard.getBalance()) {
            System.out.println("Недостаточно средств на карте");
            return;
        }
        else if (sumToWithdraw > atm_sum) {
            System.out.println("Недостаточно средст в банкомате");
            return;
        }
        else if(sumToWithdraw > 200000 || sumToWithdraw % 100 != 0) {
            System.out.println("Сумма должна быть меньше 200000 и кратна 100");
            return;
        }

        Note note5000 = new Note5000();
        Note note2000 = new Note2000();
        Note note1000 = new Note1000();
        Note note500 = new Note500();
        Note note100 = new Note100();
        note5000.setNextNote(note2000);
        note2000.setNextNote(note1000);
        note1000.setNextNote(note500);
        note500.setNextNote(note100);

        note5000.takeMoney(sumToWithdraw);
        userCard.setBalance(userCard.getBalance()-sumToWithdraw);
    }
}
