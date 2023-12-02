package com.example.tchmk3

import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tchmk3.Functions.fermatFactorization
import com.example.tchmk3.Functions.pollardPMinusOneFactorization
import com.example.tchmk3.theme.JetnewsTheme
import java.math.BigInteger

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetnewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = androidx.compose.material3.MaterialTheme.colorScheme.background
                ) {
                    Column {
                        AppBar()
                        Spacer(modifier = Modifier.height(16.dp))
                        Ferma()
                        Spacer(modifier = Modifier.height(64.dp))
                        Pollard()
                    }
                }
            }
        }
    }
}

@Composable
private fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Palette,
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        },
        title = {
            Text(text = "Third practice")
        },
        backgroundColor = MaterialTheme.colors.primarySurface
    )
}

@Composable
fun Ferma() {

    var n by rememberSaveable { mutableStateOf("") }
    var factors: String by rememberSaveable { mutableStateOf("") }

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Input N: ",
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier.padding(start = 8.dp)
            )

            OutlinedTextField(
                value = n,
                onValueChange = {newText -> n = newText},
                label = { Text(text = "Composite number") },
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MaterialTheme.colors.primary, unfocusedBorderColor = MaterialTheme.colors.primary, disabledBorderColor = MaterialTheme.colors.primary),
                modifier = Modifier
                    .padding(start = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Result: ",
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier.padding(start = 8.dp)
            )

            OutlinedTextField(
                value = factors,
                onValueChange = {},
                label = { Text(text = "This is your result!") },
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MaterialTheme.colors.primary, unfocusedBorderColor = MaterialTheme.colors.primary, disabledBorderColor = MaterialTheme.colors.primary),
                modifier = Modifier.padding(top = 8.dp, start = 15.dp)
            )
        }


        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = {
                    factors = fermatFactorization(n.toLong())
                }, modifier = Modifier.padding(top = 50.dp)
            )
            {
                Text("Ferma Algoritm")
            }
        }
    }
}

@Composable
fun Pollard(){

    var n by rememberSaveable { mutableStateOf("") }
    var factors: String by rememberSaveable { mutableStateOf("") }

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Input N: ",
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier.padding(start = 8.dp)
            )

            OutlinedTextField(
                value = n,
                onValueChange = {newText -> n = newText},
                label = { Text(text = "Composite number") },
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MaterialTheme.colors.primary, unfocusedBorderColor = MaterialTheme.colors.primary, disabledBorderColor = MaterialTheme.colors.primary),
                modifier = Modifier
                    .padding(start = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Result: ",
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier.padding(start = 8.dp)
            )

            OutlinedTextField(
                value = factors,
                onValueChange = {},
                label = { Text(text = "This is your result!") },
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MaterialTheme.colors.primary, unfocusedBorderColor = MaterialTheme.colors.primary, disabledBorderColor = MaterialTheme.colors.primary),
                modifier = Modifier.padding(top = 8.dp, start = 15.dp)
            )
        }


        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = {
                    factors = pollardPMinusOneFactorization(BigInteger.valueOf(n.toLong()), BigInteger.valueOf(10)).toString()
                }, modifier = Modifier.padding(top = 50.dp)
            )
            {
                Text("Pollard Algoritm")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetnewsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column {
                AppBar()
                Spacer(modifier = Modifier.height(16.dp))
                Ferma()
                Spacer(modifier = Modifier.height(64.dp))
                Pollard()
            }
        }
    }
}