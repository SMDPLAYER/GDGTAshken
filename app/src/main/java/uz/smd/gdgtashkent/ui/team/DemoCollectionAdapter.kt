package uz.smd.gdgtashkent.ui.team

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.smd.gdgtashkent.ui.agenda.cloud.CloudFragment

class DemoCollectionAdapter(fragment: Fragment,val count:Int=2) : FragmentStateAdapter(fragment) {
lateinit var fragment: Fragment
    override fun getItemCount(): Int = count

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)

        fragment = if (count==2)
            TeamFragment()
        else
            CloudFragment()
        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putInt("position", position + 1)
        }
        return fragment
    }
}