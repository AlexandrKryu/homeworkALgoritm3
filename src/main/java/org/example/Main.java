package org.example;

import java.util.Arrays;
import java.util.Random;

// Узел связанного списка
class Node
{
    int data;
    Node next;

    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}

class Main
{
    public static void main(String[] args)
    {
        // ключи ввода
        int[] keys = new Random().ints(10,1,30).toArray();

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        System.out.println(Arrays.toString(keys));
        head = reverse(head);
        printList(head);
    }
    // Вспомогательная функция для печати заданного связанного списка
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " —> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    // Переворачивает заданный связанный список, изменяя его поля `.next` и
    // его голова.
    public static Node reverse(Node head)
    {
        Node previous = null;
        Node current = head;

        // обход списка
        while (current != null)
        {
            //следующий узел
            Node next = current.next;

            current.next = previous;    // фиксируем текущий узел

            previous = current;
            current = next;
        }

        // фиксируем голову, чтобы она указывала на новый фронт
        return previous;
    }


}