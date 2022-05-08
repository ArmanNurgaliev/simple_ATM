package notes;

public class Note5000 extends Note {
    @Override
    public void takeMoney(int sumToWithdraw) {
        int numOfNotes = sumToWithdraw / 5000;
        int remainder = sumToWithdraw % 5000;

        if (numOfNotes > 0)
            System.out.println("Выдано " + numOfNotes + " банкнот номиналом " + 5000 + " рублей");

        if (remainder > 0 && next != null)
            next.takeMoney(remainder);
    }
}
