FROM alpine:latest
RUN adduser -S sparkuser
USER sparkuser 
EXPOSE 4567
ENTRYPOINT [ "/work/init.sh", "/work/full" ]
COPY init.sh full /work/

