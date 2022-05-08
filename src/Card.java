public class Card {
    private String cardNumber;
    private int pinCode;
    private int balance;

    public Card(String cardNum, int pinCode) {
        this.cardNumber = cardNum;
        this.pinCode = pinCode;
        this.balance = 50000;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
