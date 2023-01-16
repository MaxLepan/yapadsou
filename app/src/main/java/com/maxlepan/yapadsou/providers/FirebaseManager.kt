package com.maxlepan.yapadsou.providers

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class User(val email: String? = null, val password: String? = null)

object FirebaseManager {

    private val db = Firebase.firestore

    fun registration(email: String, password: String, callback: () -> Unit ) : Boolean {

        val user = User(email, password)
        val users = db.collection("users")

        val userAlreadyExist = !users.whereEqualTo("email", email).get().result.isEmpty

        if (userAlreadyExist) {
            return false
        }

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                callback()
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }

        return true
    }

    fun connection(email: String, password: String, callback: () -> Unit): Boolean {
        val users = db.collection("users")

        users
            .whereEqualTo("email", email)
            .whereEqualTo("password", password)
            .get()
            .addOnSuccessListener { matchingUsers ->
                if (!matchingUsers.isEmpty) {
                    callback()
                }
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Users doesn't exist", e)
            }

        return true
    }

}