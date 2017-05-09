package mvillalobos.jruby.bugs.get.resource.as.stream.io;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DataConfigurationTest {

	@Test
	public void testDataConfiguration() {
		final DataConfiguration dataConfiguration = DataConfiguration.load();
		assertNotNull(dataConfiguration);
		assertNotNull(dataConfiguration.getInfo());
		assertNotNull(dataConfiguration.getInfo().getApp());
		assertEquals(1L, dataConfiguration.getInfo().getApp().getId());
		assertEquals("Test", dataConfiguration.getInfo().getApp().getName());
	}
}
