package com.example.e_learning

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//  Fungsi Button Tanggal dan Waktu
        val btnPickDate = findViewById<Button>(R.id.btnPickDate)
        val btnPickTime = findViewById<Button>(R.id.btnPickTime)


        btnPickDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val datePicker = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    Toast.makeText(
                        this,
                        "Tanggal: $dayOfMonth/${month + 1}/$year",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }

        btnPickTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val timePicker = TimePickerDialog(
                this,
                { _, hourOfDay, minute ->
                    Toast.makeText(this, "Waktu: $hourOfDay:$minute", Toast.LENGTH_SHORT).show()
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            )
            timePicker.show()
        }

        val btnShowAlert = findViewById<Button>(R.id.btnShowAlert)

        btnShowAlert.setOnClickListener {
            showAlertDialog()
        }
    }

        private fun showAlertDialog() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Peringatan")
            builder.setMessage("Kamu yakin mau melanjutkan?")
            builder.setPositiveButton("Ya") { dialog, _ ->
                // Aksi kalau user pilih "Ya"
                dialog.dismiss()
            }
            builder.setNegativeButton("Tidak") { dialog, _ ->
                // Aksi kalau user pilih "Tidak"
                dialog.dismiss()
            }
            builder.show()
    }
}