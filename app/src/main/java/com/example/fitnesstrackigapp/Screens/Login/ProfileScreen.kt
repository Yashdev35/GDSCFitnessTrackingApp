package com.example.fitnesstrackigapp.Screens.Login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnesstrackigapp.R
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSet(){
    var gender by remember { mutableStateOf("Male") }
    var birthdate by remember { mutableStateOf(LocalDate.now().toString()) }
    var wt by remember { mutableStateOf(0f) }
    var ht by remember { mutableStateOf(0f) }
    var dropdownExpanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white)),
        contentAlignment = Alignment.TopCenter

    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = CenterHorizontally
        ) {
            Image(
            painter = painterResource(id = R.drawable.create_profile1),
            contentDescription = "just a image",
            modifier = Modifier
                .size(300.dp)
                .aspectRatio(1.0f)
        )
            Spacer(modifier = Modifier.size(14.dp))
            Text(
                text = "Let's complete your profile",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 48.sp
                ),
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.size(14.dp))
            Text(
                text = "It will help us to know about your BMI and overall health",
                style = MaterialTheme.typography.bodySmall,
                color = colorResource(id = R.color.brown),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.size(14.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(30))
                    .background(
                        color = colorResource(id = R.color.light_gray)
                    ),
                onClick = { /*TODO*/
                      dropdownExpanded = true
                          },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.light_gray),
                    contentColor = colorResource(id = R.color.black),
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                  Icon(
                      painter = painterResource(id = R.drawable.__user),
                      contentDescription = "drop down" ,
                         modifier = Modifier
                            .size(20.dp))
                    Spacer(modifier = Modifier.size(20.dp))
                    Text(
                        text = gender,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        textAlign = TextAlign.Start
                    )
                    DropdownMenu(expanded = dropdownExpanded, onDismissRequest = {
                        /*TODO*/
                        dropdownExpanded = false
                    },
                         modifier = Modifier
                             .fillMaxWidth()
                             .wrapContentHeight()
                        ) {
                        DropdownMenuItem(
                            text = { Text(text = "Male"
                                        , style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Center
                            )},
                            onClick = {
                                /*TODO*/
                                gender = "Male"
                                dropdownExpanded = false
                            })
                        DropdownMenuItem(
                            text = { Text(text ="Female",
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Center
                                )},
                            onClick = {
                                /*TODO*/
                                gender = "Female"
                                dropdownExpanded = false
                            }
                        )
                    }
                }
            }




            Spacer(modifier = Modifier.size(14.dp))
            Box(
                modifier = Modifier.background(
                    color = colorResource(id = R.color.light_gray),
                    shape = RoundedCornerShape(30)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    TextField(value = birthdate,
                        onValueChange = {/*TODO*/
                            birthdate  = it
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .background(color = colorResource(id = R.color.light_gray)),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = colorResource(id = R.color.light_gray),
                            focusedIndicatorColor = colorResource(id = R.color.light_gray),
                            unfocusedIndicatorColor = colorResource(id = R.color.light_gray),

                            ),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.calendar),
                                contentDescription = "Arrow Forward",
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.size(14.dp))
            Box(
                modifier = Modifier.background(
                    color = colorResource(id = R.color.light_gray),
                    shape = RoundedCornerShape(30)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    TextField(value = wt.toString(),
                        onValueChange = {/*TODO*/
                            wt = it.toFloat()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .background(color = colorResource(id = R.color.light_gray)),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = colorResource(id = R.color.light_gray),
                            focusedIndicatorColor = colorResource(id = R.color.light_gray),
                            unfocusedIndicatorColor = colorResource(id = R.color.light_gray),

                            ),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.weight_scale_1),
                                contentDescription = "Arrow Forward",
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        },
                        trailingIcon = {
                              Text(
                                    text = "Kg",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = colorResource(id = R.color.black),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 24.sp,
                                    modifier = Modifier
                                        .padding(end = 16.dp)
                                )
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.size(14.dp))
            Box(
                modifier = Modifier.background(
                    color = colorResource(id = R.color.light_gray),
                    shape = RoundedCornerShape(30)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(value = ht.toString(),
                        onValueChange = {/*TODO*/
                            ht = it.toFloat()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = colorResource(id = R.color.light_gray)),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = colorResource(id = R.color.light_gray),
                            focusedIndicatorColor = colorResource(id = R.color.light_gray),
                            unfocusedIndicatorColor = colorResource(id = R.color.light_gray),

                            ),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.swap),
                                contentDescription = "Arrow Forward",
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                /*TODO*/
                            },
                                modifier = Modifier.background(color = colorResource(id = R.color.light_gray))
                            ) {
                                Text(
                                    text = "Cm",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = colorResource(id = R.color.black),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 24.sp,
                                    modifier = Modifier
                                        .padding(end = 16.dp)
                                )
                            }
                        }
                    )

                }
            }
            Spacer(modifier = Modifier.size(20.dp))
            Surface(
                shape = RoundedCornerShape(100),
                modifier = Modifier
                    .padding(end = 32.dp, start = 32.dp)
                    .wrapContentSize()
                    .wrapContentSize(align = Alignment.BottomCenter)
                    .clip(RoundedCornerShape(100.dp))//first round the corners then give background color, pehele shape fir color
                    .background(
                        Brush.linearGradient(
                            0.0f to colorResource(id = R.color.primary1),
                            1.0f to colorResource(id = R.color.primary2),
                            start = Offset(0f, 0f),
                            end = Offset(200f, 200f)
                        )
                    ),
                color = Color.Transparent
            ){
                Text(text = "Next ➡\uFE0F",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .clickable(onClick = {
                            /*TODO*/
                            if (gender.isNotEmpty() && birthdate.isNotEmpty() && wt
                                    .toString()
                                    .isNotEmpty() && ht
                                    .toString()
                                    .isNotEmpty()
                            ) {
                                /*TODO*/
                            } else {
                                /*TODO*/
                                Toast
                                    .makeText(
                                        context,
                                        "Please fill all the fields",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }
                        })
                        .padding(start = 45.dp, end = 45.dp, top = 6.dp, bottom = 6.dp),
                )
            }
        }
    }
}

@Preview
@Composable
fun ProfileSetPreview(){
    ProfileSet()
}