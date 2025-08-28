package dev.nft.apiservice.domain.user.entity

import dev.nft.apiservice.common.util.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "users")
open class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null, // PK는 보통 val (DB가 넣어주는 값)

    @Column(nullable = false)
    var username: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val password: String

) : BaseEntity() {
    companion object {
        @JvmStatic // 자바에서 호출 가능
        fun create(username: String, email: String, password: String) =
            User(username = username, email = email, password = password)
    }

    fun update(username: String) {
        this.username = username
    }
}