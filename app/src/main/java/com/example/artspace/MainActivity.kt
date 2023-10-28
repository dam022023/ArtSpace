package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpacePreview()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceImage(texto: String, autor: String, foto: Int, nextInfo: () -> Unit, previousInfo: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(400.dp)
                .width(350.dp)
                .shadow(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .height(300.dp)
                    .width(250.dp)
            ) {
                Image(
                    painter = painterResource(foto),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
        Spacer(modifier = Modifier.height(70.dp))
        Row(
            modifier = Modifier
                .width(250.dp)
                .background(color = Color.LightGray),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = texto,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp),
                fontFamily = FontFamily.SansSerif
            )
        }
        Row(
            modifier = Modifier
                .width(250.dp)
                .background(color = Color.LightGray),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = autor,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp),
                fontFamily = FontFamily.SansSerif
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = previousInfo, modifier = Modifier.size(120.dp, 40.dp)) {
                Text(text = "Previous")
            }
            Button(onClick = nextInfo, modifier = Modifier.size(120.dp, 40.dp)) {
                Text(text = "Next")
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpace(){
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    when(currentStep){
        1->{
            ArtSpaceImage(
                texto = stringResource(R.string.texto_beso),
                autor= stringResource(R.string.gustav),
                foto = R.drawable.beso,
                nextInfo = {
                    currentStep=2
                    squeezeCount=(2..6).random()
                },
                previousInfo = {
                    currentStep=6
                }
            )
        }
        2->{
            ArtSpaceImage(
                texto = stringResource(R.string.texto_grito),
                autor= stringResource(R.string.edvard),
                foto = R.drawable.grito,
                nextInfo = {
                    currentStep=3
                },
                previousInfo = {
                    currentStep=1
                }
            )
        }
        3->{
            ArtSpaceImage(
                texto = stringResource(R.string.texto_joven_perla),
                autor= stringResource(R.string.johannes),
                foto = R.drawable.joven_perla,
                nextInfo = {
                    currentStep=4
                },
                previousInfo = {
                    currentStep=2
                }
            )
        }
        4->{
            ArtSpaceImage(
                texto = stringResource(R.string.texto_meninas),
                autor= stringResource(R.string.velazquez),
                foto = R.drawable.meninas,
                nextInfo = {
                    currentStep = 5
                },
                previousInfo = {
                    currentStep=3
                }
            )
        }
        5->{
            ArtSpaceImage(
                texto = stringResource(R.string.texto_mona_lisa),
                autor= stringResource(R.string.leonardo),
                foto = R.drawable.mona_lisa,
                nextInfo = {
                    currentStep=6
                },
                previousInfo = {
                    currentStep=4
                }
            )
        }
        6->{
            ArtSpaceImage(
                texto = stringResource(R.string.texto_saturno),
                autor= stringResource(R.string.rubens),
                foto = R.drawable.saturno,
                nextInfo = {
                    currentStep=1
                },
                previousInfo = {
                    currentStep=5
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}