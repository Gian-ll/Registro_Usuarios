package com.example.almacentienda

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización manual (para propósitos de este ejemplo sencillo)
        val database = AppDatabase.getDatabase(this)
        val repository = UserRepository(database.userDao())
        val viewModel = UserViewModel(repository)

        val btn = findViewById<Button>(R.id.btnSave)
        val input = findViewById<EditText>(R.id.etUserName)
        val status = findViewById<TextView>(R.id.tvStatus)

        // Acción del botón
        btn.setOnClickListener {
            viewModel.onSaveUser(input.text.toString())
        }

        // Observamos el resultado
        viewModel.resultMessage.observe(this) { mensaje ->
            status.text = mensaje
        }

    }
}