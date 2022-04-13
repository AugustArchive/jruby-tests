package dev.floofy.jruby

import org.jruby.Ruby
import org.jruby.RubyClass
import org.jruby.RubyObject
import org.jruby.anno.*
import org.jruby.runtime.ThreadContext
import org.jruby.runtime.builtin.IRubyObject

@JRubyClass(name = ["Log"])
class RubyLog(ruby: Ruby, metaClass: RubyClass): RubyObject(ruby, metaClass) {
    private var loggerName: String = "test owo"

    @JRubyMethod(name = ["initialize"], required = 1)
    fun initialize(threadCtx: ThreadContext, name: IRubyObject) {
        println(name)
        loggerName = name.asJavaString()
    }

    @JRubyMethod(name = ["info"], required = 1, optional = 1)
    fun info(threadCtx: ThreadContext, args: List<IRubyObject>): IRubyObject {
        val currentThread = Thread.currentThread().name
        val message = args.first().asJavaString()

        println("[thread $currentThread] [$loggerName] [INFO] :: $message")

        return this
    }
}
