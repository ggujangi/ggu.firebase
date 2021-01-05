package com.ggu.firebase.data

import android.util.Log
import com.ggu.firebase.data.model.LoggedInUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource(val auth: FirebaseAuth)  {

    fun login(username: String, password: String): Result<LoggedInUser>? {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
        } catch (e: Throwable) {
        }
        return null
    }

    fun logout() : Result<Boolean> {
        try{
            auth.signOut()
            return Result.Success(true)
        } catch (e:Throwable){
            return Result.Error(IOException("Error logout", e))
        }
    }

    fun createAccount(email:String, password:String) : Result<FirebaseUser>  {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    val user = auth.currentUser
                    Log.d("firebaseTest", "createAccount() : ${user?.email}")
                }
                else{
                    Log.d("firebaseTest", "createAccount() : isNotSuccessFul")
                }
            }
        val user = auth.currentUser
        Log.d("firebaseTest", "createAccount() : user = "+user?.email)

        return if(user==null) {
            Result.Error(IOException("user == null"))
        } else{
            Result.Success(user)
        }
    }
}