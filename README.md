# lib-version
This is a Java Maven package that reports the current version of this package.
The repository has a github actions workflow which builds and uploads the package to the Github Packages repository. This action is triggered when a version tag (starting with "v" e.g. "v1.0.0") is pushed to the repo. It will also automatically change the version in `pom.xml`.

## Gen-AI declaration
I used gpt-4o to help generate the `release.yml` file, specifically the logic to authenticate with the Github Packages registry.