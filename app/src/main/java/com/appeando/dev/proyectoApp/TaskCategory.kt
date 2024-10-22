package com.appeando.dev.proyectoApp

sealed class TaskCategory {

    object Economía : TaskCategory()
    object Medicina : TaskCategory()
    object Ingeniería : TaskCategory()
    object Magisterio : TaskCategory()
    object Periodismo : TaskCategory()
    object Derecho : TaskCategory()
    object Turismo : TaskCategory()


}