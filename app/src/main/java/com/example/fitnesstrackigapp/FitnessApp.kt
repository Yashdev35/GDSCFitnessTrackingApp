package com.example.fitnesstrackigapp

import android.app.Application
import com.google.firebase.FirebaseApp

class FitnessApp : Application(){
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
        FirebaseApp.initializeApp(this)
    }
}