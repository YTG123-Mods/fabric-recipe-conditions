# Obsolete
This project has been made obsolete by the new Fabric API. [https://maven.fabricmc.net/docs/fabric-api-0.46.0+1.18/net/fabricmc/fabric/api/resource/conditions/v1/package-summary.html](More info)

# Fabric Recipe Conditions
Fabric Recipe Conditions is a library that extends recipes with the ability to load conditionally.<br/>
Currently, the conditions are only checked when the resources reload (world load or `/reload`), but most of the built-in
conditions require a restart/reload to even be changed anyway.

## Cloning and Building
### Cloning
- `git clone --recursive https://github.com/YTG1234/fabric-recipe-conditions.git` with HTTPS
- `git clone --recursive git@github.com:YTG1234/fabric-recipe-conditions.git` with SSH
### Building
- `./gradlew build` for a normal system
- `gradlew.bat build` for a Windows system
### Pulling
- `git pull --recurse-submodules`
- `git submodule update --init --recursive --remote --rebase`
### Pushing
- `git push --recurse-submodules=on-demand`

Using Git GUI tools like SourceTree will make pulling and pushing a lot easier.
