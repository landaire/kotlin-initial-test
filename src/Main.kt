/**
 * Created by Lander Brandt on 4/20/15.
 */
package test

import java.util.Collections
import java.util.Random

class Customer(val name: String, val email: String, val id: Int) : Comparable<Customer> {

    override fun compareTo(other: Customer): Int = this.id - id

    override fun toString(): String {
        return "$id: $name -- $email"
    }
}

fun main(args : Array<String>) {
    val linkedList = LinkedList<Customer>()

    val rand = Random(System.currentTimeMillis())

    for (i in 1..30) {
        linkedList.add(Customer("Testing $i", "test@test$i.com", rand.nextInt()))
    }

    println("Unsorted")

    for (customer in linkedList) {
        println(customer)
    }

    println("\nTesting filtering on name == \"Testing 1\"")

    val result = linkedList filter { customer ->
        customer.name == "Testing 1"
    }

    println(result)
}
