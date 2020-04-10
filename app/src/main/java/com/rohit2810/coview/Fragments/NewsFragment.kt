package com.rohit2810.coview.Fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rohit2810.coview.News.Model.Article
import com.rohit2810.coview.News.Model.Source
import com.rohit2810.coview.News.NewsAdapter
import com.rohit2810.coview.News.NewsViewModel
import com.rohit2810.coview.R
import kotlinx.android.synthetic.main.fragment_news.*
import org.w3c.dom.Text
import java.lang.Exception


class NewsFragment : Fragment() {

    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        newsViewModel = ViewModelProvider(this).get(newsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var article4 = Article(
            source = Source(1, "Ndtv.com"),
            title = "37 Deaths, 896 New Coronavirus Cases In 24 Hours In India - NDTV News",
            urlToImage = "https://c.ndtvimg.com/2020-04/pvi9t72o_coronavirusindiamasks-generic-afp_625x300_04_April_20.jpg"
        )

        newsAdapter = NewsAdapter(view.context)
        newsAdapter.setArray(createArticles())
        val recyclerView: RecyclerView = view.findViewById(R.id.main_news_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = newsAdapter
        val dividerItemDecoration: DividerItemDecoration = DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
        val imageView: ImageView = view.findViewById(R.id.main_news_image)
        Glide.with(view.context).load(article4.urlToImage).into(imageView)
        val textView: TextView = view.findViewById(R.id.main_news_title)
        textView.text = article4.title

    }

    fun createArticles(): List<Article> {


        var article2 = Article(
            source = Source(1, "The Times of India"),
            title = "Lockdown should continue, Punjab will allow district-wise relief to farmers: Amarinder Singh - Times of India",
            urlToImage = "https://static.toiimg.com/thumb/msid-75080558,width-1070,height-580,imgsize-158487,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg"
        )

        var article3 = Article(
            source = Source(1, "Livemint.com"),
            title = "India registers 896 fresh coronavirus cases today, highest one-day jump - Livemint",
            urlToImage = "https://images.livemint.com/img/2020/04/10/600x338/PTI10-04-2020_000105B_1586520780830_1586520796497.jpg"
        )
        var article1 = Article(
            source = Source(1, "Thewire.in"),
            title = "How Will Modi and the Chief Ministers Get Us Out of the Coronavirus Chakravyuh? - The Wire",
            urlToImage = "https://cdn.thewire.in/wp-content/uploads/2020/04/10165124/2020-04-08T103101Z_2_LYNXMPEG370W6_RTROPTP_4_HEALTH-CORONAVIRUS-INDIA-BANGLADESH-800x400.jpg"
        )
        var article5 = Article(
            source = Source(1, "The Times of India"),
            title = "Covid-19: Purab Kohli thanks people for sending their wishes; assures 'We are very well and fully recover - Times of India",
            urlToImage = "https://static.toiimg.com/thumb/msid-75081529,width-1070,height-580,overlay-toi_sw,pt-32,y_pad-40,resizemode-75,imgsize-221950/75081529.jpg"
        )


        var list = arrayListOf<Article>()
        list.add(article1)
        list.add(article2)
        list.add(article3)
        list.add(article5)

        return list

    }
}
