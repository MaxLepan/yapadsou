package com.maxlepan.yapadsou.providers

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.UUID

data class User(val email: String? = null, val password: String? = null)

object firebaseManager {

    private var database: DatabaseReference = Firebase.database.reference

    fun registration(email: String, password: String) : Boolean {
        val userId = UUID.randomUUID().toString()
        val user = User(email, password)

        database.child("users").child(userId).setValue(user)

        return true
    }

}