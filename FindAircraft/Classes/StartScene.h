//
// Created by Alexcai on 2018/2/3.
//

#ifndef PROJ_ANDROID_STUDIO_STARTSCENE_H
#define PROJ_ANDROID_STUDIO_STARTSCENE_H

#include "cocos2d.h"

USING_NS_CC;

class StartScene : Scene {
public:
    static Scene* createScene();
    bool init();
    CREATE_FUNC(StartScene)

private:
    void setupGameData();
    void setuiGameUI();

};


#endif //PROJ_ANDROID_STUDIO_STARTSCENE_H
