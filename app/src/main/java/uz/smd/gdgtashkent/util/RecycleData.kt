package uz.smd.gdgtashkent.util

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


fun Fragment.loadData(block: (DataSnapshot) -> Unit) {
    var database: DatabaseReference = Firebase.database.reference

    database.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            block(snapshot)
        }
        override fun onCancelled(error: DatabaseError) {
            showMessage(error.toException())
        }

    })
}

fun Fragment.showMessage(message: DatabaseException) {
    val dialog = AlertDialog.Builder(context)
        .setTitle("Info!")
        .setMessage(message.toString())
        .setPositiveButton("OK") { _, _ -> }
        .create()
    dialog.show()
}