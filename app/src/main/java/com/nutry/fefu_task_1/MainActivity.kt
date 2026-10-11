package com.nutry.fefu_task_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nutry.fefu_task_1.ui.theme.FEFUtask1Theme


// Размеры
val bigFont = 24.sp
val standardFont = 20.sp
val littleFont = 16.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)) {
                Task1Screen() // Вызов вашего первого задания
            }
        }
    }
}

@Composable
fun Task1Screen() {
    // Общая колонка всего
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Ряд для аватарки и текста
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.LightGray, shape = CircleShape)
            )
            // Колонка для имени и звания
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    "Алексей Иванов",
                    fontWeight = FontWeight.Bold,
                    fontSize = bigFont
                )
                Text(
                    "Android Developer",
                    fontSize = standardFont
                )
            }
        }
        // Ряд для статистики
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            // Карточки статистики
            StatisticCard(
                value = "24",
                description = "Projects",
                modifier = Modifier.weight(1f)
            )
            StatisticCard(
                value = "18",
                description = "Followers",
                modifier = Modifier.weight(1f)
            )
            StatisticCard(value = "7", description = "Posts", modifier = Modifier.weight(1f))
        }

        // Колонка для описания About
        Column(
            Modifier.fillMaxWidth().padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "About",
                fontWeight = FontWeight.Bold,
                fontSize = standardFont
            )
            Text(
                text = "Android developer from Moscow\nKotlin enthusiast",
                fontSize = standardFont
            )
        }

        // Колонка для опыта Experience
        Column(
            Modifier.padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Experience",
                fontWeight = FontWeight.Bold,
                fontSize = standardFont
            )
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Android Developer",
                        fontWeight = FontWeight.Bold,
                        color = Color(70, 70, 70),
                        fontSize = standardFont
                    )
                    Text(text = "2022 - Present")
                }
            }
        }
    }
}

@Composable
fun StatisticCard(value: String, description: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .border(
                width = 2.dp, color = Color(230, 230, 230),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            fontSize = bigFont,
        )
        Text(
            text = description,
            color = Color.Gray,
            fontSize = littleFont,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TestPreview() {
    FEFUtask1Theme {
        Task1Screen()
    }
}