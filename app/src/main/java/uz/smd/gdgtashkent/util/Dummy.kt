package uz.smd.gdgtashkent.util

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.util.Log
import androidx.fragment.app.Fragment
import com.bumptech.glide.load.HttpException
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import uz.smd.gdgtashkent.data.Speaker
import java.util.ArrayList

class Dummy {

    companion object {

        fun getAgendaCloud(): List<Speaker> {
            val name =
                arrayListOf("Manuel Ernesto", "Pawan Kumar")
            val talk = arrayListOf(
                "Build Rest API with Kotlin",
                "Getting Started With Flutter for Web"
            )
            val job = arrayListOf(
                "Kotlin and Firebase Developer",
                "Google Developer Expert, Flutter and Firebase"
            )

            val photo = arrayListOf(
                "https://avatars2.githubusercontent.com/u/8449402?s=400&u=6716f6cc9975fb2feecba22ed5d3aee66dffe5ec&v=4",
                "https://avatars1.githubusercontent.com/u/12619420?s=400&u=eac38b075e4e4463edfb0f0a8972825cf7803d4c&v=4"
            )
            val time = arrayListOf("10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM")
            val mSpeakers = ArrayList<Speaker>()

            for (i in 0 until name.size) {
                mSpeakers.add(
                    Speaker(
                        name[i],
                        talk[i],
                        job[i],
                        time[i],
                        photo[i]
                    )
                )
            }
            var database: DatabaseReference = Firebase.database.reference.child("speakers")
            val mSpeaker = ArrayList<Speaker>()
            database.addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (postSnapshot in snapshot.children) {
                        Speaker(
                            postSnapshot.child("name").value.toString(),
                            postSnapshot.child("shortBio").value.toString(),
                            postSnapshot.child("company").value.toString(),
                            postSnapshot.child("photoUrl").value.toString(),
                            postSnapshot.child("order").value.toString()

                        )


                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.w(TAG, "loadPost:onCancelled", error.toException())
                }

            })

            return mSpeakers
        }


        fun getSpeakrss(): List<Speaker> {
//            val name =
//                arrayListOf("Manuel Ernesto", "Pawan Kumar", "Pedro Massango", "Braulio Cassule")
//            val talk = arrayListOf(
//                "Build Rest API with Kotlin",
//                "Getting Started With Flutter for Web",
//                "Deep dive into Flutter",
//                "Introduction to Go Programming Language (GoLang)"
//            )
//            val job = arrayListOf(
//                "Kotlin and Firebase Developer",
//                "Google Developer Expert, Flutter and Firebase",
//                "Flutter Developer",
//                "Software Engineer"
//            )
//            val photo = arrayListOf(
//                "https://avatars2.githubusercontent.com/u/8449402?s=400&u=6716f6cc9975fb2feecba22ed5d3aee66dffe5ec&v=4",
//                "https://avatars1.githubusercontent.com/u/12619420?s=400&u=eac38b075e4e4463edfb0f0a8972825cf7803d4c&v=4",
//                "https://avatars2.githubusercontent.com/u/33294549?s=400&v=4r",
//                "https://avatars1.githubusercontent.com/u/20057010?s=400&v=4"
//            )

//            val time = arrayListOf("10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM")
            val mSpeakers = ArrayList<Speaker>()
            var database: DatabaseReference = Firebase.database.reference.child("speakers")
            database.addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (postSnapshot in snapshot.children) {
                        Speaker(
                            postSnapshot.child("name").value.toString(),
                            postSnapshot.child("shortBio").value.toString(),
                            postSnapshot.child("company").value.toString(),
                            postSnapshot.child("photoUrl").value.toString(),
                            postSnapshot.child("order").value.toString()

                        )
//                      name.add()
//                        Log.e("TTT",postSnapshot.child("name").value.toString())
//                        talk.add()
//                        job.add()
//                        photo.add()
//                        time.add()

//                        for (i in 0 until name.size) {
//                            mSpeakers.add(
//                                Speaker(
//                                    name[i],
//                                    talk[i],
//                                    job[i],
//                                    time[i],
//                                    photo[i]
//                                )
//                            )
//                        }

                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.w(TAG, "loadPost:onCancelled", error.toException())
                }

            })





            return mSpeakers
        }

        fun getTeam(): List<Speaker> {
            val name =
                arrayListOf("Manuel Ernesto", "Pedro Massango", "Braulio Cassule")
            val gdg = arrayListOf(
                "GDG Lubango",
                "GDG Luanda",
                "GDG Luanda"
            )
            val job = arrayListOf(
                "Kotlin and Firebase Developer",
                "Flutter Developer",
                "Software Engineer"
            )

            val photo = arrayListOf(
                "https://avatars2.githubusercontent.com/u/8449402?s=400&u=6716f6cc9975fb2feecba22ed5d3aee66dffe5ec&v=4",
                "https://avatars2.githubusercontent.com/u/33294549?s=400&v=4r",
                "https://avatars1.githubusercontent.com/u/20057010?s=400&v=4"
            )

            val mSpeakers = ArrayList<Speaker>()

            for (i in 0 until name.size) {
                mSpeakers.add(
                    Speaker(
                        name[i],
                        gdg[i],
                        job[i],
                        "",
                        photo[i]
                    )
                )
            }

            return mSpeakers
        }
    }
}


