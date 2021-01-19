package main.kotlin.repository.userRepository

import main.kotlin.domain.user.User
import java.util.*

class userRepository private constructor() {
    private var users: MutableList<User?>? = null
    fun getUsers(): List<User?>? {
        return users
    }

    val formattedUserNames: List<String>
        get() {
            val userNames: MutableList<String> = ArrayList(users!!.size)
            for (user in users) {
                var name: String
                name = if (user!!.lastName != null) {
                    if (user!!.firstName != null) {
                        user!!.firstName + " " + user!!.lastName
                    } else {
                        user!!.lastName
                    }
                } else if (user!!.firstName != null) {
                    user!!.firstName
                } else {
                    "Unknown"
                }
                userNames.add(name)
            }
            return userNames
        }

    companion object {
        private var INSTANCE: userRepository? = null
        val instance: userRepository?
            get() {
                if (INSTANCE == null) {
                    synchronized(userRepository::class.java) {
                        if (INSTANCE == null) {
                            INSTANCE = userRepository()
                        }
                    }
                }
                return INSTANCE
            }
    }

    // keeping the constructor private to enforce the usage of getInstance
    init {
        val user1 = User("Jane", "")
        val user2 = User("John", null)
        val user3 = User("Anne", "Doe")
        users = ArrayList<Any?>()
        users.add(user1)
        users.add(user2)
        users.add(user3)
    }
}