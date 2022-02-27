package id.ferdinand.githubuser.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ferdinand.githubuser.R
import id.ferdinand.githubuser.data.model.UserModel
import id.ferdinand.githubuser.databinding.ActivityMainBinding
import id.ferdinand.githubuser.ui.main.adapter.ListUserAdapter
import id.ferdinand.githubuser.ui.main.adapter.ListUserMainAdapter
import id.ferdinand.githubuser.ui.main.viewmodel.SearchViewModel
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<UserModel>()
    private lateinit var adapter: ListUserAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var listAdapter: ListUserMainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myToolbar.tvTitle.text = getString(R.string.list_user_title)
        binding.rvUser.setHasFixedSize(true)
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        list.addAll(listUsers)
        listAdapter = ListUserMainAdapter(list)
        binding.rvUser.adapter = listAdapter
        binding.rvUser.visibility = View.VISIBLE

        val inputText = binding.etSearch.editText?.text.toString()
        binding.etSearch.editText?.doOnTextChanged { inputText, _, _, _ ->
            if (!inputText.isNullOrEmpty()) {
                binding.progressBar.visibility = View.VISIBLE
                binding.rvUser.visibility = View.GONE
                binding.tvNotFound.visibility = View.GONE
                searchViewModel.getSearchData(inputText.toString()).observe(this, {
                    if (it.totalCount != 0) {
                        val data = it.items
                        adapter = ListUserAdapter(data)
                        binding.rvUser.adapter = adapter
                        binding.progressBar.visibility = View.GONE
                        binding.rvUser.visibility = View.VISIBLE
                        binding.tvNotFound.visibility = View.GONE
                    } else {
                        binding.progressBar.visibility = View.GONE
                        binding.tvNotFound.visibility = View.VISIBLE
                        binding.rvUser.visibility = View.GONE
                    }
                })
            } else {
                binding.rvUser.visibility = View.GONE
                binding.progressBar.visibility =View.GONE
                binding.tvNotFound.visibility = View.GONE
            }
        }
    }

    private val listUsers: ArrayList<UserModel>
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataFollower = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataRepository = resources.getStringArray(R.array.repository)
            val listUser = ArrayList<UserModel>()
            for (i in dataName.indices){
                val user = UserModel(dataName[i], dataUsername[i], dataAvatar.getResourceId(i, -1),
                    dataCompany[i], dataLocation[i], dataRepository[i], dataFollower[i], dataFollowing[i])
                listUser.add(user)
            }
            return listUser
        }
}