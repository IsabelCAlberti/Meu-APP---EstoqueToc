package com.example.estoquetoc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.withStyle

@Composable
fun CadastroUsuarioScreen(navController: NavHostController? = null) { // Tornando navController opcional para pré-visualização
    var nomeFantasia by remember { mutableStateOf("") }
    var cnpj by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = "Imagem de Fundo com círculos",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                //.fillMaxSize()
                .padding(16.dp)
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 36.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_semfundo),
                    contentDescription = "Logo Estoquetoc",
                    modifier = Modifier.size(56.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Estoquetoc",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
            Text(
                text = "Olá,",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
                    .padding(top = 16.dp),
            )

            Text(
                text = "Crie uma Conta.",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 8.dp, bottom = 16.dp),
            )

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = nomeFantasia,
                onValueChange = { nomeFantasia = it },
                label = { Text("Nome Fantasia") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = cnpj,
                onValueChange = { cnpj = it },
                label = { Text("CNPJ") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email Corporativo") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon =
                        if (senhaVisivel) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    IconButton(onClick = { senhaVisivel = !senhaVisivel }) {
                        Icon(
                            imageVector = icon,
                            contentDescription = "Toggle password visibility"
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                var isChecked by remember { mutableStateOf(false) }
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { checked ->
                        isChecked = checked
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Green,
                        uncheckedColor = Color.Red,
                        checkmarkColor = Color.White
                    )
                )
                Text(text = "Concordo com os Termos de Serviço.")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController?.navigate("LoginScreen")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6F00))
            ) {
                Text(text = "Cadastrar",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            TextButton(
                onClick = {
                    navController?.navigate("LoginScreen") // Navegar para a tela de login
                }
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color(0xFFFF6F00))) {
                            append("Já tem uma conta? ")
                        }
                        withStyle(style = SpanStyle(color = Color(0xFF262626))) {
                            append("Entre aqui.")
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CadastroUsuarioPreview() {
    CadastroUsuarioScreen()
}