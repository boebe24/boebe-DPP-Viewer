package edu.kit.dppviewer.ui.feature.importproductpage.components.opendialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import edu.kit.dppviewer.R
import edu.kit.dppviewer.ui.feature.importproductpage.util.generateQRCode
import edu.kit.dppviewer.ui.feature.importproductpage.util.getBaseWebsite

/**
 * Defines the content of the [OpenDialog].
 *
 * @param url The URL used for the QR-Code generation.
 */
@Composable
fun OpenDialogContent(url: String) {
    val qrCodeBitmap = generateQRCode(url, 500)
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoxWithConstraints {
            val minDimension = if (maxWidth < maxHeight) {
                Modifier.size(200.dp)
            } else {
                Modifier.fillMaxHeight()
            }
            Image(
                bitmap = qrCodeBitmap.asImageBitmap(),
                contentDescription = "QR Code",
                modifier = minDimension
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.scan_qr_code_endpoint_text),
                fontWeight = FontWeight.Bold
            )
            Text(text = getBaseWebsite(url))
        }
    }
}