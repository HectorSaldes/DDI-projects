package com.utez.edu.activitysix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.utez.edu.activitysix.databinding.ActivityMainItemContentBinding

class MainActivityItemContent : AppCompatActivity() {

    companion object {
        const val KEY_ITEM = "item"
        const val KEY_TITLE = "title"
        const val KEY_DESCRIPTION = "description"
        const val INPUT_CHARACTER_ERROR = "El campo contiene carácteres especiales"
        const val INPUT_EMPTY_ERROR = "El campo no debe estar vacío"
        const val DATA_LOAD_ERROR = "Ocurrió un fallo al guardar los datos"
        const val INPUT_CHECK_ERROR = "Verifica los campos de texto"
    }

    private lateinit var binding: ActivityMainItemContentBinding
    private lateinit var db: FirebaseFirestore
    private lateinit var menuItem: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainItemContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = Firebase.firestore
        menuItem = intent.extras?.getString(KEY_ITEM).toString()
        binding.txtTitle.text = "Nuevo en $menuItem"
        binding.btnCreateMenu.setOnClickListener { validateInputs() }
    }

    fun validateInputs() {
        val flag1 = validateInput(binding.etTitle)
        val flag2 = validateInput(binding.etDescription)
        if (flag1 && flag2)
            onLoadDocumentToFirebase()
        else makeSnackbar(INPUT_CHECK_ERROR)
    }

    fun onLoadDocumentToFirebase() {
        val title = binding.etTitle.editText?.text.toString().trim()
        val description = binding.etDescription.editText?.text.toString().trim()
        val item: HashMap<String, String> = hashMapOf(
            KEY_TITLE to title,
            KEY_DESCRIPTION to description
        )
        db.collection(menuItem).add(item)
            .addOnSuccessListener { finish() }
            .addOnFailureListener { makeSnackbar(DATA_LOAD_ERROR) }
    }

    fun isLoading(flag:Boolean){
        if(flag){
            binding.pgbIndicator.visibility = View.VISIBLE
            binding.btnCreateMenu.isEnabled = false
            binding.etTitle.isEnabled = false
            binding.etDescription.isEnabled = false
        }else{
            binding.pgbIndicator.visibility = View.INVISIBLE
            binding.btnCreateMenu.isEnabled = true
            binding.etTitle.isEnabled = true
            binding.etDescription.isEnabled = true
        }
    }

    fun validateInput(input: TextInputLayout): Boolean {
        val validates = Regex("^[A-Za-z-0-9 _áéíóúÁÉÍÓÚñÑ]*$")
        val text = input.editText?.text
        if (!text.isNullOrEmpty())
            if (text.matches(validates)) {
                input.error = null
                return true
            } else input.error = INPUT_CHARACTER_ERROR
        else input.error = INPUT_EMPTY_ERROR
        return false
    }

    fun makeSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }

}