/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.sebersole.pg.junit5.functional.dialect;

import java.util.Arrays;
import java.util.stream.Stream;

import org.hibernate.sebersole.pg.junit5.stubs.H2Dialect;
import org.hibernate.sebersole.pg.junit5.testing.RequiresDialect;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Andrea Boriero
 */
@RequiresDialect(dialectClass = H2Dialect.class)
public class ParameterizedRequiresDialectOnClassMatch extends AbstractDialectFilteringTest {
	@ParameterizedTest
	@ValueSource(strings = { "First execution", "Second Execution" })
	public void shouldExecute(String arguments) {
		System.out.println( "Correctly executed test " + arguments );
	}

	@ParameterizedTest
	@MethodSource("getParameters")
	public void shouldExecuteWithParameterizedMethodSource(String arguments) {
		System.out.println( "Correctly executed test " + arguments );
	}

	public Stream getParameters(){
		return Arrays.asList( "Another execution", "Last execution").stream();
	}
}
