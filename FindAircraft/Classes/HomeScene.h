//
// Created by caijinzhu on 2018/2/2.
//

#ifndef PROJ_ANDROID_STUDIO_HOMESCENE_H
#define PROJ_ANDROID_STUDIO_HOMESCENE_H


#include "cocos2d.h"

class HomeScene : public cocos2d::Scene {

public:
    static cocos2d::Scene* createScene();

    virtual bool init();

    CREATE_FUNC(HomeScene);

};


#endif //PROJ_ANDROID_STUDIO_HOMESCENE_H
