package id.ferdinand.githubuser.ui.main.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import id.ferdinand.githubuser.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_DISPLAY_LENGTH = 1000
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = Color.WHITE

        Handler(Looper.getMainLooper()).postDelayed({
//            val session = SessionManager(applicationContext)
//            if (!session.isLoggedIn()) {
//                val mainIntent = Intent(this, LoginActivity::class.java)
//                this.startActivity(mainIntent)
//                this.finish()
//            } else {
//                val mainIntent = Intent(this, MainActivity::class.java)
//                this.startActivity(mainIntent)
//                this.finish()
//            }
            val mainIntent = Intent(this, MainActivity::class.java)
            this.startActivity(mainIntent)
            this.finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}