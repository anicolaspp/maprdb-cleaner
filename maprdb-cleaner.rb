class MaprdbCleaner < Formula
  desc "A small tool to clean MapR-DB based on queries"
  homepage "https://github.com/anicolaspp/maprdb-cleaner"
  url "https://github.com/anicolaspp/maprdb-cleaner/releases/download/1.0.1/maprcls.tar"
  sha256 "44590a86c787034e45b406d96f938e4cda827c62ddd08d0696db473e0e89ad2b"
  depends_on :java => "1.8+"

  def install
    bin.install "maprdbcls"
    bin.install "maprdbcls-1.0.1.jar"
  end
end