package br.senai.sp.jandira.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//mainActivity herda appCompatActivity
class MainActivity : AppCompatActivity() {
    //indicando onCreate da class Main "override fun"
    override fun onCreate(savedInstanceState: Bundle?) {
        //chamando onCreate da classe Mãe também
        super.onCreate(savedInstanceState)
        //chamando metodo para setar nosso layout activity_main
        setContentView(R.layout.activity_main)

        //criando instancia das views que serão manipuilados
        val editTextPeso = findViewById<EditText>(R.id.edit_peso)
        val editTextAltura = findViewById<EditText>(R.id.edit_altura)
        val buttonCalcular = findViewById<Button>(R.id.button_calcular)
        val textViewResultado = findViewById<TextView>(R.id.text_view_resultado)

        //adcionando ouvinte de click no botão
        buttonCalcular.setOnClickListener {
            //verificando campos vazios "isEmpty()"
            if(editTextPeso.text.isEmpty()){
                editTextPeso.error = "Peso é obrigatório"
            }
            else if(editTextAltura.text.isEmpty()){
                editTextAltura.error = "Altura é obrigatório"
            }
            else {
                //extraindo editable do editPeso, convertendo em string, depois para int e armazenando na variavel peso
                val peso = editTextPeso.text.toString().toInt()
                val altura = editTextAltura.text.toString().toDouble()
                //calculando
                val imc = peso / (altura * altura)
                //atribuindo imc(convertido para String e limitado a uma casa decimal) ao texto do textView
                textViewResultado.text = String.format("%.1f", imc)
            }
        }
    }
}