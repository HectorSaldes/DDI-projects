package com.utez.edu.activitysix

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.utez.edu.activitysix.databinding.ActivityMainNewMenuBinding
import java.io.ByteArrayOutputStream
import java.util.*
import kotlin.collections.HashMap


class MainActivityNewMenu : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE = 100
        const val IMAGES = "images"
        const val IMAGE_TYPE = "image/*"
        const val IMAGE_LOAD_ERROR = "Ocurrió un error al subir la imagen"
        const val IMAGE_LOAD_SUCCESS = "Imagen subida correctamente"
        const val DATA_LOAD_ERROR = "Ocurrió un fallo al guardar los datos"
        const val INPUT_CHARACTER_ERROR = "El campo contiene carácteres especiales"
        const val INPUT_EMPTY_ERROR = "El campo no debe estar vacío"
    }

    private lateinit var binding: ActivityMainNewMenuBinding
    private lateinit var db: FirebaseFirestore
    private lateinit var storage: FirebaseStorage
    private lateinit var storageRef: StorageReference
    private var successImage: Boolean = false
    private var successInput: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainNewMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = Firebase.firestore
        storage = Firebase.storage
        storageRef = storage.reference
        binding.btnNewImageMenu.setOnClickListener { selectNewImage() }
        binding.btnCreateMenu.setOnClickListener { createNewMenu() }
    }

    fun selectNewImage() {
        val intent: Intent = Intent(Intent.ACTION_PICK)
        intent.type = IMAGE_TYPE
        startActivityForResult(intent, REQUEST_CODE)
    }

    fun createNewMenu() {
        successInput = validateInput()
        if (successImage && successInput) onLoadImageToFirebase()
    }

    fun onLoadImageToFirebase() {
        isLoading(true)
        val newUUID = UUID.randomUUID().toString()
        val imagesRef = storageRef.child("$IMAGES/$newUUID.jpg")
        var bitmap = (binding.ivImage.drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()
        imagesRef.putBytes(data).addOnFailureListener {
            makeSnackbar(IMAGE_LOAD_ERROR)
            isLoading(false)
        }.addOnSuccessListener {
            makeSnackbar(IMAGE_LOAD_SUCCESS)
            imagesRef.downloadUrl.addOnSuccessListener {
                onLoadDocumentToFirebase(it.toString())
            }
        }
    }

    fun isLoading(flag:Boolean){
        if(flag){
            binding.pgbIndicator.visibility = View.VISIBLE
            binding.btnCreateMenu.isEnabled = false
            binding.btnNewImageMenu.isEnabled = false
            binding.etMenu.isEnabled = false
        }else{
            binding.pgbIndicator.visibility = View.INVISIBLE
            binding.btnCreateMenu.isEnabled = true
            binding.btnNewImageMenu.isEnabled = true
            binding.etMenu.isEnabled = true
        }
    }

    fun onLoadDocumentToFirebase(img: String) {
        val title = binding.etMenu.editText?.text
        val menu: HashMap<String, String> =
            hashMapOf(
                MainActivity.KEY_IMG to img,
                MainActivity.KEY_TITLE to title.toString()
            )
        db.collection(MainActivity.MENU).add(menu)
            .addOnSuccessListener { finish() }
            .addOnFailureListener { makeSnackbar(DATA_LOAD_ERROR) }
    }

    fun validateInput(): Boolean {
        val validates = Regex("^[A-Za-záéíóúÁÉÍÓÚñÑ]*$")
        val text = binding.etMenu.editText?.text
        if (!text.isNullOrEmpty())
            if (text.matches(validates)) {
                binding.etMenu.error = null
                return true
            } else binding.etMenu.error = INPUT_CHARACTER_ERROR
        else binding.etMenu.error = INPUT_EMPTY_ERROR
        return false
    }

    fun makeSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            binding.ivImage.setImageURI(data?.data)
            successImage = true
        }
    }
}