package eu.myapplication.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import eu.myapplication.data.remote.dto.TeamMember

@Composable
fun TeamListItem(
    TeamMember:TeamMember,
    modifier: Modifier = Modifier,

){
    Column(modifier = Modifier,
        verticalArrangement = Arrangement.Center) {
        Text(
            text =TeamMember.name,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h4
            )
        Text(
            text = TeamMember.position,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )
    }
}
