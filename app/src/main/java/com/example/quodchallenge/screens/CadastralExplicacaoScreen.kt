package com.example.quodchallenge.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quodchallenge.R
import com.example.quodchallenge.common.components.BarraSuperior
import com.example.quodchallenge.common.components.BotaoModular

@Composable
fun CadastralExplicacaoScreen(navController: NavController){
    val inquiryIcon = painterResource(R.drawable.inquiry)
    val name = remember { mutableStateOf("") }
    val cpf = remember { mutableStateOf("") }
    val address = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
            .background(Color.White)
    ) {
        BarraSuperior("Cadastral", navController)
        Text(
            text = "Preencha seu CPF, nome, endereço e telefone celular para validar seus dados cadastrais. A validação garantirá a consistência e autenticidade das informações fornecidas.",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 30.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF55575C),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.padding(top = 44.dp, bottom = 24.dp).width(353.dp).height(150.dp)
        )
        Text(
            text = "Nome Completo",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF753CFD)
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp, bottom = 8.dp)
        )

        BasicTextField(
            value = name.value,
            onValueChange = { name.value = it },
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = Color(0xFF55575C)
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(55.dp)
                .background(
                    color = Color.White,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                )
                .border(
                    width = 2.dp,
                    color = Color(0xFF753CFD),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 12.dp, vertical = 16.dp),
            cursorBrush = SolidColor(Color(0xFF753CFD)),
            decorationBox = { innerTextField ->
                if (name.value.isEmpty()) {
                    Text(
                        text = "Digite o Nome",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color(0xFFAAAAAA)
                        )
                    )
                }
                innerTextField()
            }
        )
        Text(
            text = "CPF",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF753CFD)
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp, top = 16.dp, bottom = 8.dp)
        )

        BasicTextField(
            value = cpf.value,
            onValueChange = { cpf.value = it },
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = Color(0xFF55575C)
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(55.dp)
                .background(
                    color = Color.White,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                )
                .border(
                    width = 2.dp,
                    color = Color(0xFF753CFD),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 12.dp, vertical = 16.dp),
            cursorBrush = SolidColor(Color(0xFF753CFD)),
            decorationBox = { innerTextField ->
                if (cpf.value.isEmpty()) {
                    Text(
                        text = "Digite o CPF",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color(0xFFAAAAAA)
                        )
                    )
                }
                innerTextField()
            }
        )
        Text(
            text = "Endereço",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF753CFD)
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp, top = 16.dp, bottom = 8.dp)
        )

        BasicTextField(
            value = address.value,
            onValueChange = { address.value = it },
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = Color(0xFF55575C)
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(55.dp)
                .background(
                    color = Color.White,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                )
                .border(
                    width = 2.dp,
                    color = Color(0xFF753CFD),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 12.dp, vertical = 16.dp),
            cursorBrush = SolidColor(Color(0xFF753CFD)),
            decorationBox = { innerTextField ->
                if (address.value.isEmpty()) {
                    Text(
                        text = "Digite o Endereço",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color(0xFFAAAAAA)
                        )
                    )
                }
                innerTextField()
            }
        )
        Text(
            text = "Telefone",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF753CFD)
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp, top = 16.dp, bottom = 8.dp)
        )

        BasicTextField(
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = Color(0xFF55575C)
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(55.dp)
                .background(
                    color = Color.White,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                )
                .border(
                    width = 2.dp,
                    color = Color(0xFF753CFD),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 12.dp, vertical = 16.dp),
            cursorBrush = SolidColor(Color(0xFF753CFD)),
            decorationBox = { innerTextField ->
                if (phoneNumber.value.isEmpty()) {
                    Text(
                        text = "Digite o Telefone",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color(0xFFAAAAAA)
                        )
                    )
                }
                innerTextField()
            }
        )
        BotaoModular(inquiryIcon, "Consultar", onClick = { navController.navigate("validating") })
    }
}