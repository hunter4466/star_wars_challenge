package com.ravnnerdery.starwarschallenge.ui.navigation.topbar.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction.Companion
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchTopBar(
    searchText: String,
    placeHolderText: String = "",
    onSearchTextChanged: (String) -> Unit = {},
    onClearSearchClicked: () -> Unit = {},
    onCloseSearchBar: () -> Unit = {},
) {
    var showClearButton by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }

    TopAppBar(
        title = { Text("") },
        navigationIcon = {
            IconButton(onClick = { onCloseSearchBar() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    modifier = Modifier,
                    contentDescription = "Arrow Back",
                    tint = MaterialTheme.colors.onPrimary,
                )
            }
        },
        actions = {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp)
                    .onFocusChanged { focusState ->
                        showClearButton = (focusState.isFocused)
                    }
                    .focusRequester(focusRequester),
                value = searchText,
                onValueChange = onSearchTextChanged,
                placeholder = {
                    Text(text = placeHolderText)
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    backgroundColor = Color.Transparent,
                    cursorColor = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
                ),
                trailingIcon = {
                    AnimatedVisibility(
                        visible = showClearButton,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { onClearSearchClicked() }) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "Close"
                            )
                        }

                    }
                },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = Companion.Done),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                }),
            )
        },
        backgroundColor = MaterialTheme.colors.primaryVariant,
    )

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}