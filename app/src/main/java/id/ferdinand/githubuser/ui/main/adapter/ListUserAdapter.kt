package id.ferdinand.githubuser.ui.main.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ferdinand.githubuser.data.model.UserModel
import id.ferdinand.githubuser.databinding.ItemUserBinding
import id.ferdinand.githubuser.ui.main.view.DetailUserActivity

class ListUserAdapter(private val listUser: ArrayList<UserModel>): RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    inner class ListViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserModel){
            binding.tvName.text = item.name
            binding.tvUsername.text = item.username
            binding.ivAvatar.setImageResource(item.avatar)
            binding.clUser.setOnClickListener {
                val i = Intent(binding.clUser.context, DetailUserActivity::class.java)
                i.putExtra("USER", item)
                binding.clUser.context.startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemBinding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = listUser.size
}