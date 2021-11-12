package com.example.interoperability

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var edtN1: EditText
    private lateinit var edtN2: EditText
    private lateinit var edtResultado: EditText
    private lateinit var btnSuma: Button
    private lateinit var btnResta: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        edtN1= findViewById(R.id.edtN1)
        edtN2= findViewById(R.id.edtN2)
        edtResultado= findViewById(R.id.edtRestultado)
        btnSuma= findViewById(R.id.btnSuma)
        btnResta= findViewById(R.id.btnResta)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_search -> {
                Toast.makeText(this, R.string.text_action_search, Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_settings -> {
                Toast.makeText(this, R.string.text_action_settings, Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_logout -> {
                val intento = Intent(this, TodoActivity::class.java)
                startActivity(intento)
                /*
                Toast.makeText(this, R.string.text_action_logout, Toast.LENGTH_LONG).show()

                 */
                return true
            }
            else -> return super.onOptionsItemSelected(item)


        }

    }
    /*
    fun sumar(view: android.view.View) {
        var n1=edtN1.text.toString().toInt()
        var n2=edtN2.text.toString().toInt()
        var suma = n1+n2
        edtResultado.setText(""+suma)
    }

    fun restar(view: android.view.View) {
        var n1=edtN1.text.toString().toInt()
        var n2=edtN2.text.toString().toInt()
        var resta = n1-n2
        edtResultado.setText(""+resta)
    }

     */
    fun calcular(view: android.view.View) {
        var n1=edtN1.text.toString().toInt()
        var n2=edtN2.text.toString().toInt()
        when(view){
            btnSuma ->{
                var suma = n1+n2
                edtResultado.setText(""+suma)
            }
            btnResta ->{
                var resta = n1-n2
                edtResultado.setText(""+resta)
            }
        }

        /*
        if(view == btnSuma){
            var suma = n1+n2
            edtResultado.setText(""+suma)
        }else{
            var resta = n1-n2
            edtResultado.setText(""+resta)
        }

         */
    }

    fun onLogin(view: android.view.View) {
        val possitiveButton={
            dialog: DialogInterface, which: Int ->
            val intento = Intent(this, WelcomeActivity :: class.java  )
            intento.putExtra( "Username", edtN1.text.toString())
            startActivity(intento)

        }
        val negativeButton= { _: DialogInterface, _: Int ->}
        if (edtN1.text.toString().equals("9513")&& edtN2.text.toString().equals("1234")){
            var dialog = AlertDialog.Builder(this)
                .setTitle("Welcome")
                .setMessage("User: "+ edtN1.text.toString())
                .setPositiveButton("OK", possitiveButton)
                .setNegativeButton("Cancel",negativeButton)
                .create()
                .show()

        }else{
            Toast.makeText(this, R.string.text_error_text, Toast.LENGTH_LONG).show()
           /* var dialog =AlertDialog.Builder(this )
                .setTitle(R.string.text_error)
                .setMessage(R.string.text_error_text)
                .create()
                .show()
            */        }
    }

}