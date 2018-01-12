package petersworkshop.petersplayer

import android.annotation.TargetApi
import android.database.Cursor
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import petersworkshop.petersplayer.adapters.SongListAdapter
import petersworkshop.petersplayer.model.SongModel

class MainActivity : AppCompatActivity() {

    var songModelData: ArrayList<SongModel> = ArrayList()
    var songListAdapter: SongListAdapter?=null

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var songCursor: Cursor? = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null,null,null)
        while (songCursor!=null && songCursor.moveToNext()){
            var songName = songCursor.getString(songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
            var songDuration = songCursor.getString(songCursor.getColumnIndex(MediaStore.Audio.Media.DURATION))
            songModelData.add(SongModel(songName,songDuration))
        }
        songListAdapter = SongListAdapter(songModelData)
        var LayoutManager = LinearLayoutManager(applicationContext)


    }
}
