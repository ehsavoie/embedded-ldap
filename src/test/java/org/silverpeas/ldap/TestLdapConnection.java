/**
 * Copyright (C) 2000 - 2012 Silverpeas
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 */
package org.silverpeas.ldap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.junit.ClassRule;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
@CreateLdapServer(ldifConfig = "opendj/config/config.ldif", serverHome = "opendj", ldifFile =
"silverpeas-ldap.ldif")
public class TestLdapConnection {

  @ClassRule
  public static OpenDJRule ldapRule = new OpenDJRule();

  @Test
  public void testSimpleSearch() throws Exception {
    Hashtable<String, String> env = new Hashtable<String, String>(4);
    env.put(Context.INITIAL_CONTEXT_FACTORY,
        "com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.PROVIDER_URL, "ldap://localhost:1389/dc=silverpeas,dc=org");
    env.put(Context.SECURITY_PRINCIPAL, "cn=Directory Manager,cn=Root DNs,cn=config");
    env.put(Context.SECURITY_CREDENTIALS, "password");
    DirContext ctx = new InitialDirContext(env);
    System.out.println(ctx.getAttributes("uid=user.0,ou=People"));
    Attributes attrs = ctx.getAttributes("uid=user.0,ou=People");
    assertThat(attrs.get("givenName").get().toString(), is("Nicolas"));
    assertThat(attrs.get("postalCode").get().toString(), is("50369"));
    assertThat(attrs.get("sn").get().toString(), is("EYSSERIC"));

  }
}
