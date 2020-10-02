package uz.smd.gdgtashkent.ui.home

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController

import uz.smd.gdgtashkent.R

class HomeViewModel : ViewModel() {


    fun goToAgenda(view: View) {
        view.findNavController().navigate(R.id.agendaFragment)
    }
    fun goToMaps(view: View) {
        view.findNavController().navigate(R.id.mapViewFragment)
    }
    fun goToSponsors(view: View) {
        view.findNavController().navigate(R.id.sponsors)
    }

    fun goToTeam(view: View) {
        view.findNavController().navigate(R.id.teamsFragment)
    }


    fun goToSpeakers(view: View) {
        view.findNavController().navigate(R.id.speakersFragment)
    }
    fun goToFaqs(view: View) {
        view.findNavController().navigate(R.id.faqsFragment)
    }

    fun openFacebook(view: View) {
        val url = view.context.getString(R.string.urlFacebook)
        loadUrl(view, url)
    }


    fun openTwitter(view: View) {
        val url = view.context.getString(R.string.urlTwitter)
        loadUrl(view, url)
    }

    fun openLinkedin(view: View) {
        val url = view.context.getString(R.string.urlLinkedin)
        loadUrl(view, url)
    }

    fun openYoutube(view: View) {
        val url = view.context.getString(R.string.urlYoutube)
        loadUrl(view, url)
    }

    fun openMeetup(view: View) {
        val url = view.context.getString(R.string.urlMeetup)
        loadUrl(view, url)
    }

    fun sendEmail(view: View) {

        Intent(
            Intent.ACTION_SENDTO, Uri
                .parse("mailto:${view.context.getString(R.string.txt_email)}")
        ).also {
            it.putExtra(Intent.EXTRA_SUBJECT, view.context.getString(R.string.txt_subject))
            it.putExtra(Intent.EXTRA_TEXT, view.context.getString(R.string.txt_body))
            view.context.startActivity(it)
        }
    }

    private fun loadUrl(view: View, url: String) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also {
            view.context.startActivity(it)
        }

    }
}
