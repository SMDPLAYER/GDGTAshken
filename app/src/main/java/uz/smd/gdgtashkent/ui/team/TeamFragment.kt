package uz.smd.gdgtashkent.ui.team

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import uz.smd.gdgtashkent.adapter.GeneralAdapter
import uz.smd.gdgtashkent.R
import uz.smd.gdgtashkent.data.Speaker

import uz.smd.gdgtashkent.util.loadData
import java.util.ArrayList

class TeamFragment : Fragment() {

    companion object {
        fun newInstance() = TeamFragment()
    }

    private lateinit var viewModel: TeamViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.team_fragment, container, false).apply {
            val recyclerView: RecyclerView = findViewById(R.id.rv_team)
            recyclerView.layoutManager = LinearLayoutManager(context)
            arguments?.takeIf { it.containsKey("position") }?.apply {
                when (getInt("position")) {
                    1 -> {   loadData {

                        var mSpeakers = ArrayList<Speaker>()
                        for (postSnapshot in it.child("team").child("0").child("members").children) {
                            mSpeakers.add( Speaker(
                                postSnapshot.child("name").value.toString(),
                                postSnapshot.child("title").value.toString(),
                                "Core Team",
                                postSnapshot.child("order").value.toString(),
                                postSnapshot.child("photoUrl").value.toString()

                            )
                            )
                        }
                        val adapter = GeneralAdapter(mSpeakers, context)
                        recyclerView.adapter = adapter
                    }}
                    else -> {   loadData {
                        var mSpeakers = ArrayList<Speaker>()
                        for (postSnapshot in it.child("team").child("1").child("members").children) {
                            mSpeakers.add( Speaker(
                                postSnapshot.child("name").value.toString(),
                                postSnapshot.child("title").value.toString(),
                                "Program Committee",
                                postSnapshot.child("order").value.toString(),
                                postSnapshot.child("photoUrl").value.toString()

                            )
                            )
                        }
                        val adapter = GeneralAdapter(mSpeakers, context)
                        recyclerView.adapter = adapter
                    }}
                }

            }




        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TeamViewModel::class.java)
    }

}
