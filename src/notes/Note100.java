package notes;

public class Note100 extends Note {

    @Override
    public void takeMoney(int sumToWithdraw) {
        int numOfNotes = sumToWithdraw / 100;
        int remainder = sumToWithdraw % 100;

        if (numOfNotes > 0)
            System.out.println("Выдано " + numOfNotes + " банкнот номиналом " + 100 + " рублей");

        if (remainder > 0 && next != null)
            next.takeMoney(remainder);
    }
}
