import java.util.*;

public class LinkedList<E>
{
	Node<E> head;
	int size;

	private class Node<E>
	{
		E data;
		Node<E> next;

		public Node(E val)
		{
			data = val;
			next = null;
		}
	}

	/* CONSTRUCTOR */
	public LinkedList()
	{
		head = null;
		size = 0;
	}

	public void add(E item)
	{
		Node<E> previous = head;
		while (previous.next != null)
		{
			previous = previous.next;
		}
		Node<E> node = new Node(item);
		previous.next = node;
		size++;
	}

	public void add(E item, int position)
	{
		if (position < 0 && position >= size)
		{
			System.out.println("Error.");
		}
		else if (position == 0)
		{
			Node<E> node = new Node(item);
			node.next = head;
			head = node;
			++size;
		}
		else
		{
			Node<E> previous = head;
			for (int i = 0; i < position - 1; i++)
			{
				previous = previous.next;
			}
			Node<E> node = new Node(item);
			node.next = previous.next;
			previous.next = node;
			++size;
		}
	}

	public E get(int position)
	{
		if (position < 0 || position >= size)
		{
			return null;
		}
		Node<E> node = head;
		for (int i = 0; i < position; i++)
		{
			node = node.next;
		}
		return node.data;
	}

	public E remove(int position)
	{
		if (position < 0 && position >= size)
		{
			System.out.println("Error.");
		}
		if (position == 0)
		{
			Node<E> node = head;
			head = head.next;
			size--;
			return node.data;
		}
		else
		{
			Node<E> previous = head;
			for (int i = 0; i < position - 1; i++)
			{
				previous = previous.next;
			}
			Node<E> node = previous.next;
			previous.next = node.next;
			size--;
			return node.data;
		}
	}

	public Node<E> reverse(Node<E> head)
	{
		Node<E> current = head;
		Node<E> previous = null;
		Node<E> next = null;

		while (current != null)
		{
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		head = previous;
		return head;
	}

	public void print()
	{
		Node<E> node = head;
		while (node != null);
		{
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args)
	{
		LinkedList linkedList = new LinkedList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		
		linkedList.add(6);

		linkedList.add(6, 0);

		linkedList.get(2);

		linkedList.remove(4);

		linkedList.print();

		linkedList.head = linkedList.reverse(linkedList.head);
		linkedList.print();

	}
}