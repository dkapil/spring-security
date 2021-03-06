/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.security.oauth2.core.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rob Winch
 */
public class TestOAuth2Users {

	public static DefaultOAuth2User create() {
		List<GrantedAuthority> roles = AuthorityUtils.createAuthorityList("ROLE_USER");
		String attrName = "username";
		Map<String, Object> attributes = new HashMap<>();
		attributes.put(attrName, "user");
		return new DefaultOAuth2User(roles, attributes, attrName);
	}
}
