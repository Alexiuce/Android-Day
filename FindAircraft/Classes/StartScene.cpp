//
// Created by Alexcai on 2018/2/3.
//

#include "StartScene.h"

static const int LeftTag = 100;
static const int RightTag =101;
static const int DownTag = 102;

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
    //
    startAnimation();

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
    leftSprite->setTag(LeftTag);
    leftSprite->setScale(scale);
    leftSprite->setAnchorPoint(Vec2(0,1));
    leftSprite->setPosition(Vec2(35, winSize.height - 100));
    CCLOG("sprite position {%f,%f}",leftSprite->getPosition().x,leftSprite->getPosition().y);
    CCLOG("sprite boundingbox {{%f,%f},{%f,%f}}",leftSprite->getBoundingBox().origin.x,leftSprite->getBoundingBox().origin.y,leftSprite->getBoundingBox().size.width,leftSprite->getBoundingBox().size.height);
    this->addChild(leftSprite);

    auto rightSprite = Sprite::createWithSpriteFrameName("leftAircraft.png");
    rightSprite->setTag(RightTag);
    rightSprite->setScale(scale);
    rightSprite->setAnchorPoint(Vec2(1,1));
    rightSprite->setPosition(Vec2(winSize.width - 30, winSize.height - 100));
    this->addChild(rightSprite);

    CCLOG("right {{%f%f,},{%f%f}}", rightSprite->getBoundingBox().origin.x,rightSprite->getBoundingBox().origin.y,rightSprite->getBoundingBox().size.width,rightSprite->getBoundingBox().size.height);

    auto downSprite = Sprite::createWithSpriteFrameName("downCraft.png");
    downSprite->setTag(DownTag);
    downSprite->setScale(scale);
    downSprite->setPosition(Vec2(x,y));
    this->addChild(downSprite);

}

void StartScene::startAnimation() {
    Size winSize = Director::getInstance()->getWinSize();
    auto leftSprite = this->getChildByTag(LeftTag);
    auto rightSprite = this->getChildByTag(RightTag);
    auto downSprite = this->getChildByTag(DownTag);
    Node * spriteArray[] = {leftSprite,rightSprite,downSprite};
    for (int i = 0; i < 3; ++i) {
        auto node = spriteArray[i];
        auto moveTo = MoveTo::create(1.0,Vec2(node->getPosition().x,winSize.height + node->getBoundingBox().size.height + 10));

        auto callFunc = CallFunc::create([node](){
            node->removeFromParent();
            CCLOG("call func finished");
        });
        auto sequence = Sequence::create(moveTo,callFunc,NULL);
        node->runAction(sequence);
    }

}