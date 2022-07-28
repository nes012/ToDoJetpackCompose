package anzhy.dizi.todojetpackcompose.data.models

import androidx.compose.ui.graphics.Color
import anzhy.dizi.todojetpackcompose.ui.theme.HighPriorityColor
import anzhy.dizi.todojetpackcompose.ui.theme.LowPriorityColor
import anzhy.dizi.todojetpackcompose.ui.theme.MediumPriorityColor
import anzhy.dizi.todojetpackcompose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}