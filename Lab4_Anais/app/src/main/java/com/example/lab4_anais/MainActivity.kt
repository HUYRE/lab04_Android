package com.example.lab4_anais
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // Para Spacer y Grid
import androidx.compose.foundation.lazy.LazyColumn // Para LazyColumn
import androidx.compose.foundation.lazy.LazyRow // Para LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.* // Para Scaffold, FloatingActionButton, AlertDialog, etc.
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyApp() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Lab 04 AnaisA") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Acción al hacer clic */ }) {
                Text("+")
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                LazyColumnExample()
                Spacer(modifier = Modifier.height(16.dp))
                LazyRowExample()
                Spacer(modifier = Modifier.height(16.dp))
                GridExample()
                Spacer(modifier = Modifier.height(16.dp))
                ShowAlertDialog()
            }
        }
    )
}

@Composable
fun LazyColumnExample() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, RoundedCornerShape(8.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(10) { index ->
            Text(
                text = "Elemento $index",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .background(Color.Blue, RoundedCornerShape(4.dp))
                    .padding(8.dp)
                    .clickable { /* Acción al hacer clic */ }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun LazyRowExample() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, RoundedCornerShape(8.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(10) { index ->
            Text(
                text = "Item $index",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .background(Color.Green, RoundedCornerShape(4.dp))
                    .padding(8.dp)
                    .clickable { /* Acción al hacer clic */ }
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun GridExample() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.Yellow, RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        for (i in 0..1) { // Número de filas
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (j in 0..2) { // Número de columnas
                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .background(Color.Red, RoundedCornerShape(8.dp))
                            .clickable { /* Acción al hacer clic */ },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Item ${i * 3 + j}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ShowAlertDialog() {
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Alerta") },
            text = { Text("Este es un mensaje de alerta con funcionalidad.") },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false
                        // Acción adicional al cerrar el diálogo
                    }
                ) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }

    Button(
        onClick = { showDialog = true },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text("Mostrar Alerta")
    }
}
