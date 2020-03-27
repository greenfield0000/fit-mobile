package com.example.fit_mobile.activities.client

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TabHost
import androidx.appcompat.app.AppCompatActivity
import com.example.fit_mobile.R
import kotlinx.android.synthetic.main.activity_client_info.*
import java.util.*


class ClientInfoActivity : AppCompatActivity() {

    lateinit var picker: DatePickerDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_info)
        tabhost.setup()

        // Регистрация табов
        registryNewTabWithTabHost(tabhost, "tag1", R.id.tab1, "Информация")
        registryNewTabWithTabHost(tabhost, "tag2", R.id.tab2, "Тренировка")
        registryNewTabWithTabHost(tabhost, "tag3", R.id.tab3, "Питание")


        // Регистрация обработчиков формы
        registryListenerActivity()
    }

    /**
     * Метод регистрации слушателей всевозможных кнопочек формы
     */
    private fun registryListenerActivity() {
        // все что связано с дата пикером "Дата рождения"
        registryBirthDayDatePicker()
    }

    /**
     * Настройка выбора календаря "Дата рождения"
     */
    @SuppressLint("SetTextI18n")
    private fun registryBirthDayDatePicker() {
        client_birthdaty_text.inputType = InputType.TYPE_NULL
        client_birthdaty_text.setTextIsSelectable(true);

        val calendar: Calendar = Calendar.getInstance()
        val day: Int = calendar.get(Calendar.DAY_OF_MONTH)
        val month: Int = calendar.get(Calendar.MONTH)
        val year: Int = calendar.get(Calendar.YEAR)

        // date picker dialog
        picker = DatePickerDialog(
            this,
            OnDateSetListener { it, year, monthOfYear, dayOfMonth ->
                client_birthdaty_text.setText(
                    dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year
                )
            },
            year,
            month,
            day
        )
        // TODO сменить вид календаря. Сделать выбор даты на скролах
        picker.datePicker.setCalendarViewShown(false)
        picker.datePicker.setSpinnersShown(true)

        client_birthdaty_text.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                hideKeyBoard(view = view, hasFocus = !hasFocus)
                picker.show()
            }
        }

        client_birthdaty_text.setOnClickListener {
            val currentFocus = picker.currentFocus
            if (!picker.isShowing && currentFocus != null && currentFocus.isFocused)
                picker.show()
        }
    }

    /**
     * Скритие клавиатуры для view
     */
    private fun hideKeyBoard(view: View, hasFocus: Boolean = true) {
        // hide virtual keyboard
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(
            view.windowToken,
            if (hasFocus) InputMethodManager.RESULT_UNCHANGED_SHOWN else InputMethodManager.RESULT_UNCHANGED_HIDDEN
        )
    }

    /**
     * Регистрация новой вкладки
     */
    private fun registryNewTabWithTabHost(
        tabHost: TabHost,
        tag: String,
        id: Int,
        indicatorName: String
    ) {
        val spec = tabHost.newTabSpec(tag)
        spec.setContent(id)
        spec.setIndicator(indicatorName)
        tabHost.addTab(spec)
    }
}
