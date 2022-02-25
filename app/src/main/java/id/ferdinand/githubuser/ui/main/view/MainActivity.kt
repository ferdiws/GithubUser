package id.ferdinand.githubuser.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ferdinand.githubuser.R
import id.ferdinand.githubuser.data.model.UserModel
import id.ferdinand.githubuser.databinding.ActivityMainBinding
import id.ferdinand.githubuser.ui.main.adapter.ListUserAdapter
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<UserModel>()
    private lateinit var adapter: ListUserAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myToolbar.tvTitle.text = getString(R.string.list_user_title)
        binding.rvUser.setHasFixedSize(true)

        list.addAll(listUsers)
        adapter = ListUserAdapter(list)
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        binding.rvUser.adapter = adapter
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