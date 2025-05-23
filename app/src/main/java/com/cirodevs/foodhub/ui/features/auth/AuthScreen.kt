package com.cirodevs.foodhub.ui.features.auth


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cirodevs.foodhub.R
import com.cirodevs.foodhub.ui.GroupSocialButtons
import com.cirodevs.foodhub.ui.theme.Orange

@Composable
fun AuthScreen() {
    // implementamos la imagen de fondo y agregamos el brush (gradiente)

    val imageZise = remember {
        mutableStateOf(IntSize.Zero)
    }

    val brush = Brush.verticalGradient(
        colors = listOf(
            androidx.compose.ui.graphics.Color.Transparent,
            androidx.compose.ui.graphics.Color.Black,

        ),
        startY = imageZise.value.height.toFloat()/3,

    )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Image(painter = painterResource(id = R.drawable.background), contentDescription = null,
            modifier = Modifier
                .onGloballyPositioned {
                    imageZise.value = it.size
                }
                .alpha(0.6f),
            contentScale = ContentScale.FillBounds
        )
        Box(modifier = Modifier
            .matchParentSize()
            .background(brush = brush)
        )
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
        ){
            Text(text = stringResource(R.string.skip), color = Orange)

        }

        Column( modifier = Modifier
            .fillMaxWidth()
            .padding(top = 110.dp)
            .padding(16.dp)) {
            Text(text = stringResource(R.string.welcome),
                color = Color.Black,
                modifier = Modifier,
                fontSize = 50.sp,
                fontWeight = Bold

            )
            Text(text = stringResource(R.string.food_hub),
                color = Orange,
                modifier = Modifier,
                fontSize = 50.sp,
                fontWeight = Bold

            )
            Text(text = stringResource(id = R.string.food_hub_description),
                color = Color.DarkGray,
                fontSize = 20.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
                )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(text = stringResource(id = R.string.sign_with_it), color = Color.White, modifier = Modifier.padding(8.dp))

            GroupSocialButtons(onFacebookClick = {}, onGoogleClick = {})



            Spacer(modifier = Modifier.height(16.dp))
            //boton de email
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray.copy(alpha = 0.2f)
                ),
                border = BorderStroke(1.dp, Color.White),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(32.dp)
            ) {
                Text(text = stringResource(id = R.string.sign_whit_email), color = Color.White)

            }


            // texto al presionar
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    text = stringResource(id = R.string.already_have_acount),
                    color = Color.White,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthScreenPreview() {
    AuthScreen()
}