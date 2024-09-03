package edu.kit.dppviewer.ui.feature.productpage.product.model

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import edu.kit.dppviewer.ui.feature.productpage.ProductPageNavigationEvent
import edu.kit.dppviewer.ui.feature.productpage.ProductPageUiEvent
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.BaseSection
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.SectionContent
import edu.kit.dppviewer.ui.feature.productpage.product.model.content.tree.EverythingSection
import edu.kit.dppviewer.ui.platform.util.isLandscape
import java.time.LocalDate

/**
 * Represents a filtered product, which can be displayed on the screen.
 */
data class FilteredProduct(
    val name: String,
    val type: ProductType,
    val images: List<Uri>,
    val lastUpdatedDate: LocalDate,
    var sections: List<BaseSection<out SectionContent>>,
    var everythingSection: EverythingSection,
) : Renderable {

    /**
     * Renders the product page for one product.
     * It consists of a header and sections.
     */
    @Composable
    override fun Render(
        onEvent: (ProductPageUiEvent) -> Unit,
        onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
        innerPadding: PaddingValues
    ) {
        val twoColumnLayout = isLandscape(LocalContext.current)
        val scrollState = rememberScrollState()

        if (twoColumnLayout) {
            Row(Modifier.fillMaxHeight()) {
                Column(
                    Modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {
                    ImageHeader(Modifier.weight(1f))
                    Spacer(modifier = Modifier.height(innerPadding.calculateBottomPadding()))
                }

                Column(
                    Modifier
                        .verticalScroll(scrollState)
                        .weight(1f)
                ) {
                    Sections(
                        onEvent = onEvent,
                        onNavigationEvent = onNavigationEvent,
                        innerPadding = innerPadding,
                        modifier = Modifier,
                    )
                    Spacer(modifier = Modifier.height(innerPadding.calculateBottomPadding()))
                }
            }
        } else {
            Column(Modifier.verticalScroll(scrollState)) {
                ImageHeader(
                    Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .padding(8.dp)
                )
                Sections(
                    onEvent = onEvent,
                    onNavigationEvent = onNavigationEvent,
                    innerPadding = innerPadding,
                    modifier = Modifier,
                )
                Spacer(modifier = Modifier.height(innerPadding.calculateBottomPadding()))
            }
        }
    }

    @Composable
    private fun ImageHeader(
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /**
             * Displaying product images if available
             */
            Spacer(modifier = Modifier.padding(8.dp))
            if (images.isNotEmpty()) {
                val pagerState = rememberPagerState(initialPage = 0) { images.size }

                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.weight(1f)
                ) { page ->
                    val painter = rememberAsyncImagePainter(
                        model = images[page]
                    )

                    val painterState = painter.state

                    if (painterState is AsyncImagePainter.State.Error) {
                        val error = painterState.result.throwable
                    } else {
                        Image(
                            painter = painter,
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                }
                Spacer(modifier = Modifier.padding(4.dp))
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp)
                )
            } else {
                /**
                 * Show placeholder image if no images are available
                 */
                val placeholder: Painter = painterResource(id = type.placeholderResID)
                Image(
                    painter = placeholder,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16 / 9f)
                        .padding(8.dp)
                )
            }
        }
    }

    @Composable
    fun HorizontalPagerIndicator(
        pagerState: PagerState,
        modifier: Modifier = Modifier,
        inactiveColor: Color = Color.Gray,
        activeColor: Color = MaterialTheme.colorScheme.primary
    ) {
        val pageCount = pagerState.pageCount

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (page in 0 until pageCount) {
                val isActive = pagerState.currentPage == page
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(if (isActive) activeColor else inactiveColor)
                )
            }
        }
    }

    /**
     * Renders the sections of the product.
     */
    @Composable
    private fun Sections(
        onEvent: (ProductPageUiEvent) -> Unit,
        onNavigationEvent: (ProductPageNavigationEvent) -> Unit,
        innerPadding: PaddingValues,
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier
        ) {
            for (section in sections) {
                Spacer(modifier = Modifier.height(8.dp))
                section.Render(
                    onEvent = onEvent,
                    onNavigationEvent = onNavigationEvent,
                    innerPadding = innerPadding,
                )
            }
        }
    }
}