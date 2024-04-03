package com.example.pneumonia_xray_detection_app.View

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.jetbrains.annotations.Async

@Preview(showBackground = true)
@Composable
fun HomeScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.height(30.dp))

        // Heading
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(190.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(Color.Blue))
        {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
                contentAlignment = Alignment.Center)
            {
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(
                        "Pneumonia XRay Detection Model", fontSize = 28.sp, color = Color.White,
                        fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        "A Deep Learning Model that can detect Pneumonia vs. Normal Lungs XRay images with 88% accuracy",
                        fontSize = 17.sp, color = Color.White, fontWeight = FontWeight.Normal, textAlign = TextAlign.Center
                    )
                }
            }
        }

        // Image Picker initialisation
        val context = LocalContext.current
        var imageUri by remember { mutableStateOf<Uri?>(null) }
        val singleImagePicker = rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia(),
            onResult = {
                imageUri = it
            })

        // Upload Button
        Spacer(modifier = Modifier.height(30.dp))
        Card(modifier = Modifier
            .height(50.dp)
            .width(220.dp)
            .clickable { singleImagePicker.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) },
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(Color.Black)){
            Box(modifier = Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.Center) {
                Text("Upload Your XRay", fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
            }
        }

        // Uploaded Image
        Spacer(modifier = Modifier.height(30.dp))
        AsyncImage(model = imageUri, contentDescription = null,
            modifier = Modifier.height(300.dp).width(300.dp)
            )
    }
}