class MaprdbCleaner < Formula
  desc "A small tool to clean MapR-DB based on queries"
  homepage "https://github.com/anicolaspp/maprdb-cleaner"
  url "https://github.com/anicolaspp/maprdb-cleaner/releases/download/1.0.0/maprcls.tar"
  sha256 "68a6439668fe74eb4a14a5d19801f5ac2fa167c04dd0655044416471af0bf08a"
  depends_on :java => "1.8+"

  def install
    bin.install "maprdbcls"
    bin.install "maprdbcls-1.0.0.jar"
  end
end