# lib-version
This is a lightweight Java Maven package that provides runtime access to the current version of the library. This is achieved through the following features:

- Programmatically retrieves the current version from `pom.xml`.
- Automatically injects the version into `version.properties` during the Maven build process.

## Installation
To install the library in your Java project, add the following to your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/remla25-team6/lib-version</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>org.remla25team6</groupId>
        <artifactId>lib-version</artifactId>
        <version>1.4.0</version> <!-- or latest -->
    </dependency>
</dependencies>
```

You will also need a `settings.xml` file with GitHub credentials for authentication.

## Usage
After installation, you can retrieve the current version in Java using:

```java
import org.remla25team6.version.VersionUtil;

public class App {
    public static void main(String[] args) {
        System.out.println("Version: " + VersionUtil.getVersion());
    }
}
```

The version is resolved from the `version.properties` file. At build time, Maven replaces this placeholder with the actual version defined in `pom.xml`.

## CI/CD
This project uses GitHub Actions for automated releases. 

### Release
To publish an official release:
1. Ensure all changes are committed and pushed to any desired `release` branch.
2. Tag the commit with a version like `v1.0.0` and push:
    ```bash
    git tag v1.0.0
    git push origin v1.0.0
    ```
3. This triggers the `release.yml` workflow, which:
   * Updates the `pom.xml` version.
   * Builds the Maven package.
   * Publishes it to GitHub Packages.

### Pre-Release
To publish a pre-release:
1. Push a commit to the `main` branch (i.e. merge a pull request to the `main` branch).
2. The `prerelease.yml` workflow automatically runs on every commit to `main`.
3. It builds the package creates a pre-release using the current timestamp (e.g., `0.1.0-pre.20250625.123456`).
4. The packages are available on GitHub packages.

## AI Disclaimer
Used ChatGPT-4o to refine README.