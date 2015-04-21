/**
 * Created by Lander Brandt on 4/20/15.
 */
package test

class Customer(val name: String, val email: String, val id: Int) : Comparable<Customer> {
    override fun compareTo(other: Customer): Int {
        return this.id - id
    }

    override fun toString(): String {
        return "$id: $name -- $email"
    }
}

fun main(args : Array<String>) {
    val linkedList = LinkedList<Customer>()
    linkedList.add(Customer("Testing", "test@test.com", 123))
    linkedList.add(Customer("Testing 2", "Testing2@testing2.com", 321))

    for (customer in linkedList) {
        println(customer)
    }
}
