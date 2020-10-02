package uz.smd.gdgtashkent.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

import uz.smd.gdgtashkent.R
import uz.smd.gdgtashkent.data.Sponsor
import uz.smd.gdgtashkent.util.SingleBlock
import uz.smd.gdgtashkent.util.Utils


class SponsorAdapter(private val mSpeakers: List<Sponsor>, val context: Context) :
    RecyclerView.Adapter<SponsorAdapter.ViewHolder>() {
    private var listenerItem: SingleBlock<Sponsor>? = null
    fun setOnItemClickListener(block: SingleBlock<Sponsor>) {
        listenerItem = block}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_sponsor, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = mSpeakers.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val speaker = mSpeakers[position]
        holder.bind(speaker)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.organiser_name)
        var talk: TextView = itemView.findViewById(R.id.organisation_introduction)
        var photo: ImageView = itemView.findViewById(R.id.organiser_photo)
        var sponsorWeb :CardView= itemView.findViewById(R.id.organiser_card)


        fun bind(speaker: Sponsor) {
            sponsorWeb.setOnClickListener{ listenerItem?.invoke(speaker) }
            name.text = speaker.name
            talk.text = speaker.url
            Utils.fetchSvg(context, speaker.logoUrl, photo)
//            Glide.with(context).load(speaker.logoUrl).into(photo)

        }


    }
}