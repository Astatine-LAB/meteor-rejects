## Description
This PR addresses a critical startup crash and introduces important security enhancements. 
* **Dependency Fix:** Properly embeds the `exploit-preventer-api` to resolve a `NoClassDefFoundError` that occurred when launching the game without the Exploit Preventer mod installed.
* **Security Enhancements:** Stabilizes sensitive code structures to prevent the accidental leakage of personal information.

## Related Issue
N/A

## Motivation and Context
The crash happened because `ServerSpoofMixin` relied on the `ExploitPreventer` API, but the API wasn't included in the built JAR. This caused the game to crash immediately for anyone not using the external mod. To fix this, I've properly embedded the API dependency in the build.

Alongside this, I've updated some sensitive code structures to ensure user personal details are better protected from accidental exposure.

## How Has This Been Tested?
- Compiled and ran the client locally without the external mod to confirm the API is properly embedded and the startup crash is gone.
- Checked that the new privacy logic works as intended without breaking existing features like Yggdrasil login.

## Screenshots (if appropriate)
N/A

## Types of changes
- [x] Bug fix (non-breaking change which fixes an issue)
- [ ] New feature (non-breaking change which adds functionality)
- [ ] Breaking change (fix or feature that would cause existing functionality to change)
- [x] My code follows the code style of this project.
- [x] I have successfully ran tests with my changes locally.