class MaprdbCleaner < Formula
  desc "A small tool to clean MapR-DB based on queries"
  homepage "https://github.com/anicolaspp/maprdb-cleaner"
  url "https://github.com/anicolaspp/maprdb-cleaner/releases/download/1.0.1/maprdbcls.tar"
  sha256 "fc778d7b3ddb756af7d485c5e59dc4d62e129f57c98188f705dd1050eb880824"
  depends_on :java => "1.8+"

  def install
    bin.install "maprdbcls"
    bin.install "maprdbcls-1.0.1.jar"
  end
end