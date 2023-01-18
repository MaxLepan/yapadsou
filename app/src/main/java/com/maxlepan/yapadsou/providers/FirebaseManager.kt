package com.maxlepan.yapadsou.providers

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class User(val email: String? = null, val password: String? = null)

object FirebaseManager {

    private val db = Firebase.firestore

    var firebaseAnalytics: FirebaseAnalytics = Firebase.analytics

    fun registration(
        email: String,
        password: String,
        confirmPassword: String,
        callback: () -> Unit,
        context : Context
    ) : Boolean {

        val user = User(email, password)
        val users = db.collection("users")


        fun addNewUser() {
            db.collection("users")
                .add(user)
                .addOnSuccessListener {
                    callback()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(context, "Une erreur est survenue : " + e.message, Toast.LENGTH_LONG).show()
                }
        }

        fun check(result : QuerySnapshot) : Boolean {
            if (!email.matches(Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$"))) {
                Toast.makeText(context, "Adresse Email invalide !", Toast.LENGTH_LONG).show()
                return false
            }

            if (!result.isEmpty) {
                Toast.makeText(context, "Cette adresse mail existe deja", Toast.LENGTH_LONG).show()
                return false
            }

            if(password.length < 4) {
                Toast.makeText(context, "Mot de passe trop court !", Toast.LENGTH_LONG).show()
                return false
            }

            if (password != confirmPassword) {
                Toast.makeText(context, "Mot de passe different", Toast.LENGTH_LONG).show()
                return false
            }

            return true
        }

        fun resolve(result : QuerySnapshot) {
            if (check(result)) {
                addNewUser()
            }
        }

        users.whereEqualTo("email", email).get().addOnSuccessListener{ result ->
            resolve(result)
        }


        return true
    }

    fun connection(
        email: String,
        password: String,
        callback: () -> Unit,
        context: Context
    ): Boolean {
        val users = db.collection("users")

        users
            .whereEqualTo("email", email)
            .whereEqualTo("password", password)
            .get()
            .addOnSuccessListener { matchingUsers ->
                if (!matchingUsers.isEmpty) {
                    callback()
                } else {
                    Toast.makeText(context, "Email ou mot de passe incorrect !", Toast.LENGTH_LONG).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(context, "Email ou mot de passe incorrect !", Toast.LENGTH_LONG).show()
            }

        return true
    }

    fun getItemsWithLimit(number : Long, callback: (QuerySnapshot) -> Unit): Boolean {

        val items = db.collection("items").limit(number)

        items.get().addOnSuccessListener(callback)

        return true
    }

    fun searchItemsByTerm(term : String, callback: (List<QueryDocumentSnapshot>) -> Unit): Boolean {

        val itemsRef = db.collection("items").get()

        itemsRef.addOnSuccessListener{ result ->
            val res = result.filter { it.contains(term) }
            callback(res)
        }
        return true
    }

    fun getUserById(id: String, callback: (DocumentSnapshot) -> Unit): Boolean {
        val userRef = db.collection("users").document(id).get()

        userRef.addOnSuccessListener(callback)

        return true
    }

    fun getAllUsers(callback: (QuerySnapshot) -> Unit): Boolean {
        val usersRef = db.collection("users").get()

        usersRef.addOnSuccessListener(callback)

        return true
    }
}