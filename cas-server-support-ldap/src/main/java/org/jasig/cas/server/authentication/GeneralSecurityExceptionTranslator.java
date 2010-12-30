/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jasig.cas.server.authentication;

import org.springframework.ldap.AuthenticationException;

import javax.naming.NamingException;
import java.security.GeneralSecurityException;

/**
 * Maps the exceptions returned from an LDAP Authentication attempt to a GeneralSecurityException.
 *
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 4.0.0
 */
public interface GeneralSecurityExceptionTranslator {

    /**
     * Maps the Spring LDAP Authentication Exception to a GeneralSecurityException.
     * <p>
     * It should be safe to return null, but highly discouraged. Most instances should return UncategorizedSecurityException.
     *
     * @param e the exception to map.  CANNOT be NULL.
     * @return the mapped GeneralSecurityException, or an UncategorizedSecurityException if there is no proper mapping.
     */
    GeneralSecurityException translateExceptionIfPossible(AuthenticationException e);

    /**
     * Maps the NamingException to a GeneralSecurityException.
     * <p>
     * It should be safe to return null, but highly discouraged.  Most instances should return UncategorizedSecurityException.
     *
     * @param e the exception to map.  CANNOT be NULL.
     * @return the mapped GeneralSecurityException, or an UncategorizedSecurityException if there is no proper mapping.
     */
    GeneralSecurityException translateExceptionIfPossible(NamingException e);
}
