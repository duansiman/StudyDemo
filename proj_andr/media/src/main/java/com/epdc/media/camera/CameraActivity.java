package com.epdc.media.camera;

import android.content.res.Configuration;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Toast;

import com.epdc.media.R;
import com.epdc.media.SDUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CameraActivity extends AppCompatActivity {


    //为<Interger,Object>这样的Hashmap而专门写的class,目的是提高效率，其核心是折半查找函数（binarySearch）
    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();

    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);
        ORIENTATIONS.append(Surface.ROTATION_90, 0);
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }

    private AutoFitTextureView textureView;

    //摄像头Id 0表示后置，1表示前置
    private String mCameraId = "0";

    //代表摄像头的变量
    private CameraDevice cameraDevice;

    //预览大小
    private Size previewSize;

    //用于创建CaptureRequest类实例
    private CaptureRequest.Builder previewRequestBuilder;

    //用于预览照片的捕捉请求,用于各种参数设置
    private CaptureRequest previewRequest;

    //用于预览、拍照需要改类实例创建Session
    private CameraCaptureSession captureSession;

    private ImageReader imageReader;

    private final TextureView.SurfaceTextureListener mSurfaceTextureListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            //目的是在SurfaceTexture准备好后能够知道
            openCamera(width, height);
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            return false;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {

        }
    };

    //监听拍照过程
    private final CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(CameraDevice camera) {
            //摄像头被打开时
            CameraActivity.this.cameraDevice = camera;
            createCameraPreviewSession();
        }

        @Override
        public void onDisconnected(CameraDevice camera) {
            //摄像头断开连接时
            camera.close();
            CameraActivity.this.cameraDevice = null;
        }

        @Override
        public void onError(CameraDevice camera, int error) {
            //出现错误时
            camera.close();
            CameraActivity.this.cameraDevice = null;
            CameraActivity.this.finish();
        }
    };

    private void createCameraPreviewSession() {
        SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
        surfaceTexture.setDefaultBufferSize(previewSize.getWidth(), previewSize.getHeight());

        try {
            previewRequestBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        //surfaceTexture 作为request目标
        Surface surface = new Surface(surfaceTexture);
        previewRequestBuilder.addTarget(surface);

        try {
            cameraDevice.createCaptureSession(Arrays.asList(surface, imageReader.getSurface()), new CameraCaptureSession.StateCallback(){

                @Override
                public void onConfigured(CameraCaptureSession session) {
                    if (cameraDevice == null) {
                        return;
                    }

                    captureSession = session;

                    //设置自动对焦模式
                    previewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE);

                    //设置自动曝光模式
                    previewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AE_MODE_ON_AUTO_FLASH);

                    //显示相机预览
                    previewRequest = previewRequestBuilder.build();

                    //设置预览连续捕获图像数据
                    try {
                        captureSession.setRepeatingRequest(previewRequest, null, null);
                    } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
                }

                @Override
                public void onConfigureFailed(CameraCaptureSession session) {
                    Toast.makeText(CameraActivity.this, "配置失败", Toast.LENGTH_SHORT).show();
                }
            }, null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }


    private void openCamera(int width, int height) {
        setUpCameraOutputs(width, height);
        CameraManager cameraManager = (CameraManager)getSystemService(CAMERA_SERVICE);
        try {
            cameraManager.openCamera(mCameraId, stateCallback, null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void setUpCameraOutputs(int width, int height) {
        CameraManager cameraManager = (CameraManager)getSystemService(CAMERA_SERVICE);
        try {
            //获取摄像头特性
            CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(mCameraId);
            //支持的配置属性
            StreamConfigurationMap streamConfigurationMap = cameraCharacteristics.get(cameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);

            //支持的最大尺寸
            Size largest = Collections.max(Arrays.asList(streamConfigurationMap.getOutputSizes(ImageFormat.JPEG)), new CompareSizesByArea());

            //用于获取摄像头的图像数据
            imageReader = ImageReader.newInstance(largest.getWidth(), largest.getHeight(),ImageFormat.JPEG, 2);
            imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
                @Override
                //照片数据可用时
                public void onImageAvailable(ImageReader reader) {
                    //获取捕获的照片数据
                    Image image = reader.acquireNextImage();
                    ByteBuffer buffer = image.getPlanes()[0].getBuffer();
                    byte[] bytes = new byte[buffer.remaining()];
                    File file = new File(SDUtil.getExternalPath(), "pic.jpg");
                    buffer.get(bytes);

                    try {
                        FileOutputStream outputStream = new FileOutputStream(file);
                        outputStream.write(bytes);
                        Toast.makeText(CameraActivity.this, "保存："+file, Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        image.close();
                    }
                }
            }, null);

            //获取最佳的预览尺寸
            previewSize = chooseOptimalSize(streamConfigurationMap.getOutputSizes(SurfaceTexture.class), width, height, largest);
            int orientation = getResources().getConfiguration().orientation;
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                textureView.setAspectRatio(previewSize.getWidth(), previewSize.getHeight());
            } else {
                textureView.setAspectRatio(previewSize.getHeight(), previewSize.getWidth());
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private Size chooseOptimalSize(Size[] outputSizes, int width, int height, Size largest) {
        //收集摄像头支持的预览Surface的分辨率
        List<Size> bigEnough = new ArrayList<>();
        int w = largest.getWidth();
        int h = largest.getHeight();

        for (Size option : outputSizes) {
            if (option.getHeight() >= width && option.getHeight() >= height) {
                bigEnough.add(option);
            }
        }

        //找到多个预览尺寸，获取其中面积最小的
        if (bigEnough.size() > 0) {
            return Collections.min(bigEnough, new CompareSizesByArea());
        } else {
            System.out.println("找不到合适的预览尺寸");
            return outputSizes[0];
        }

    }

    static class CompareSizesByArea implements Comparator<Size> {

        @Override
        public int compare(Size lhs, Size rhs) {
            return Long.signum((long)lhs.getWidth()*lhs.getHeight() - (long)rhs.getWidth()*rhs.getHeight());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        textureView = (AutoFitTextureView) findViewById(R.id.texture);
        textureView.setSurfaceTextureListener(mSurfaceTextureListener);

        findViewById(R.id.capture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureStillPicture();
            }
        });
    }

    private void captureStillPicture() {
        if (cameraDevice == null) {
            return;
        }

        //创建拍照
        try {
            CaptureRequest.Builder builder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
            builder.addTarget(imageReader.getSurface());

            //设置自动对焦模式
            builder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE);

            //设置自动曝光模式
            builder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AE_MODE_ON_AUTO_FLASH);

            //获取设备方向
            int rotation = getWindowManager().getDefaultDisplay().getRotation();

            //设置根据设备方向计算照片方向
            builder.set(CaptureRequest.JPEG_ORIENTATION, ORIENTATIONS.get(rotation));
            //停止连续取景
            captureSession.stopRepeating();

            //捕获静态图像
            captureSession.capture(builder.build(), new CameraCaptureSession.CaptureCallback(){
                @Override
                //拍照完成
                public void onCaptureCompleted(CameraCaptureSession session, CaptureRequest request, TotalCaptureResult result) {

                    //重置自动对焦模式
                    previewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AF_MODE_CONTINUOUS_PICTURE);

                    //设置自动曝光模式
                    previewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, CaptureRequest.CONTROL_AE_MODE_ON_AUTO_FLASH);

                    //打开连续取景
                    try {
                        captureSession.setRepeatingRequest(previewRequest, null, null);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                    //super.onCaptureCompleted(session, request, result);
                }
            }, null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}
