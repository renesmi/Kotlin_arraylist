package com.example.camera

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.FileProvider
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.URL
import java.security.Permission
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    val REQUST_IMAGE_CAPTURE = 1    //카메라 사진 촬영 요청 코드
    lateinit var curPhotoPath:String//문자열 형태의 사진 경로 값(초기값을 null로 시작하고 싶을 때)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setPermission()

        btn_camera.setOnClickListener{
            takeCapture()

        }



    }
    //카메라 촬영
    private fun takeCapture() {
        //기본 카메라 앱 실행
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also{
                val photoFile: File?=try{
                    createImageFile()
                }catch (ex:IOException){
                    null
                }
                photoFile?.also{
                    val photoURI: Uri =FileProvider.getUriForFile(
                        this,
                        "com.example.camera.fileprovider",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoURI)
                    startActivityForResult(takePictureIntent,REQUST_IMAGE_CAPTURE)
                }
            }
        }
    }
    //이미지 파일 생성
    private fun createImageFile(): File? {
    val timestamp: String=SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir:File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("JPEG_${timestamp}_",".jpg",storageDir)
            .apply{curPhotoPath=absolutePath}
    }
    //테드 퍼미션 설정

    private fun setPermission() {
        val permission=object :PermissionListener{
            override fun onPermissionGranted() {    //설정해놓은 위험 권한들이 허용 되었을 경우 이곳을 수행함
                Toast.makeText(this@MainActivity,"권한이 허용 되었습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(this@MainActivity,"권한이 거부 되었습니다.", Toast.LENGTH_SHORT).show()

            }

        }

        TedPermission.with(this)
            .setPermissionListener(permission)
            .setRationaleMessage("카메라앱을 사용하시려면 권한을 허용해 주세요")
            .setDeniedMessage("권한을 거부하셨습니다...")
            .setPermissions(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA)
            .check()


    }

    //startActivityFor R을 통해서 기본 카에라 앱으로 부터 받아온 사진 결과값
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==REQUST_IMAGE_CAPTURE&&resultCode== Activity.RESULT_OK){//이미지를 성공적으로 가져 왔다면
            val bitmap:Bitmap
            val file = File(curPhotoPath)
            if(Build.VERSION.SDK_INT<28){//안드로이드 버전 확인 왜?
                bitmap=MediaStore.Images.Media.getBitmap(contentResolver,Uri.fromFile(file))
                iv_profile.setImageBitmap(bitmap)
            }else{
                val decode =ImageDecoder.createSource(
                    this.contentResolver,
                    Uri.fromFile(file)
                    
                )
                bitmap = ImageDecoder.decodeBitmap(decode)
                iv_profile.setImageBitmap(bitmap)
            }
            savePhoto(bitmap)
        }
   
    }

    private fun savePhoto(bitmap: Bitmap) {
       val folderPath = Environment.getExternalStorageDirectory().absolutePath+"/Pictures/"
        val timestamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val fileName = "${timestamp}.jpeg"
        val folder=File(folderPath)
        if(!folder.isDirectory) {//현재 해당 경로의 폴더가 존재 하는지 검사
            folder.mkdirs()     //make dir 해달 경로에 폴더 자동으로 생성
        }
        val out = FileOutputStream(folderPath+fileName)
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,out)
        Toast.makeText(this,"사진이 앨범에 저장 완",Toast.LENGTH_SHORT).show()
    }
}
