package uz.smd.gdgtashkent.ui.agenda

import android.os.Build
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable

import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.agenda_fragment.*


import uz.smd.gdgtashkent.R
import uz.smd.gdgtashkent.ui.team.DemoCollectionAdapter

class AgendaFragment : Fragment(R.layout.agenda_fragment) {
    private lateinit var demoCollectionAdapter: DemoCollectionAdapter
    private lateinit var viewPager: ViewPager2
    companion object {
        fun newInstance() = AgendaFragment()
    }

    private lateinit var viewModel: AgendaViewModel
    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager2



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        demoCollectionAdapter = DemoCollectionAdapter(this,3)
        viewPager = view.findViewById(R.id.viewpager)
        viewPager.adapter = demoCollectionAdapter
        TabLayoutMediator(tabs_agenda, viewPager) { tab, position ->
            when(position){
                0->{tab.text = "Cloud"

                tab.icon=getDrawable(requireContext(),R.drawable.ic_cloud)

                }
                1->{tab.text = "Mobile"
                    tab.icon=getDrawable(requireContext(),R.drawable.ic_phone)
                }
                else-> {tab.text="web & more"
                    tab.icon=getDrawable(requireContext(),R.drawable.ic_chrome)}

            }
        }.attach()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AgendaViewModel::class.java)

    }

/*//    private fun setupViewPager(viewPager: ViewPager) {
//
//    }

//    class ViewPagerAdapter(fm: FragmentManager) :
//        FragmentPagerAdapter(fm) {
//
//        private val mFragmentList: ArrayList<Fragment> = ArrayList()
//        private val mFragmentTitle: ArrayList<String> = ArrayList()
//
//        override fun getItem(position: Int) = mFragmentList[position]
//
//        override fun getCount() = mFragmentList.size
//
//        override fun getPageTitle(position: Int) = mFragmentTitle[position]
//
//
//        fun addFragment(fragment: Fragment, title: String) {
//            mFragmentList.add(fragment)
//            mFragmentTitle.add(title)
//        }
//
//    }*/
}
