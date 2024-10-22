package com.appeando.dev.proyectoApp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.appeando.dev.R

class ResultCauActivity : AppCompatActivity() {


    private lateinit var tvTuNotaEs: TextView
    private lateinit var tvTuNotaResultado: TextView
    private lateinit var tvFinal: TextView
    private lateinit var btnReCalcular: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_cau)
        val resultado = intent.extras?.getString("CAU_resultado").orEmpty()
        val asignaturaSeleccionada =
            intent.extras?.getString("CAU_asignaturaSeleccionada").orEmpty()
        initComponents()
        initUI(resultado, asignaturaSeleccionada)

        btnReCalcular.setOnClickListener {
            finish()
        }

    }

    private fun initUI(resultado: String, asignaturaSeleccionada: String) {
        tvTuNotaResultado.text = resultado
        val notaUsuario = resultado.toDoubleOrNull() ?: 0.0

        when (asignaturaSeleccionada) {
            "Economía" -> {
                val notaDeCorteEconomía = 5.0
                if (notaUsuario >= notaDeCorteEconomía) {
                    tvFinal.text =
                        "Tu nota ($notaUsuario) es igual o superior a la nota de corte de Economía ($notaDeCorteEconomía)"
                    tvTuNotaEs.text = "¡Enhorabuena!"
                } else {
                    tvFinal.text =
                        "Lo siento, tu nota ($notaUsuario) es inferior ala nota de corte de Economía ($notaDeCorteEconomía)"
                    tvTuNotaEs.text = "¡Lástima!"
                }
            }

            "Medicina" -> {
                val notaDeCorteMedicina = 9.84
                if (notaUsuario >= notaDeCorteMedicina) {
                    tvFinal.text =
                        "Tu nota ($notaUsuario) es igual o superior a la nota de corte de Medicina ($notaDeCorteMedicina)"
                    tvTuNotaEs.text = "¡Enhorabuena!"
                } else {
                    tvFinal.text =
                        "Lo siento, tu nota ($notaUsuario) es inferior ala nota de corte de Medicina ($notaDeCorteMedicina)"
                    tvTuNotaEs.text = "¡Lástima!"
                }

            }

            "Ingeniería" -> {
                val notaDeCorteIngeniería = 7.0
                if (notaUsuario >= notaDeCorteIngeniería) {
                    tvFinal.text =
                        "Tu nota ($notaUsuario) es igual o superior a la nota de corte de Ingeniería ($notaDeCorteIngeniería)"
                    tvTuNotaEs.text = "¡Enhorabuena!"
                } else {
                    tvFinal.text =
                        "Lo siento, tu nota ($notaUsuario) es inferior ala nota de corte de Ingeniería ($notaDeCorteIngeniería)"
                    tvTuNotaEs.text = "¡Lástima!"
                }

            }

            "Magisterio" -> {
                val notaDeCorteMagisterio = 7.0
                if (notaUsuario >= notaDeCorteMagisterio) {
                    tvFinal.text =
                        "Tu nota ($notaUsuario) es igual o superior a la nota de corte de Magisterio ($notaDeCorteMagisterio)"
                    tvTuNotaEs.text = "¡Enhorabuena!"
                } else {
                    tvFinal.text =
                        "Lo siento, tu nota ($notaUsuario) es inferior ala nota de corte de Magisterio ($notaDeCorteMagisterio)"
                    tvTuNotaEs.text = "¡Lástima!"
                }
            }

            "Periodismo" -> {
                val notaDeCortePeriodismo = 7.21
                if (notaUsuario >= notaDeCortePeriodismo) {
                    tvFinal.text =
                        "Tu nota ($notaUsuario) es igual o superior a la nota de corte de Periodismo ($notaDeCortePeriodismo)"
                    tvTuNotaEs.text = "¡Enhorabuena!"
                } else {
                    tvFinal.text =
                        "Lo siento, tu nota ($notaUsuario) es inferior ala nota de corte de Periodismo ($notaDeCortePeriodismo)"
                    tvTuNotaEs.text = "¡Lástima!"
                }
            }

            "Derecho" -> {
                val notaDeCorteDerecho = 6.93
                if (notaUsuario >= notaDeCorteDerecho) {
                    tvFinal.text =
                        "Tu nota ($notaUsuario) es igual o superior a la nota de corte de Derecho ($notaDeCorteDerecho)"
                    tvTuNotaEs.text = "¡Enhorabuena!"
                } else {
                    tvFinal.text =
                        "Lo siento, tu nota ($notaUsuario) es inferior ala nota de corte de Derecho ($notaDeCorteDerecho)"
                    tvTuNotaEs.text = "¡Lástima!"
                }
            }

            "Turismo" -> {
                val notaDeCorteTurismo = 5.0
                if (notaUsuario >= notaDeCorteTurismo) {
                    tvFinal.text =
                        "Tu nota ($notaUsuario) es igual o superior a la nota de corte de Turismo ($notaDeCorteTurismo)"
                    tvTuNotaEs.text = "¡Enhorabuena!"
                } else {
                    tvFinal.text =
                        "Lo siento, tu nota ($notaUsuario) es inferior ala nota de corte de Turismo ($notaDeCorteTurismo)"
                    tvTuNotaEs.text = "¡Lástima!"
                }
            }

            else -> {
                // Manejar el caso en que la asignatura no esté en la lista
                tvFinal.text = "Asignatura no encontrada"
                tvTuNotaEs.text = "Error"
            }
        }
    }

    private fun initComponents() {
        tvTuNotaEs = findViewById(R.id.tvTuNotaEs)
        tvTuNotaResultado = findViewById(R.id.tvTuNotaResultado)
        tvFinal = findViewById(R.id.tvFinal)
        btnReCalcular = findViewById(R.id.btnReCalcular)
    }
}






