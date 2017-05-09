package mvillalobos.jruby.bugs.get.resource.as.stream.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.InputStream;

public class DataConfiguration {

	private Info info;

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public static DataConfiguration load() {
		return load("/data.yml");
	}

	public static DataConfiguration load(String resource) {
		final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		try (InputStream inputStream = DataConfiguration.class.getResourceAsStream(resource == null ? "/data.yml" : resource)) {
			final DataConfiguration dataConfiguration = mapper.readValue(inputStream, DataConfiguration.class);
			return dataConfiguration;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load data yaml.", e);
		}
	}

	public static class Info {

		private App app;

		public App getApp() {
			return app;
		}

		public void setApp(App app) {
			this.app = app;
		}

		public static class App {

			private long id;
			private String name;

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}
		}
	}
}
