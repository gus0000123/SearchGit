package com.jonghyun.searchgit.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jonghyun.domain.dto.res.Item
import com.jonghyun.searchgit.databinding.RvRepoBinding

class ReposAdapter : ListAdapter<Item, ReposAdapter.ViewHolder>(COMPARATOR) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    class ViewHolder(private val binding: RvRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mItem: Item) {
            binding.apply {
                item = mItem
                executePendingBindings()
            }
        }
    }

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id == newItem.id
            }

            //url(repo url 제외)들은 자주 변경되는 값이 아니므로 2가지 기준을 가지고 같은 아이템인지 판단하였습니다.
            //1. 각종 수치들(fork, issue 등등)
            //2. update, push 일자
            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.html_url == newItem.html_url && oldItem.size == newItem.size
                    && oldItem.stargazers_count == newItem.stargazers_count && oldItem.stargazers_count == newItem.stargazers_count
                    && oldItem.watchers_count == newItem.watchers_count && oldItem.forks_count == newItem.forks_count
                    && oldItem.forks == newItem.forks && oldItem.open_issues == newItem.open_issues
                    && oldItem.watchers == newItem.watchers && oldItem.score == newItem.score
                    && oldItem.updated_at == newItem.updated_at && oldItem.pushed_at == newItem.pushed_at
            }
        }
    }
}