package com.example.learnit.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learnit.R
@Composable
fun EditProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var fullName by remember { mutableStateOf("") }
    var nickName by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var student by remember { mutableStateOf("") }

    val primaryColor = Color(0xFF2B1AFF)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),   // ⭐ SCROLL ENABLED
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            Text(
                text = "Edit Profile",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Profile picture
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(2.dp, primaryColor, CircleShape)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Reusable Form Field
        @Composable
        fun FormField(
            value: String,
            onValueChange: (String) -> Unit,
            label: String,
            trailingIcon: ImageVector? = null
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                label = { Text(label) },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = primaryColor,
                    unfocusedBorderColor = Color.LightGray,
                    cursorColor = primaryColor
                ),
                trailingIcon = {
                    if (trailingIcon != null) {
                        Icon(trailingIcon, contentDescription = null, tint = Color.Gray)
                    }
                },
                readOnly = trailingIcon != null
            )
        }

        // Fields
        FormField(fullName, { fullName = it }, "Full Name")
        FormField(nickName, { nickName = it }, "Nick Name")
        FormField(dateOfBirth, { dateOfBirth = it }, "Date of Birth")
        FormField(email, { email = it }, "Email")
        FormField(gender, { gender = it }, "Gender", Icons.Default.ArrowDropDown)
        FormField(student, { student = it }, "Student")

        Spacer(modifier = Modifier.height(24.dp))

        // Update Button
        Button(
            onClick = { /* aksi update nanti */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(),
            shape = RoundedCornerShape(25.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(primaryColor, Color(0xFF3F51B5))
                        ),
                        shape = RoundedCornerShape(25.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Update",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}
