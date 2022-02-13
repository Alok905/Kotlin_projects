package alok.ranjan.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById<Button>(R.id.mybutton)
        btnDatePicker.setOnClickListener { v->
            clickDatePicker(v)
        }

    }

    fun clickDatePicker(v: View){
        /*
            the year, month and day decides the display of the year, month and day respectively
            after opening of the calendar(date picker box)...for example..
            if we set year = 1950, month = 4 and day = 27 then after the opening of calander the
            selected date will be "27 May 1950" .... however we can select the date of our wish
         */
        val myCalendar = Calendar.getInstance()
        val year: Int = myCalendar.get(Calendar.YEAR)
        val month: Int = myCalendar.get(Calendar.MONTH)
        val day: Int = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
            {
                v, selectedYear, selectedMonth, selectedDayOfMonth ->

                Toast.makeText(this,"Date selected successfully...", Toast.LENGTH_SHORT).show()

                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                val tvSelectedDate = findViewById<TextView>(R.id.selecteddate)
                tvSelectedDate.setText(selectedDate)

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val selDateInFormat = sdf.parse(selectedDate)
                val selDateInMinutes = selDateInFormat!!.time / (1000 * 60)
                /*
                    /*
                        Because we have already the present day, month and year so we can diectly use it
                    */
                    val currentDate = "$day/${month + 1}/$year"
                    val currentDateInFormat = sdf.parse(currentDate)
                    val currentDateInMinutes = currentDateInFormat!!.time / 60000

                    (or)
                */

                val currentDateInFormat = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinutes = currentDateInFormat!!.time / (1000 * 60)


                val difference = currentDateInMinutes - selDateInMinutes
                val ageInMinutes = findViewById<TextView>(R.id.selecteddateinminutes)
                ageInMinutes.text = difference.toString()
            },
            year,
            month,
            day)






        dpd.datePicker.setMaxDate(Date().time - (24 * 3600000))
        dpd.show()

    }



}
/*
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById<Button>(R.id.mybutton)
        btnDatePicker.setOnClickListener { v ->
            clickDatePicker(v)
        }

    }

    fun clickDatePicker(v: View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                v, selectedYear, selectedMonth, selectedDayOfMonth ->

                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                val selecteddate = findViewById<TextView>(R.id.selecteddate)
                selecteddate.setText(selectedDate)

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val selectedDateInFormat = sdf.parse(selectedDate)
                val selectedDateInMinutes = selectedDateInFormat.time / 60000

//                val currentDateInFormat = sdf.parse(sdf.format(System.currentTimeMillis()))
//                val currentDateInMinutes = currentDateInFormat.time / 60000

                val currentDate = "$day/${month + 1}/$year"
                val currentDateInFormat = sdf.parse(currentDate)
                val currentDateInMinutes = currentDateInFormat.time / 60000

                val difference = currentDateInMinutes - selectedDateInMinutes

                val ageInMinutes = findViewById<TextView>(R.id.selecteddateinminutes)
                ageInMinutes.setText(difference.toString())
        }, year,
        month,
        day)

        dpd.datePicker.setMaxDate(Date().time - (1000 * 60 * 60 * 24))
        dpd.show()

    }


}

 */