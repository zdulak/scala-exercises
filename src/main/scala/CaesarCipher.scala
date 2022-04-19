object CaesarCipher {
  def cesar(str: String, offset: Int): String = {
    str.map(letter => (((letter.toInt - 97) + offset) % 26 + 97).toChar)
  }

}
