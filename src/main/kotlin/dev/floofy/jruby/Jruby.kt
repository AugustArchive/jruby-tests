package dev.floofy.jruby

import org.jruby.Ruby

object Jruby {
    private val ruby: Ruby = Ruby.newInstance()

    @JvmStatic
    fun main(args: Array<String>) {
        println("hello world from kotlin :<")

        ruby.executeScript("""
        puts 'hello world from ruby :3'
        """, "current.rb")
    }
}
