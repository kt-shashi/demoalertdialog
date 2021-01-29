package com.shashi.alertdialog

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
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

        //For custom alert dialog
        binding.btnShowCustomAlert.setOnClickListener {
            showCustomAlertDialog()
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
            android.R.style.Theme_Material_Light_NoActionBar_Fullscreen
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

    //For custom alert dialog
    private fun showCustomAlertDialog() {

        val builder = AlertDialog.Builder(this)

        val view: View = layoutInflater.inflate(R.layout.custom_alert_layout, null)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()

        val btnLater: Button = view.findViewById(R.id.btnLater)
        btnLater.setOnClickListener {
            showMessage("Job ke sath UPSC ka preparation karlo.")
            dialog.dismiss()
        }
        val btnNo: Button = view.findViewById(R.id.btnNo)
        btnNo.setOnClickListener {
            showMessage("Very good. Waise shadi ka kya soche?")
            dialog.dismiss()
        }
        val btnYes: Button = view.findViewById(R.id.btnYes)
        btnYes.setOnClickListener {
            showMessage("Galat dost bana liye ho lagta hai!")
            dialog.dismiss()
        }

    }

    //To display message using Snackbar
    private fun showMessage(message: String) {
        Snackbar.make(binding.rootView, message, Snackbar.LENGTH_LONG).show()
    }

}