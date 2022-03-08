package demo.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class DemoRestController {
    @GetMapping("/immediate-response", produces = ["text/plain"])
    fun immediateResponse(): String {
        return "Hi"
    }

    @GetMapping("/delay-response", produces = ["text/plain"])
    fun delayResponse(@RequestParam seconds: String) {

    }
}
