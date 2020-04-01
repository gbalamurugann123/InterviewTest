package com.android.form

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.form.adapter.PageAdapter
import com.android.form.utils.SingletonJSONReader
import com.google.gson.Gson
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var recyclerViewControl: RecyclerView? = null
    private var mAdapter: PageAdapter? = null

    internal var next: Button ? = null
    internal var back: Button? = null
    internal var submit: Button? = null

    internal var currentPage: Int = 0
    internal var singletonJSONReader: SingletonJSONReader? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentPage = intent.getIntExtra("PAGE_ID", 0)

        next = findViewById(R.id.btnNext)
        back = findViewById(R.id.btnBack)
        submit = findViewById(R.id.btnSubmit)

        next!!.setOnClickListener(this)
        back!!.setOnClickListener(this)
        submit!!.setOnClickListener(this)

        singletonJSONReader = SingletonJSONReader.getInstance(this)

        Log.d("msg", singletonJSONReader.toString())

        recyclerViewControl = findViewById<View>(R.id.rv_item) as RecyclerView
        val mLayoutManagerHistory = LinearLayoutManager(applicationContext)
        recyclerViewControl!!.layoutManager = mLayoutManagerHistory
        recyclerViewControl!!.itemAnimator = DefaultItemAnimator()

        mAdapter = PageAdapter(singletonJSONReader!!.formModel!!.page[currentPage].controls, this)
        recyclerViewControl!!.adapter = mAdapter

        setUpButtons()

        try {
            val toolbar = supportActionBar
            toolbar!!.title = singletonJSONReader!!.formModel!!.page[currentPage].title


        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun setUpButtons() {

        if (singletonJSONReader!!.formModel!!.page.size > currentPage + 1)
            submit!!.visibility = View.GONE
        else
            submit!!.visibility = View.VISIBLE
    }

    private fun save() {

        val gson =  GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        val json: String = gson.toJson(singletonJSONReader!!.formModel)
        Log.d("JSON",json)

    }

    private fun nextPage() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.putExtra("PAGE_ID", currentPage + 1)
        startActivity(intent)
    }

    private fun validatePage(): Boolean {

        val controlList = singletonJSONReader!!.formModel!!.page[currentPage].controls

        for (c in controlList) {
            if (c.required!! && (c.apiValue == null || c.apiValue.trim { it <= ' ' }.isEmpty()))
                return showError("Please Enter " + c.label)
            else if (c.required!! && c.type.equals("text",true) && !(c.minLength <= c.apiValue.trim { it <= ' ' }.length && c.maxLength >= c.apiValue.trim { it <= ' ' }.length))
                return showError(c.label + " value length should between " + c.minLength + " to " + c.maxLength)
            else if (c.required!! && c.type.equals("text",true) && c.regex != null && !c.regex.isEmpty() && !c.apiValue.trim { it <= ' ' }.matches(c.regex.toRegex()))
                return showError("Please Enter valid format for " + c.label)
        }

        return true
    }

    private fun showError(error: String): Boolean {
        Toast.makeText(this@MainActivity, error, Toast.LENGTH_LONG).show()
        return false
    }


    override fun onClick(view: View) {

        view.isFocusableInTouchMode = true
        view.isFocusable = true
        view.requestFocus()

        when (view.id) {
            R.id.btnBack -> {
                finish()
            }
            R.id.btnNext -> {
                if (validatePage())
                    nextPage()
            }
            R.id.btnSubmit -> if (validatePage())
                save()
        }

    }


}
