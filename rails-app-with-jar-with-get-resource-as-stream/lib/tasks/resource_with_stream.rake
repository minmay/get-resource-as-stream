java_import Java::mvillalobos.jruby.bugs.get.resource.as.stream.io.DataConfiguration

namespace :test do

  desc "Tests resource with stream."
  task resource_with_stream: :environment do
    dataConfiguration = DataConfiguration.load
    puts "id: #{dataConfiguration.info.app.id}, name: #{dataConfiguration.info.app.name}"
  end

end
