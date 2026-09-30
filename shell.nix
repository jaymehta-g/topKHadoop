{
  pkgs ? import <nixpkgs> { },
}:

pkgs.mkShell {
  packages = with pkgs; [
    # Java toolchain
    jdk17 # JDK (java compiler, runtime, jshell, etc.)
    maven
    gradle # Build tool

    # Commonly useful alongside Gradle projects
    git
    jq # handy for parsing JSON output (e.g. REST APIs)
    curl

    # start infra
    opentofu
  ];

  shellHook = ''
    echo "Java devshell"
    echo "  java:  $(java -version 2>&1 | head -1)"
    echo "  gradle: $(gradle --version | grep -m1 Gradle)"
    echo

    # Keep Gradle caches/traces out of the project dir when safe
    export GRADLE_USER_HOME="''${GRADLE_USER_HOME:-$HOME/.gradle}"
  '';
}