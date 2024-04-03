package com.example.pneumonia_xray_detection_app.ViewModel

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PickImageFromGallery(){
    val context = LocalContext.current
    var imageUri by remember {mutableStateOf<Uri?>(null)}

    val singleImagePicker = rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            imageUri = it
        })

    Card(modifier = Modifier
        .height(30.dp)
        .width(50.dp)
        .clickable { singleImagePicker.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)) },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(Color.Black)){
        Text("Upload your XRay", fontSize = 20.sp, color = Color.White)
    }
}