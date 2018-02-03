//
// Created by caijinzhu on 2018/2/2.
//


#include "HomeScene.h"

USING_NS_CC;

Scene* HomeScene::createScene() {
    return HomeScene::create();
}

bool HomeScene::init() {
    // super init
    if (!Scene::init()){
        return false;
    }
    auto label = Label::createWithSystemFont("Find Aircraft","AndroidClock",24);
    label->setAnchorPoint(Vec2(0,0));
    label->setPosition(Vec2(100,200));

    this->addChild(label);

    Size winSize = Director::getInstance()->getWinSize();
    printf("win size width= %d, height = %d ",winSize.width,winSize.height);

    return true;
}

