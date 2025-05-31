
public class ConcateStr {
    Node head;

    class Node {
        char data;
        Node next;
    
        Node(char data) {
            this.data = data;
            next = null;
        }
    }

    public void addNode(char data) {
        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;
            return;
        }

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = new_node;
    }

    public void ListFromString(String str) {
        for (int i = 0; i < str.length(); i++) {
            addNode(str.charAt(i));
        }
    }

    public String StringFromList() {
        StringBuilder strBuilder = new StringBuilder();
        Node current_node = head;

        while (current_node != null) {
            strBuilder.append(current_node.data);
            current_node = current_node.next;
        }

        return strBuilder.toString();
    }

    public int Search(char key) {
        Node current_node = head;
        int pos = 1;

        while (current_node != null) {
            if (current_node.data == key)
                return pos;
            pos++;
            current_node = current_node.next;
        }

        return -1;
    }

    public int listLength() {
        Node current_node = head;
        int length = 0;

        while (current_node != null) {
            length++;
            current_node = current_node.next;
        }

        return length;
    }

    public void Concatenate(ConcateStr otherList) {
        if (head == null) {
            head = otherList.head;
            return;
        }

        Node current_node = head;

        while (current_node.next != null) {
            current_node = current_node.next;
        }

        current_node.next = otherList.head;
    }

    public void deleteFirstChar() {
        if (head != null) {
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ConcateStr charList = new ConcateStr();
        charList.ListFromString("hello");
        System.out.println(charList.StringFromList());
        System.out.println(charList.Search('l'));
        System.out.println(charList.listLength());

        ConcateStr charList2 = new ConcateStr();
        charList2.ListFromString("world");
        charList.Concatenate(charList2);
        System.out.println(charList.StringFromList());

        charList.deleteFirstChar();
        System.out.println(charList.StringFromList());
    }
}