package id.ferdinand.githubuser.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ferdinand.githubuser.R
import id.ferdinand.githubuser.data.model.UserModel
import id.ferdinand.githubuser.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding
    private lateinit var user: UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myToolbar.tvTitle.text = getString(R.string.detail_user_title)

        user = intent.getParcelableExtra("USER")!!

        binding.ivAvatar.setImageResource(user.avatar)
        binding.tvName.text = user.name
        binding.tvUsername.text = user.username
        binding.tvCompany.text = getString(R.string.company, user.company)
        binding.tvLocation.text = getString(R.string.location, user.location)
        binding.tvRepository.text = getString(R.string.repository, user.repository)
        binding.tvFollower.text = getString(R.string.follower, user.follower)
        binding.tvFollowing.text = getString(R.string.following, user.following)
    }
}