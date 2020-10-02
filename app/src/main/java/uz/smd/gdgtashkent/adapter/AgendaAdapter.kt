package uz.smd.gdgtashkent.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import uz.smd.gdgtashkent.R
import uz.smd.gdgtashkent.data.Speaker
import uz.smd.gdgtashkent.util.getDate
import uz.smd.gdgtashkent.util.getDateDiff
import java.text.SimpleDateFormat
import kotlin.random.Random

class AgendaAdapter(private val mSpeakers: List<Speaker>, val context: Context) :
    RecyclerView.Adapter<AgendaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.agenda_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = mSpeakers.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val speaker = mSpeakers[position]
        holder.bind(speaker)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.txt_name)
        var talk: TextView = itemView.findViewById(R.id.txt_talk)
        var job: TextView = itemView.findViewById(R.id.txt_job)
        var duration: TextView = itemView.findViewById(R.id.txt_duraction)
        var time: TextView = itemView.findViewById(R.id.txt_time)
        var photo: CircleImageView = itemView.findViewById(R.id.photo)


        fun bind(speaker: Speaker) {
            name.text = speaker.name
            talk.text = speaker.talk
            job.text = speaker.job



            duration.text =  getDate(speaker.endTime,speaker.time)
//                getDateDiff(SimpleDateFormat("dd/M/yyyy hh:mm:ss"), "09/09/2016 "+speaker.time+":00", "09/09/2016 "+speaker.endTime+":00")
            time.text = speaker.time
            Glide.with(context).load(speaker.photo).into(photo)
            setRandomColor()
        }

        private fun setRandomColor() {
            val colors = arrayListOf(
                R.color.colorAmber,
                R.color.colorRed,
                R.color.colorBlue,
                R.color.colorGreen
            )
            val p = Random.nextInt(colors.size)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                name.setTextColor(context.resources.getColor(colors[p], null))
            }
        }
    }
}