SHELL=/bin/bash

VERSION=0.0.1-SNAPSHOT
IMAGETAG=$(VERSION)
REGISTRY=registry.cn-hangzhou.aliyuncs.com
PROJECT_NAME=spring-boot-configuration-demo
IMAGE=$(REGISTRY)/lisong/${PROJECT_NAME}
VERSIONED_IMAGE=$(IMAGE):$(IMAGETAG)
JAR_FILE=target/${PROJECT_NAME}-$(VERSION).jar
export VERSIONED_IMAGE
export JAR_FILE
# 登陆registry
login:
	docker login --username=songli1988@126.com registry.cn-hangzhou.aliyuncs.com --password=luyou123

# Push to registry. 推送到远程仓库
push:
	docker push $(VERSIONED_IMAGE)

pull:
	docker pull $(VERSIONED_IMAGE)
	
code:
	git reset --hard HEAD && git pull

package: code
	mvn clean package

build: package
	docker build --no-cache -t $(VERSIONED_IMAGE) \
	--build-arg JAR_FILE=$(JAR_FILE) \
	.

test:
	docker run --rm -p 8080:8080 $(VERSIONED_IMAGE)
	
	

start:
	docker-compose up
	
stop:
	docker-compose down

destory: stop
	docker-compose rm
test-env-direct-start:
	docker-compose -f docker-compose-cmd.yml up --force-recreate
test-env-direct-stop:
	docker-compose up -f docker-compose-cmd.yml
# 删除构建失败的镜像
clean:
	docker rmi -f $(docker images | grep "<none>" | awk '{print $3}')
	docker rmi -f $(docker images -f "dangling=true" -q)

.PHONY: push pull package build test start