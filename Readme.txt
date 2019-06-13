Архив docker_files.rar содержит директорию docker_files с файлами, необходимыми для сборки образов докера.
Dockerfile-base - базовый файл, на основе которого создаются Dockerfile-master и Dockerfile-worker.
Dockerfile-master - файл, на котором разворачивается основной процесс. На этом образе поднимается ssh-сервер для обеспечения взаимодействия между master-нодой и worker-нодами.
Dockerfile-worker - на основе этого файла создаётся образ worker'а.
build.sh - скрипт, запускающий процедуру сборки образов докера из соответствующих файлов.

После получения образов необходимо запустить их, установить соединение с мастером командой docker exec -it lab5_master_1 /bin/bash.
После установления соединения следует запустить скрипт parallel-init.sh.

Для запуска программы в режиме standalone необходимо выполнить команду :
./bin/spark-submit --master $MASTER /tmp/lab5.jar

Для запуска программы в режиме over Yarn  необходимо выполнить команду
./bin/spark-submit --master yarn --deploy-mode cluster /tmp/lab5.jar