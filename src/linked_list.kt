/**
 * Created by Lander Brandt on 4/20/15.
 */

package test

import java.util.ArrayList

class LinkedList<T : Comparable<T>> : MutableIterable<T> {
    inner private data class Node(var data: T?, var prev: Node?, var next: Node?)

    inner class LinkedListIterator(var current: Node, var head: Node, val removeItem: (data: T) -> Unit) : MutableIterator<T> {
        override fun next(): T {
            current = current.next!!
            return current.data!!
        }

        override fun remove() {
            removeItem(current.data!!)
            current = current.next!!
        }

        override fun hasNext(): Boolean {
            return current.next != head
        }
    }

    val head: Node = Node(null, null, null)
    var size: Int = 0

    init {
        head.next = head
        head.prev = head
    }

    fun add(data: T) {
        var newNode = Node(data, head.prev, head)
        head.prev!!.next = newNode
        head.prev = newNode
        size++
    }

    fun remove(data: T): Unit {
        val node = nodeForData(data)

        if (node != null) {
            node.prev!!.next = node.next
            node.next!!.prev = node.prev
            size--
        }
    }

    fun size(): Int {
        return size
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun iterator(): MutableIterator<T> {
        return LinkedListIterator(head, head, {data -> remove(data)})
    }

    private fun nodeForData(data: T): Node? {
        var cur = head

        while (cur.next != head) {
            cur = cur.next!!
            if (data.compareTo(cur.data!!) == 0) {
                return cur
            }
        }

        return null
    }
}
