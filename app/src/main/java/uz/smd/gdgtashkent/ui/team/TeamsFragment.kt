package uz.smd.gdgtashkent.ui.team

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.teams_fragment.*
import uz.smd.gdgtashkent.R

class TeamsFragment : Fragment(R.layout.teams_fragment) {

    private lateinit var demoCollectionAdapter: DemoCollectionAdapter
    private lateinit var viewPager: ViewPager2
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        demoCollectionAdapter = DemoCollectionAdapter(this)
        viewPager = view.findViewById(R.id.viewpagerTeam)
        viewPager.adapter = demoCollectionAdapter
        TabLayoutMediator(tabs_team, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Core Team"
                else -> tab.text = "Program Committee"
            }
        }.attach()
    }
}



