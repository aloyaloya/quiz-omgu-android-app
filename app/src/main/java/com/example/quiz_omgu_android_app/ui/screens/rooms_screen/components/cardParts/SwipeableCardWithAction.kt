package com.example.quiz_omgu_android_app.ui.screens.rooms_screen.components.cardParts

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun SwipeableCardWithAction(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    onExpand: () -> Unit = {},
    onCollapse: () -> Unit = {},
    action: @Composable RowScope.() -> Unit,
    content: @Composable () -> Unit
) {
    var actionWidth by remember { mutableFloatStateOf(0f) }
    val offset = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(expanded, actionWidth) {
        offset.animateTo(
            targetValue = if (expanded) -actionWidth else 0f,
            animationSpec = tween(100)
        )
    }

    Box(modifier = modifier.fillMaxWidth().height(IntrinsicSize.Min)) {
        Row(
            modifier = Modifier
                .clipToBounds()
                .align(Alignment.CenterEnd)
                .offset { IntOffset((actionWidth + offset.value).roundToInt(), 0) }
                .onSizeChanged { actionWidth = it.width.toFloat() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            action()
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset { IntOffset(offset.value.roundToInt(), 0) }
                .pointerInput(actionWidth) {
                    var totalDrag = 0f
                    detectHorizontalDragGestures(
                        onDragStart = { totalDrag = 0f },
                        onHorizontalDrag = { _, dragAmount ->
                            totalDrag += dragAmount
                            scope.launch {
                                offset.snapTo((offset.value + dragAmount).coerceIn(-actionWidth, 0f))
                            }
                        },
                        onDragEnd = {
                            scope.launch {
                                if (totalDrag < 0f) {
                                    offset.animateTo(-actionWidth, tween(100))
                                    onExpand()
                                } else {
                                    offset.animateTo(0f, tween(100))
                                    onCollapse()
                                }
                            }
                        }
                    )
                }
        ) {
            content()
        }
    }
}