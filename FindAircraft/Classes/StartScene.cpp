//
// Created by Alexcai on 2018/2/3.
//

#include "StartScene.h"

Scene* StartScene::createScene() {

    return StartScene::create();
}


bool StartScene::init() {
    if (!Scene::init()){
        return false;
    }

    return true;
}