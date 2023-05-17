//package com.aicontent.comic.viewModel.settings
//
//import androidx.compose.runtime.State
//import androidx.compose.runtime.mutableStateOf
//import com.aicontent.domain.comic.repository.Comic
////import com.aicontent.domain.comic.usecases.InsertComicUseCase
//import comaicontentdatabase.Comic
//import org.brightify.hyperdrive.multiplatformx.ViewModel
//
//class AddComicViewModel(private val insertComicUseCase: InsertComicUseCase) : ViewModel() {
//
//    private val _title = mutableStateOf("")
//    private val _author = mutableStateOf("")
//
//    val title: State<String> = _title
//    val author: State<String> = _author
//
//    fun onTitleChanged(title: String) {
//        _title.value = title
//    }
//
//    fun onAuthorChanged(author: String) {
//        _author.value = author
//    }
//
//    fun insertComic() {
//        viewModelScope.launch {
//            insertComicUseCase.execute(
//                Comic(
//                    id = 0,
//                    title = _title.value,
//                    author = _author.value
//                )
//            )
//        }
//    }
//}