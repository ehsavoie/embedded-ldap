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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to configure an OpenDJ server to be embedded in a test.
 *
 * @author ehugonnet
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateLdapServer {

  /**
   * The configuration ldif file for the OpenDJ server.
   *
   * @return configuration ldif file for the OpenDJ server..
   */
  String ldifConfig() default "config.ldif";

  /**
   * The directory containing the OpenDJ configuration and schemas.
   *
   * @return directory containing the OpenDJ configuration and schemas.
   */
  String serverHome() default "opendj";

  /**
   * The ldif file containing the data to be loaded into the server.
   *
   * @return ldif file containing the data to be loaded into the server.
   */
  String ldifFile();

  /**
   * The backendID of the backend where the ldif will be loaded.
   *
   * @return backendId of the backend where the ldif will be loaded.
   */
  String backendID() default "silverpeas";

  /**
   * The backendID of the backend where the ldif will be loaded.
   *
   * @return backendId of the backend where the ldif will be loaded.
   */
  String baseDN() default "dc=silverpeas,dc=org";
}
