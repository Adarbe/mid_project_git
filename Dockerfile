FROM python:3.6
RUN apk update && \
    apk add  python3.6

ADD card_validation.py /

RUN pip install pystrich

CMD [ "python", "./card_validation.py" ]
