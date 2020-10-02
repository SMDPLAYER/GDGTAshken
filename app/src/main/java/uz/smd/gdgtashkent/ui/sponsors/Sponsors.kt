package uz.smd.gdgtashkent.ui.sponsors

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.sponsors_fragment.*
import uz.smd.gdgtashkent.R
import uz.smd.gdgtashkent.adapter.SponsorAdapter
import uz.smd.gdgtashkent.data.Sponsor
import uz.smd.gdgtashkent.util.loadData
import java.util.ArrayList

class Sponsors:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sponsors_fragment, container, false).apply {
            val recyclerView: RecyclerView = findViewById(R.id.sponsorList)
            recyclerView.layoutManager = LinearLayoutManager(context)
        loadData{
            var mSpeakers = ArrayList<Sponsor>()
            for (postSnapshot in it.child("partners").children) {
                for (snapshot in postSnapshot.child("logos").children) {
                    mSpeakers.add( Sponsor(
                        snapshot.child("logoUrl").value.toString(),
                        snapshot.child("name").value.toString(),
                        snapshot.child("order").value.toString(),
                        snapshot.child("url").value.toString()))
                }

            }
            val adapter = SponsorAdapter(mSpeakers, context)
            adapter.setOnItemClickListener {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse(it.url)
                startActivity(openURL)
            }
            recyclerView.adapter = adapter
        }
    }}

}