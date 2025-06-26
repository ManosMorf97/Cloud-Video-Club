#!/bin/bash

cd ~/Cloud-VideoClub/Deployment
kubectl delete svc backend-service -n videoclub
kubectl delete deployment backend-deployment -n videoclub
kubectl delete svc frontend-service -n videoclub
kubectl delete deployment frontend-deployment -n videoclub
cd ~/Cloud-VideoClub/movies
docker build . -t manosmorf97/backend-videoclub
docker push manosmorf97/backend-videoclub
docker build . -t manosmorf97/frontend-videoclub
docker push manosmorf97/frontend-videoclub
cd ~/Cloud-VideoClub/Deployment
kubectl apply -f backend-deployment.yaml
kubectl apply -f backend-service.yaml
kubectl apply -f frontend-deployment.yaml
kubectl apply -f frontend-service.yaml
