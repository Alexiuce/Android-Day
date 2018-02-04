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

    // setupGameData
    setupGameData();
    // setupGameUI

   setuiGameUI();

    return true;
}
/**  初始化游戏数据 */
void StartScene::setupGameData() {
   SpriteFrameCache::getInstance()->addSpriteFramesWithFile("findAircraft.plist");

}
/** 初始化游戏UI */
void StartScene::setuiGameUI() {
    Size winSize = Director::getInstance()->getWinSize();

    float x = (float) (winSize.width * 0.5);
    float y = (float)(winSize.height * 0.5);

    auto background = Sprite::createWithSpriteFrameName("launchBg.png");
    float scaleX = winSize.width / background->getContentSize().width;
    float scaleY = winSize.height / background->getContentSize().height;
    background->setScale(scaleX,scaleY);
    background->setPosition(x,y);
    this->addChild(background);


    float scale = Director::getInstance()->getContentScaleFactor();

    auto leftSprite = Sprite::createWithSpriteFrameName("leftAircraft.png");
    leftSprite->setScale(scale);
    leftSprite->setAnchorPoint(Vec2(1,1));
    leftSprite->setPosition(Vec2(100 + leftSprite->getContentSize().width, winSize.height - 100));
    CCLOG("sprite position {%f,%f}",leftSprite->getPosition().x,leftSprite->getPosition().y);
    CCLOG("sprite boundingbox {{%f,%f},{%f,%f}}",leftSprite->getBoundingBox().origin.x,leftSprite->getBoundingBox().origin.y,leftSprite->getBoundingBox().size.width,leftSprite->getBoundingBox().size.height);
    this->addChild(leftSprite);

    auto rightSprite = Sprite::createWithSpriteFrameName("leftAircraft.png");
    rightSprite->setScale(scale);
    rightSprite->setAnchorPoint(Vec2(0,1));
    rightSprite->setPosition(Vec2(winSize.width - 100, winSize.height - 100));
    this->addChild(rightSprite);

    CCLOG("content scale %f", Director::getInstance()->getContentScaleFactor());

    auto title = Label::createWithTTF("Find Aircraft", "fonts/Marker Felt.ttf",24);
    title->setPosition(Vec2(winSize.width * 0.5,winSize.height*0.5));

    title->setColor(Color3B::BLACK);
    this->addChild(title);

}