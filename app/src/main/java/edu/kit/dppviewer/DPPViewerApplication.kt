package edu.kit.dppviewer

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Custom Application class for DPP Viewer.
 *
 * This class extends [Application] and is annotated with [@HiltAndroidApp](https://dagger.dev/hilt/)
 * to enable Hilt for dependency injection.
 *
 * @see Application
 * @see HiltAndroidApp
 */
@HiltAndroidApp
class DPPViewerApplication : Application()