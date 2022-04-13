package dev.floofy.jruby

import org.jruby.*
import org.jruby.runtime.ObjectAllocator

object Jruby {
    private val ruby: Ruby = Ruby.newInstance()

    @JvmStatic
    fun main(args: Array<String>) {
        println("hello world from kotlin :<")

        ruby.executeScript("""
        puts 'hello world from ruby :3'
        """, "current.rb")

        val module = ruby.getOrCreateModule("Noel")
        module.defineClassUnder("Logging", ruby.getObject(), object: ObjectAllocator {
            override fun allocate(runtime: Ruby, metaClass: RubyClass) = RubyLog(runtime, metaClass)
        })

        ruby.executeScript("""
        # Noel::Logging.info "hello world :o"
        log = Noel::Logging::new
        Noel::Logging::new "shit"
        # log.info "hello world from ruby script v2"
        """, "new_name.rb")
    }
}
