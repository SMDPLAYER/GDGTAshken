package uz.smd.gdgtashkent.ui.speakers

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

import uz.smd.gdgtashkent.adapter.GeneralAdapter
import uz.smd.gdgtashkent.R
import uz.smd.gdgtashkent.data.Speaker
import uz.smd.gdgtashkent.util.loadData
import java.util.ArrayList

class SpeakersFragment : Fragment() {
  private  var database: DatabaseReference = Firebase.database.reference.child("speakers")

    companion object {
        fun newInstance() = SpeakersFragment()
    }

    private lateinit var viewModel: SpeakersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.speakers_fragment, container, false).apply {
            val recyclerView: RecyclerView = findViewById(R.id.rv_speakers)
            recyclerView.layoutManager = LinearLayoutManager(context)

            loadData{
                var mSpeakers = ArrayList<Speaker>()
                for (postSnapshot in it.child("speakers").children) {
                    mSpeakers.add( Speaker(
                        postSnapshot.child("name").value.toString(),
                        postSnapshot.child("shortBio").value.toString(),
                        postSnapshot.child("company").value.toString(),
                        postSnapshot.child("order").value.toString(),
                        postSnapshot.child("photoUrl").value.toString()

                    ))
                }
                val adapter = GeneralAdapter(mSpeakers, context)
                recyclerView.adapter = adapter
            }


        }
    }





}
