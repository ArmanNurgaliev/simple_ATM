package notes;

public class Note1000 extends Note {
    @Override
    public void takeMoney(int sumToWithdraw) {
        int numOfNotes = sumToWithdraw / 1000;
        int remainder = sumToWithdraw % 1000;

        if (numOfNotes > 0)
            System.out.println("Выдано " + numOfNotes + " банкнот номиналом " + 1000 + " рублей");

        if (remainder > 0 && next != null)
            next.takeMoney(remainder);
    }
}
