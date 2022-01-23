package com.coolapps.newsapp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coolapps.newsapp1.screen.NoteScreen
import com.coolapps.newsapp1.screen.NoteViewModel
import com.coolapps.newsapp1.ui.theme.NewsApp1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsApp1Theme {
                Surface(color = MaterialTheme.colors.background) {
                    //    val notes = remember{ mutableStateListOf<Note>()
                    //val noteViewModel: NoteViewModel by viewModels()
                    val noteViewModel= viewModel<NoteViewModel>()
                    NotesApp(noteViewModel)
                }
                }
            }
        }
    }

@ExperimentalComposeUiApi
@Composable
fun NotesApp(noteViewModel: NoteViewModel){
    val notesList = noteViewModel.noteList.collectAsState().value

    NoteScreen(notes = notesList,
        onRemoveNote = {noteViewModel.removeNote(it)},
        onAddNote = { noteViewModel.addNote(it) })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsApp1Theme {

    }
}