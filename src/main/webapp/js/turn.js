  //配置
        var options = {
            "interval" : 2000,  //间隔时间
            "animatetime" : 500,
            "tween" : "QuadEaseOut",
            "width" : 560
        }
        //得到元素
        var carousel = document.getElementById("carousel");
        var leftBtn = document.getElementById("leftBtn");
        var rightBtn = document.getElementById("rightBtn");
        var circles = document.getElementById("circles");
        var m_unit = document.getElementById("m_unit");
        var imageUL = m_unit.getElementsByTagName("ul")[0];
        var imageLis = imageUL.getElementsByTagName("li");
        var circlesLis = circles.getElementsByTagName("li");

        //克隆前我们得到个数
        var length = imageLis.length;

        //魔术的准备就是克隆第一张li，放到最后
        imageUL.appendChild(imageLis[0].cloneNode(true));

        //信号量
        var idx = 0;

        //自动轮播
        var timer = setInterval(rightBtnHandler,options.interval);
        //鼠标进入停止，离开继续
        carousel.onmouseover = function(){
            clearInterval(timer);
        }
        carousel.onmouseout = function(){
            timer = setInterval(rightBtnHandler,options.interval);
        }

        //监听
        rightBtn.onclick = rightBtnHandler;

        //右按钮的事件处理函数
        function rightBtnHandler(){
            //函数截流
            if(m_unit.isanimated) return;

            //信号量的变化
            idx++;

            //改变小圆点
            changeCircles();

            //运动机构的移动
            animate(m_unit,{"left" : -options.width * idx},options.animatetime,options.tween,function(){
                if(idx > length - 1){
                    idx = 0;
                    m_unit.style.left = "0px";
                }
            });
        }

        //监听
        leftBtn.onclick = function(){
            //函数截流
            if(m_unit.isanimated) return;

            //信号量的变化
            idx--;
            if(idx < 0){
                idx = length - 1;
                m_unit.style.left = -options.width * length + "px";
            }

            //改变小圆点
            changeCircles();

            animate(m_unit,{"left" : -options.width * idx},options.animatetime,options.tween);
        }

        //小圆点的监听
        for (var i = 0; i < circlesLis.length; i++) {
            circlesLis[i].index = i;
            circlesLis[i].onclick = function(){
                //信号量就是自己的序号
                idx = this.index;
                //拉动
                animate(m_unit,{"left" : -options.width * idx},options.animatetime,options.tween);
                //改变小圆点
                changeCircles();
            }
        }


        //根据信号量设置小圆点
        function changeCircles(){
            //idx可能是5，但是我们的小圆点下标最大是4，所以用n过渡一下：
            var n = idx > length - 1 ? 0 : idx;
            //排他
            for (var i = 0; i < circlesLis.length; i++) {
                circlesLis[i].className = "";
            }
            circlesLis[n].className = "cur";
        }