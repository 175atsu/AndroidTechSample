package com.example.androidtechsample.ui.groupie

interface EqualableContentsProvider {
  fun providerEqualableContents(): Array<*>

  // equals()とhashCode()の実装を強制する
  override fun equals(other: Any?): Boolean

  override fun hashCode(): Int

  fun isSameContents(other: Any?): Boolean {
    //nullチェック
    other ?: return false
    //これは？
    if (other !is EqualableContentsProvider) return false
    //クラスの参照が一緒かどうか？→インスタンスが一緒かってことかな？
    if (other::class != this::class) return false
    //providerEqualableContentsが一緒かどうか最後にチェック
    return other.providerEqualableContents().contentDeepEquals(this.providerEqualableContents())
  }

  fun contentsHash(): Int {
    return arrayOf(this::class, this.providerEqualableContents()).contentDeepHashCode()
  }
}
