package com.yl.study.camera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.CameraX
import androidx.camera.core.Preview
import androidx.camera.core.impl.ImageAnalysisConfig
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.yl.study.databinding.ActivityCameraBinding
import kotlinx.android.synthetic.main.activity_camera.*

class CameraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCameraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createCamera()

    }

    private fun createCamera() {
        val processCameraProvider = ProcessCameraProvider.getInstance(this)
        processCameraProvider.addListener(
            Runnable {
                val cameraProvider = processCameraProvider.get()
                bindPreview(cameraProvider)

            }, ContextCompat.getMainExecutor(this)
        )

    }

    private fun bindPreview(cameraProvider: ProcessCameraProvider) {
        cameraProvider.unbindAll()

        val preview: Preview = Preview.Builder()
            .build()
        //后置相机。
        val cameraSelector: CameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()

        var camera = cameraProvider.bindToLifecycle(this as LifecycleOwner, cameraSelector, preview)


        preview.setSurfaceProvider(previewView.surfaceProvider)



    }
    //Analysis和Priview中设置的分辨率可以不同，这说明分析图片和预览图片是可以分开应用的。
//    private fun getAnalysis(): ImageAnalysisConfig {
//         analysisConfig =  ImageAnalysisConfig.Builder()
//            .setCallbackHandler(new Handler(handlerThread.getLooper()))
//            .setLensFacing(CameraX.LensFacing.BACK)
//            .setImageReaderMode(ImageAnalysis.ImageReaderMode.ACQUIRE_LATEST_IMAGE)
//            .setTargetResolution(new Size(480, 640))
//        .build();
//        ImageAnalysis imageAnalysis = new ImageAnalysis(analysisConfig);
//        imageAnalysis.setAnalyzer(this);
//        return imageAnalysis;
//    }
//
//    private fun getPreview():Preview {
//        //这里给出的分辨率，并不是最终的值，CameraX会根据设备的支持情况，设置一个最接近你给定参数的值。
//        PreviewConfig previewConfig=  PreviewConfig.Builder().
//        setTargetResolution(new Size(480, 640)).
//        setLensFacing(CameraX.LensFacing.BACK).build();
//         preview = new Preview(previewConfig);
//        preview.setOnPreviewOutputUpdateListener(this);
//        return preview;
//    }

}