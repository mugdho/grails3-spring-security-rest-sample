package io.snowcrash.gossamer

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.crypto.KeyGenerator
import java.security.SecureRandom
import org.springframework.security.crypto.keygen.KeyGenerators

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
	String salt
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

    Long id
    Date dateCreated
    Date lastUpdated
    Long version

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this)*.role
	}

	def beforeInsert() {
        createSalt()
        encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

    private void createSalt() {
        salt = KeyGenerators.string().generateKey()
    }

	static transients = ['springSecurityService']

	static constraints = {
		password blank: false, password: true
		username blank: false, unique: true
        salt nullable: true
	}

	static mapping = {
        table '`user`'
        version true
		password column: '`password`'
	}
}
