package gossamer

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class InfoController {

    def index() {
        def resp = [
            color: "green",
            message: "Echo of a command",
            notify: "false",
            message_format: "text"
        ]

        render resp as JSON

    }
}
