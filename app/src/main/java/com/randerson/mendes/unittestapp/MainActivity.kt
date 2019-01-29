package com.randerson.mendes.unittestapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //identificando elementos view
        val btn = findViewById<Button>(R.id.btn_cadastrar)
        val txt_name= findViewById<EditText>(R.id.txt_nome)
        val txt_email = findViewById<EditText>(R.id.txt_email)
        val txt_senha = findViewById<EditText>(R.id.txt_senha)


        btn.setOnClickListener{
            val name_size = txt_name.length() //tamanho da string inserida


            var buider = AlertDialog.Builder(this)

            buider.setTitle("Erro!")

            //validando nome (no mínimo 3 caracteres)
            if(name_size < 3) {
                buider.setMessage("O nome precisa ser no mínimo 3 caracteres" +
                        "\nO nome digitado possui apenas $name_size")
            }

            //validando o email

            //transforma a string em um vetor de caracteres
            val chars = txt_email.text.toString().toCharArray()
            var msg = ""
            //o i representa um caractere que vai varrer a string inserida na caixa de email
            for (i in chars.iterator()) {

                //se o i não encontrar o @ o email será inválido!!
                if(i != '@'){
                   msg = "E-mail inválido"
                } else {
                    buider.setTitle("")
                    msg="Ok"
                    break
                }
            }
            buider.setMessage(msg)

            //validando senha
            val password_size = txt_senha.length() //tamanho da string inserida
            val nums = listOf<Char>('0', '1', '2', '3', '4', '5', '6', '7','8', '9')
            var cont = 0

            val password_chars = txt_senha.text.toString().toCharArray()

            /*
            * se a senha conter uma sequencia de 2 números a senha será invalidada*/
            for(i in password_chars.iterator()){

                if(i in nums){
                    cont++

                    if(cont == 2 || password_size < 4)
                        buider.setMessage("Senha inválida(pode conter sequencias numéricas ou ter " +
                                "menos de 4 caracteres)")
                } else
                    cont = 0

            }


          //buider.setMessage("" + nums)

            // Finally, make the alert dialog using builder
            val dialog: AlertDialog = buider.create()

            // Display the alert dialog on app interface
            dialog.show()
        }
    }


}
