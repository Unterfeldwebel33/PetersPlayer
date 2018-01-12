package petersworkshop.petersplayer.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import petersworkshop.petersplayer.R
import petersworkshop.petersplayer.model.SongModel


class SongListAdapter(SongModel:ArrayList<SongModel>): RecyclerView.Adapter<SongListAdapter.SongListViewHolder>() {

    var mSongModel = SongModel

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SongListViewHolder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.music_row,parent,false)
        return SongListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mSongModel.size
    }

    override fun onBindViewHolder(holder: SongListViewHolder?, position: Int) {
        var model = mSongModel[position]
        var songName = model.mSongName
        var songDuration = model.mSongDuration
        holder!!.songTV.text = songName
        holder.durationTV.text = songDuration


    }

    class SongListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var songTV: TextView
        var durationTV: TextView
        var albumArt: ImageView
        init {
            songTV = itemView.findViewById(R.id.song_name_tv)
            durationTV = itemView.findViewById(R.id.song_duration_tv)
            albumArt = itemView.findViewById(R.id.al_img_view)
        }
    }

}