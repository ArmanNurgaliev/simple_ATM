package notes;

public class Note2000 extends Note {
    @Override
    public void takeMoney(int sumToWithdraw) {
        int numOfNotes = sumToWithdraw / 2000;
        int remainder = sumToWithdraw % 2000;

        if (numOfNotes > 0)
            System.out.println("Выдано " + numOfNotes + " банкнот номиналом " + 2000 + " рублей");

        if (remainder > 0 && next != null)
            next.takeMoney(remainder);
    }
}
