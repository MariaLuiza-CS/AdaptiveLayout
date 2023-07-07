package com.example.adaptivelayout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun BoxWithConstraints() {
    val badges = listOf(
        Icons.Default.Face,
        Icons.Default.Face,
        Icons.Default.Face,
        Icons.Default.Face,
        Icons.Default.Face,
        Icons.Default.Face,
        Icons.Default.Face
    )
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = badges) {
            Row(
                modifier = Modifier.border(width = 1.dp, color = Color.LightGray),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(100.dp)
                        .weight(1f),
                    contentDescription = "Badge Icon",
                    imageVector = it
                )
                Spacer(modifier = Modifier.width(12.dp))

                androidx.compose.foundation.layout.BoxWithConstraints(
                    modifier = Modifier
                        .weight(1.5f)
                        .padding(vertical = 12.dp)
                ) {
                    AdaptiveContent(it)
                }
            }
        }
    }
}

@Composable
fun BoxWithConstraintsScope.AdaptiveContent(imageVector: ImageVector) {

    val icons = listOf(
        Icons.Default.Face,
        Icons.Default.Edit,
        Icons.Default.Face,
        Icons.Default.Email,
        Icons.Default.List,
        Icons.Default.Home
    )

    val badgeSize = 24.dp
    val padding = 24.dp
    val numberOfBadgesToShow = maxWidth.div(badgeSize + padding).toInt().minus(1)
    val remainingBadges = icons.size - numberOfBadgesToShow

    Column(verticalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = "title",
            style = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            modifier = Modifier.padding(end = 10.dp),
            text = "Let the ruling classes tremble at a communist revolution. The proletarians have nothing to lose but their chains. They have a world to win. Workingmen of all countries, unite!",
            maxLines = if (this@AdaptiveContent.maxWidth > 250.dp) 10 else 2,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(space = padding)) {
            icons.take(numberOfBadgesToShow).forEach {
                Icon(
                    modifier = Modifier.size(badgeSize),
                    imageVector = it,
                    contentDescription = "Badge Icon"
                )
            }
            if (remainingBadges > 0) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.LightGray)
                        .padding(6.dp)
                ) {
                    Text(
                        text = "+$remainingBadges"
                    )
                }
            }
        }
    }
}