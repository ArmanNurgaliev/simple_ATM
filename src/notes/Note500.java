package notes;

public class Note500 extends Note {
    @Override
    public void takeMoney(int sumToWithdraw) {
        int numOfNotes = sumToWithdraw / 500;
        int remainder = sumToWithdraw % 500;

        if (numOfNotes > 0)
            System.out.println("Выдано " + numOfNotes + " банкнот номиналом " + 500 + " рублей");

        if (remainder > 0 && next != null)
            next.takeMoney(remainder);
    }
}
