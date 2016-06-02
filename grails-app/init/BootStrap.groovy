import io.snowcrash.gossamer.Role
import io.snowcrash.gossamer.User
import io.snowcrash.gossamer.UserRole

class BootStrap {

    def init = { servletContext ->
        [
            'ROLE_ADMIN', 'ROLE_USER'
        ].each { new Role(authority: it).save(failOnError: true, flush: true)}

        // Change this for actual production usage
        def user = new User(username: 'user', password: 'password').save(failOnError: true, flush: true)

        def userRole = UserRole.create(user, Role.findByAuthority('ROLE_ADMIN')).save(failOnError: true)
    }
    def destroy = {
    }
}
