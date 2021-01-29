package com.shashi.alertdialog

import android.R
import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.shashi.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //For alert dialog
        binding.btnShowAlert.setOnClickListener {
            showAlertDialog()
        }

        //For full screen alert dialog
        binding.btnShowFullScreenAlert.setOnClickListener {
            showFullScreenAlertDialog()
        }

    }

    //For alert dialog
    private fun showAlertDialog() {

        val builder = MaterialAlertDialogBuilder(this)

        builder
            .setTitle("Conversation with RELATIVES")
            .setMessage("Shashi, are you thinking of following your passion?")
            .setCancelable(false)
            .setNeutralButton("Later") { dialogInterface, buttonId ->
                showMessage("Job ke sath UPSC ka preparation karlo.")
            }
            .setNegativeButton("No") { dialogInterface, buttonId ->
                showMessage("Very good. Waise shadi ka kya soche?")
            }
            .setPositiveButton("Yes") { dialogInterface, buttonId ->
                showMessage("Galat dost bana liye ho lagta hai!")
            }

        val dialog = builder.create()
        dialog.show()

    }

    //For full screen alert dialog
    private fun showFullScreenAlertDialog() {

        val builder = AlertDialog.Builder(
            this,
            R.style.Theme_Material_Light_NoActionBar_Fullscreen
        )

        builder
            .setTitle("Conversation with RELATIVES")
            .setMessage("Shashi, are you thinking of following your passion?")
            .setCancelable(false)
            .setNeutralButton("Later") { dialogInterface, buttonId ->
                showMessage("Job ke sath UPSC ka preparation karlo.")
            }
            .setNegativeButton("No") { dialogInterface, buttonId ->
                showMessage("Very good. Waise shadi ka kya soche?")
            }
            .setPositiveButton("Yes") { dialogInterface, buttonId ->
                showMessage("Galat dost bana liye ho lagta hai!")
            }

        val dialog = builder.create()
        dialog.show()

    }

    //To display message using Snackbar
    private fun showMessage(message: String) {
        Snackbar.make(binding.rootView, message, Snackbar.LENGTH_LONG).show()
    }

}