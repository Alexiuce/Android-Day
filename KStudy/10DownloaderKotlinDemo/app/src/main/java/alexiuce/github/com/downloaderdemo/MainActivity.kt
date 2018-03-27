package alexiuce.github.com.downloaderdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mFile: DownloadFileInfo = DownloadFileInfo("","","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupData()
        setupEventHandle()
    }


    private fun setupUI(){
        textView.text = "good file name"
    }
    private fun setupData(){
        val path = Environment.getExternalStorageDirectory().absolutePath + "/myDownload/"
        mFile = DownloadFileInfo("node-v8.10.0.pkg",
                "https://nodejs.org/dist/v8.10.0/node-v8.10.0.pkg",
                path)
    }
    private fun setupEventHandle(){
        button.setOnClickListener{
            println("click button")
            val intent = Intent(this,DownloadService::class.java)
            intent.action = DownloadService.ActionStart
            intent.putExtra("fileInfo",mFile)
            startService(intent)
        }
    }
}
