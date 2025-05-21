echo "Running Stirling PDF with WITHOUT_ENHANCED_FEATURES=${WITHOUT_ENHANCED_FEATURES} and VERSION_TAG=${VERSION_TAG}"
# Check for WITHOUT_ENHANCED_FEATURES and download the appropriate JAR if required
if [ "WITHOUT_ENHANCED_FEATURES" = "false" ] && [ "$VERSION_TAG" != "alpha" ]; then
    if [ ! -f app-security.jar ]; then
        echo "Trying to download from: https://files.stirlingpdf.com/v$VERSION_TAG/Stirling-PDF-with-login.jar"
        curl -L -o app-security.jar https://files.stirlingpdf.com/v$VERSION_TAG/Stirling-PDF-with-login.jar

        # If the first download attempt failed, try without the 'v' prefix
        if [ $? -ne 0 ]; then
            echo "Trying to download from: https://files.stirlingpdf.com/$VERSION_TAG/Stirling-PDF-with-login.jar"
            curl -L -o app-security.jar https://files.stirlingpdf.com/$VERSION_TAG/Stirling-PDF-with-login.jar
        fi

        if [ $? -eq 0 ]; then  # checks if curl was successful
            rm -f app.jar
            ln -s app-security.jar app.jar
            chown stirlingpdfuser:stirlingpdfgroup app.jar || true
            chmod 755 app.jar || true
        fi
    fi
fi
