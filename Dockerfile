FROM python:3.6

# Create app directory
WORKDIR /app

RUN pip install -r requirements.txt


RUN curl -fsSLO https://get.docker/builds/Linux/x86_64/docker-17.04.0-ce.tgz \
  && tar xzvf docker-17.04.0-ce.tgz \
  && mv docker/docker /usr/local/bin \
  && rm -r docker docker-17.04.0-ce.tgz

# Bundle app source
COPY src /app

EXPOSE 8080
CMD [ "python", "server.py" ]
