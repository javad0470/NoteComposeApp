package com.example.note.utils

sealed class Navigation(var route:String){
    object MainScreen : Navigation("main_screen")
    object AddNoteScreen : Navigation("add_note_screen")
    object UpdateNote : Navigation("update_note_screen")
    object SplashScreen : Navigation("splash_screen")

}
