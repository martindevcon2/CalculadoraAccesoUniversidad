package com.appeando.dev.proyectoApp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appeando.dev.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat


class proyectoActivity : AppCompatActivity(), OnCategoryClickListener {


    private lateinit var asignaturaSeleccionada: String

    private lateinit var rsRange: RangeSlider

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var tvNotaSelectividad: TextView
    private lateinit var fabAddPrimero: FloatingActionButton
    private lateinit var fabSubstractPrimero: FloatingActionButton
    private lateinit var tvNotaPrimero: TextView
    private lateinit var fabAddSegundo: FloatingActionButton
    private lateinit var fabSubstractSegundo: FloatingActionButton
    private lateinit var tvNotaSegundo: TextView
    private lateinit var buttonCalculador: Button

    private var currentNotaSelectividad: Double = 7.0
    private var currentNotaPrimero: Double = 8.5
    private var currentNotaSegundo: Double = 7.2

    private var categories = listOf<TaskCategory>(
        TaskCategory.Economía,
        TaskCategory.Medicina,
        TaskCategory.Ingeniería,
        TaskCategory.Magisterio,
        TaskCategory.Periodismo,
        TaskCategory.Derecho,
        TaskCategory.Turismo
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.proyecto_app)
        initComponents()
        initUI()
        initListeners()

    } //cierre OnCreate

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rsRange = findViewById(R.id.rsRange)
        tvNotaSelectividad = findViewById(R.id.tvNotaSelectividad)
        fabAddPrimero = findViewById(R.id.fabAddPrimero)
        fabSubstractPrimero = findViewById(R.id.fabSubstractPrimero)
        tvNotaPrimero = findViewById(R.id.tvNotaPrimero)
        fabAddSegundo = findViewById(R.id.fabAddSegundo)
        fabSubstractSegundo = findViewById(R.id.fabSubstractSegundo)
        tvNotaSegundo = findViewById(R.id.tvNotaSegundo)
        buttonCalculador = findViewById(R.id.btnCalculador)

    } //cierre initComponents

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories, this)
    //Pasamos this para que CategoriesAdapter pueda acceder a onCategoryClick

        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        setNotaSelectividad()
        setNotaPrimero()
        setNotaSegundo()

    }

    override fun onCategoryClick(category: TaskCategory) {

        asignaturaSeleccionada = when (category) {
            TaskCategory.Economía -> "Economía"
            TaskCategory.Medicina -> "Medicina"
            TaskCategory.Ingeniería -> "Ingeniería"
            TaskCategory.Magisterio -> "Magisterio"
            TaskCategory.Periodismo -> "Periodismo"
            TaskCategory.Derecho -> "Derecho"
            TaskCategory.Turismo -> "Turismo"
        }
        Log.d("proyectoActivity", "Asignatura seleccionada: $asignaturaSeleccionada")
            }



    private fun initListeners() {
        rsRange.addOnChangeListener { _, value: Float, _ ->  //Listener para selectividad
            currentNotaSelectividad = value.toDouble()
            setNotaSelectividad()
        }

        fabAddPrimero.setOnClickListener { // Listener para el primer FAB
            currentNotaPrimero += 0.1
            setNotaPrimero()

        }
        fabAddPrimero.setOnClickListener {
            if (currentNotaPrimero < 9.9) { // Condición para no superar 10
                currentNotaPrimero += 0.1
                setNotaPrimero()
            }
        }
        fabSubstractPrimero.setOnClickListener { // Listener para el primer FAB
            currentNotaPrimero -= 0.1
            setNotaPrimero()
        }
        fabSubstractPrimero.setOnClickListener {
            if (currentNotaPrimero > 0.1) { // Condición para no bajar de 0
                currentNotaPrimero -= 0.1
                setNotaPrimero()
            }
        }

        fabAddSegundo.setOnClickListener { // Listener para el segundo FAB
            currentNotaSegundo += 0.1
            setNotaSegundo()

        }
        fabAddSegundo.setOnClickListener {
            if (currentNotaSegundo < 9.9) { // Condición para no superar 10
                currentNotaSegundo += 0.1
                setNotaSegundo()
            }
        }
        fabSubstractSegundo.setOnClickListener { // Listener para el segundo FAB
            currentNotaSegundo -= 0.1
            setNotaSegundo()
        }
        fabSubstractSegundo.setOnClickListener {
            if (currentNotaSegundo > 0.1) { // Condición para no bajar de 0
                currentNotaSegundo -= 0.1
                setNotaSegundo()
            }
        }
        buttonCalculador.setOnClickListener { // Lógica para el botón Calculador
            val resultado = calcularCAU()
            navegarToResult(resultado,asignaturaSeleccionada)

        }



    } //cierre initListeners

    private fun navegarToResult(resultado: String,asignaturaSeleccionada: String) {
        val intent = Intent(this, ResultCauActivity::class.java)
        intent.putExtra("CAU_resultado", resultado)
        intent.putExtra("CAU_asignaturaSeleccionada", asignaturaSeleccionada)
        startActivity(intent)
    }


    private fun setNotaSelectividad() {
        val df = DecimalFormat("#.##") // Formato con un decimal
        tvNotaSelectividad.text = df.format(currentNotaSelectividad)
    }

    private fun setNotaPrimero() {
        val df = DecimalFormat("#.##") // Formato con un decimal
        tvNotaPrimero.text = df.format(currentNotaPrimero)
    }

    private fun setNotaSegundo() {
        val df = DecimalFormat("#.##") // Formato con un decimal
        tvNotaSegundo.text = df.format(currentNotaSegundo)
    }

    private fun calcularCAU(): String {
        val notaSelectividad = currentNotaSelectividad
        val notaPrimero = currentNotaPrimero
        val notaSegundo = currentNotaSegundo

        val mediaBachillerato = (notaPrimero + notaSegundo) / 2.0

        val cau = notaSelectividad * 0.4 + mediaBachillerato * 0.6

        val df = DecimalFormat("#.##") // Formato con un decimal
        val cauFormatted = df.format(cau)

        Log.i("calculadora","el resultado es $cauFormatted")
        return df.format(cau)


    }


} //cierre del class.








