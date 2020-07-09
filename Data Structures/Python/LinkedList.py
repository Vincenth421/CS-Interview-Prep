class Node:

    def __init__(self, i):
        self.item = i
        self.next = None

class LinkedList:

    def __init__(self):
        self.head = None
        self.size = 0

    def add(self, item):
        n = Node(item)
        curr = self.head

        if self.size == 0:
            self.head = Node(item)
            self.size = self.size + 1

        else:
            while curr.next != None:
                curr = curr.next

            curr.next = n
            self.size = self.size + 1

    def printList(self):
        curr = self.head

        while curr != None:
            print(str(curr.item), end=' ')
            curr = curr.next



def LinkedListTest():
    ll = LinkedList()

    ll.add(1)
    ll.add(2)
    ll.add(3)

    #1 2 3
    ll.printList()

LinkedListTest()
