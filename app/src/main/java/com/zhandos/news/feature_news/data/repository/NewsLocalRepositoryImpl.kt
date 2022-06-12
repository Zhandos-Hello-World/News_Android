package com.zhandos.news.feature_news.data.repository

//import androidx.lifecycle.LiveData
//import com.zhandos.news.feature_news.data.data_source.local.NewsDao
//import com.zhandos.news.feature_news.domain.model.Article
//import com.zhandos.news.feature_news.domain.repository.NewsLocalRepository
//
//class NewsLocalRepositoryImpl(private val dao: NewsDao): NewsLocalRepository {
//
//    override fun getAll(): LiveData<List<Article>> {
//        return dao.getAll()
//    }
//
//    override fun getById(id: Long): LiveData<Article> {
//        return dao.getById(id)
//    }
//
//    override suspend fun delete(article: Article) {
//        dao.delete(article)
//    }
//
//    override suspend fun insert(article: Article) {
//        if (article.title != null) {
//            if (dao.getByTitle(article.title).value == null) {
//                dao.insert(article)
//            }
//        }
//    }
//}