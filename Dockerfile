FROM adoptopenjdk/openjdk11:ubi

WORKDIR /var/opt/LetsJavaSpringBoot

# Copy the entire project into the container
COPY . /var/opt/LetsJavaSpringBoot

# Set execute permissions for the mvnw script
RUN chmod +x mvnw

# Use a shell to run multiple commands
CMD ["/var/opt/LetsJavaSpringBoot/mvnw", "spring-boot:run"]