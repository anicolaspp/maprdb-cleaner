class MaprdbCleaner < Formula
  desc "A small tool to clean MapR-DB based on queries"
  homepage "https://github.com/anicolaspp/maprdb-cleaner"
  url "https://github.com/anicolaspp/maprdb-cleaner/releases/download/1.0.0/maprcls.tar"
  sha256 "afa172dd9a1cf5ca2182b5660d8b0e588d036662a3d56b18e38274fc7158b601"
  depends_on :java => "1.8+"

  def install
    bin.install "maprdbcls.sh"
    bin.install "maprdbcls-1.0.0.jar"
  end
end