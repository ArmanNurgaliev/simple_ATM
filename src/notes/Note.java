package notes;

public abstract class Note {
    Note next;

    abstract public void takeMoney(int sumToWithdraw);

    public void setNextNote(Note note) {
        next = note;
    }
}
