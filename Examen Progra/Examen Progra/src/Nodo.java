public class Nodo {

    private Thunderbolts thunderbolt;
    private Nodo next;

    public Nodo(Thunderbolts thunderbolt) {

        this.thunderbolt = thunderbolt;
        this.next = null;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Thunderbolts getThunderbolt() {
        return thunderbolt;
    }

    public void setThunderbolt(Thunderbolts thunderbolt) {
        this.thunderbolt = thunderbolt;
    }
}

