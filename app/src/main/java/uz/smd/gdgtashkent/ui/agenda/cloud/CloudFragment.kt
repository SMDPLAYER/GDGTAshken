package uz.smd.gdgtashkent.ui.agenda.cloud

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.smd.gdgtashkent.R
import uz.smd.gdgtashkent.adapter.AgendaAdapter
import uz.smd.gdgtashkent.data.Speaker
import uz.smd.gdgtashkent.util.Dummy
import uz.smd.gdgtashkent.util.loadData

class CloudFragment : Fragment() {
    companion object {
        fun newInstance() = CloudFragment()
    }

    private lateinit var viewModel: CloudViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cloud_fragment, container, false).apply {
            val recyclerView: RecyclerView = findViewById(R.id.rv_cloud)
            recyclerView.layoutManager = LinearLayoutManager(context)
            arguments?.takeIf { it.containsKey("position") }?.apply {
                when (getInt("position")) {
                    1 -> {
                        loadData {data->
                            var uid = "101"
                            Log.e("TTTSM","1"+uid)
                            var startTime = ""
                            var endTime = ""
                            var speaker = ""
                            var speakerPhoto = ""
                            var speakerName = ""
                            var mSpeakers = ArrayList<Speaker>()
                            for (schedules in data.child("schedule").children){
                                for (schedule in schedules.child("timeslots").children) {
                                startTime = schedule.child("startTime").value.toString()
                                endTime = schedule.child("endTime").value.toString()
                                Log.e("SSSS",endTime+startTime)
                                Log.e("TTTSM","2"+uid)
                                for (snapshot in schedule.child("sessions").children) {
                                    Log.e("TTTSM","3"+uid)
                                    for (snapshot in snapshot.child("items").children) {
                                        Log.e("TTTSM","4"+uid)
                                        uid = snapshot.value.toString()
//                                        for (session in data.child("sessions").child(uid).children) {
                                        if (data.child("sessions").child(uid).child("tags").child("0").value.toString()=="Cloud"){
                                            Log.e("TTTSM","7"+uid)
                                            speaker=data.child("sessions").child(uid).child("speakers").child("0").value.toString()

                                            Log.e("TTT",speaker)


                                            speakerName=data.child("speakers").child(speaker).child("name").value.toString()
                                            Log.e("TTM",speakerName)
                                            speakerPhoto=data.child("speakers").child(speaker).child("photoUrl").value.toString()
                                            Log.e("TTMW",speakerPhoto)
                                            Log.e("TTMW",endTime+startTime)
                                            mSpeakers.add(
                                                Speaker(
                                                    speakerName,
                                                    data.child("sessions").child(uid).child("title").value.toString(),
                                                    data.child("sessions").child(uid).child("complexity").value.toString(),
                                                    startTime,
                                                    speakerPhoto,
                                                    endTime

                                                )
                                            )
                                        }
                                        Log.e("TTTSM","5"+uid)
                                    }
                                }
                            }}
                            Log.e("TTTSM","6"+uid)
                       /*     for (session in data.child("sessions").child(uid).children) {
                                Log.e("TTTSM","7"+uid)
                                speaker=session.child("speakers").child("0").value.toString()
                                Log.e("TTT",speaker)


                                speakerName=data.child("speakers").child(speaker).child("name").value.toString()
                                Log.e("TTM",speakerName)
                                speakerPhoto=data.child("speakers").child(speaker).child("photoUrl").value.toString()
                                Log.e("TTMW",speakerPhoto)
                                Log.e("TTMW",endTime+startTime)
                                mSpeakers.add(
                                    Speaker(
                                        speakerName,
                                        session.child("title").value.toString(),
                                        session.child("complexity").value.toString(),
                                        startTime,
                                        speakerPhoto,
                                        endTime

                                    )
                                )
                            }*/
                            val adapter = AgendaAdapter(mSpeakers, context)
                            recyclerView.adapter = adapter
                        }
                    }
                    2->{
                        loadData {data->
                            var uid = "101"
                            Log.e("TTTSM","1"+uid)
                            var startTime = ""
                            var endTime = ""
                            var speaker = ""
                            var speakerPhoto = ""
                            var speakerName = ""
                            var mSpeakers = ArrayList<Speaker>()
                            for (schedules in data.child("schedule").children){

                                for (schedule in schedules.child("timeslots").children) {
                                startTime = schedule.child("startTime").value.toString()
                                endTime = schedule.child("endTime").value.toString()
                                Log.e("SSSS",endTime+startTime)
                                Log.e("TTTSM","2"+uid)
                                for (snapshot in schedule.child("sessions").children) {
                                    Log.e("TTTSM","3"+uid)
                                    for (snapshot in snapshot.child("items").children) {
                                        Log.e("TTTSM","4"+uid)
                                        uid = snapshot.value.toString()
//                                        for (session in data.child("sessions").child(uid).children) {
                                        if (data.child("sessions").child(uid).child("tags").child("0").value.toString()=="Android"){
                                            Log.e("TTTSM","7"+uid)
                                            speaker=data.child("sessions").child(uid).child("speakers").child("0").value.toString()

                                            Log.e("TTT",speaker)


                                            speakerName=data.child("speakers").child(speaker).child("name").value.toString()
                                            Log.e("TTM",speakerName)
                                            speakerPhoto=data.child("speakers").child(speaker).child("photoUrl").value.toString()
                                            Log.e("TTMW",speakerPhoto)
                                            Log.e("TTMW",endTime+startTime)
                                            mSpeakers.add(
                                                Speaker(
                                                    speakerName,
                                                    data.child("sessions").child(uid).child("title").value.toString(),
                                                    data.child("sessions").child(uid).child("complexity").value.toString(),
                                                    startTime,
                                                    speakerPhoto,
                                                    endTime

                                                )
                                            )
                                        }
                                        Log.e("TTTSM","5"+uid)
                                    }
                                }
                            }}
                            Log.e("TTTSM","6"+uid)
                            val adapter = AgendaAdapter(mSpeakers, context)
                            recyclerView.adapter = adapter
                        }
                    }
                    else -> {
                        loadData {data->
                            var uid = "101"
                            Log.e("TTTSM","1"+uid)
                            var startTime = ""
                            var endTime = ""
                            var speaker = ""
                            var speakerPhoto = ""
                            var speakerName = ""
                            var mSpeakers = ArrayList<Speaker>()
                            for (schedules in data.child("schedule").children){

                                for (schedule in schedules.child("timeslots").children) {
                                startTime = schedule.child("startTime").value.toString()
                                endTime = schedule.child("endTime").value.toString()
                                Log.e("SSSS",endTime+startTime)
                                Log.e("TTTSM","2"+uid)
                                for (snapshot in schedule.child("sessions").children) {
                                    Log.e("TTTSM","3"+uid)
                                    for (snapshot in snapshot.child("items").children) {
                                        Log.e("TTTSM","4"+uid)
                                        uid = snapshot.value.toString()
//                                        for (session in data.child("sessions").child(uid).children) {
                                        if (data.child("sessions").child(uid).child("tags").child("0").value.toString()=="Web"){
                                            Log.e("TTTSM","7"+uid)
                                            speaker=data.child("sessions").child(uid).child("speakers").child("0").value.toString()

                                            Log.e("TTT",speaker)


                                            speakerName=data.child("speakers").child(speaker).child("name").value.toString()
                                            Log.e("TTM",speakerName)
                                            speakerPhoto=data.child("speakers").child(speaker).child("photoUrl").value.toString()
                                            Log.e("TTMW",speakerPhoto)
                                            Log.e("TTMW",endTime+startTime)
                                            mSpeakers.add(
                                                Speaker(
                                                    speakerName,
                                                    data.child("sessions").child(uid).child("title").value.toString(),
                                                    data.child("sessions").child(uid).child("complexity").value.toString(),
                                                    startTime,
                                                    speakerPhoto,
                                                    endTime

                                                )
                                            )
                                        }
                                        Log.e("TTTSM","5"+uid)
                                    }
                                }
                            }}
                            Log.e("TTTSM","6"+uid)
                            val adapter = AgendaAdapter(mSpeakers, context)
                            recyclerView.adapter = adapter
                        }
                    }
                }

            }

        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CloudViewModel::class.java)
    }

}
