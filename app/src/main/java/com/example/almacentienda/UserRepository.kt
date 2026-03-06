package com.example.almacentienda

class UserRepository (private val userDao: UserDao){
    suspend fun processAndSave(rawName: String): String{
        // 1. Limpiamos espacios y validamos si está vacío
        val cleanName = rawName.trim()

        if (cleanName.isEmpty()) {
            return "El nombre no puede estar vacío"
        }

        // 2. Aplicamos Logica: todo a mayusculas
        val upperName = cleanName.uppercase()

        // 3. Guardamos en la DB
        userDao.insert(User(name = upperName))
        return "Guardado como: $upperName"
    }
}