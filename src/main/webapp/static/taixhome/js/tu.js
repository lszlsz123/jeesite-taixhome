
//画节点公共方法
function drawNode(text,positionX,positionY,width,height){
  var node = new JTopo.Node();
  node.text = text; // 文字
  node.textPosition = 'Middle_Center';// 文字居中
  node.textOffsetY = -2; // 文字向下偏移8个像素
  node.font = '18px 微软雅黑'; // 字体
  node.setLocation(positionX, positionY); // 位置
  node.setSize(width, height);  // 尺寸
  node.borderRadius = 4; // 圆角
  //node.borderWidth = 2; // 边框的宽度
  //node.borderColor = '150,150,150'; //边框颜色
  node.fillColor="59,137,255";
  node.fontColor='255,255,255';
  //node.dragable='false';//画布拖动
  //node.alpha = 0.7; //透明度
  node.showSelected = false; // 不显示选中矩形
  scene.add(node);
  scene.translate = false;
  return node;
}

//画节点公共方法1
function drawMyNode(text,positionX,positionY,width,height){
  var node = new JTopo.Node();
  node.text = text; // 文字
  node.textPosition = 'Middle_Center';// 文字居中
  node.textOffsetY = -2; // 文字向下偏移8个像素
  node.font = '18px 微软雅黑'; // 字体
  node.setLocation(positionX, positionY); // 位置
  node.setSize(width, height);  // 尺寸
  node.borderRadius = 4; // 圆角
  //node.borderWidth = 2; // 边框的宽度
  //node.borderColor = '150,150,150'; //边框颜色
  node.fillColor="200,200,200";
  node.fontColor='255,255,255';
  //node.dragable='false';//画布拖动
  //node.alpha = 0.7; //透明度
  node.showSelected = false; // 不显示选中矩形
  scene.add(node);
  scene.translate = false;
  return node;
}

//自定义节点
function drawMyselfNode(text,positionX,positionY,width,height){
  var node = new JTopo.Node("");
  node.percent = 0.8;
  node.beginDegree = 0;
  node.width = width;
  node.height = height;
  node.setLocation(positionX,positionY);
  node.text = text; // 文字
  node.paint = function(g){


    g.beginPath();
    g.fillStyle = '59,137,255';
    //g.arc(0, 0, this.width/2, this.beginDegree, this.beginDegree + 2*Math.PI*this.percent);
    g.moveTo(0,0,0);
    //g.lineTo(100,100,-100,100);
    g.moveTo(100,200);
    g.moveTo(200,0);
    g.lineWidth = 2;
    g.fill();
    g.closePath();
    g.save();



    g.strokeStyle = "#ffffff";
    g.restore();
    this.paintText(g);

  };
  scene.add(node);
  return node;
}
//画小圆形方法
function drawArc(positionX,positionY){
  var circleNode = new JTopo.CircleNode('');
  circleNode.radius = 10; // 半径
  //circleNode.alpha = 0.7;
  circleNode.fillColor = '255, 255, 255'; // 填充颜色
  circleNode.setLocation(positionX,positionY);
  circleNode.textPosition = 'Middle_Center'; // 文本位置
  scene.add(circleNode);
  return circleNode;
}
// 简单连线
function newLink(nodeA, nodeZ, text, dashedPattern){
  var link = new JTopo.Link(nodeA, nodeZ, text);
  link.lineWidth = 2; // 线宽
  link.fontColor="153,193,229";
  link.arrowsRadius = 10; //箭头大小
  link.dashedPattern = dashedPattern; // 虚线
  link.bundleOffset = 60; // 折线拐角处的长度
  link.bundleGap = 20; // 线条之间的间隔
  link.textOffsetY = 3; // 文本偏移量（向下3个像素）
  link.strokeColor = '153,193,229';
  scene.add(link);
  return link;
}
// 简单连线
function newLinkNok(nodeA, nodeZ, text, dashedPattern){
  var link = new JTopo.Link(nodeA, nodeZ, text);
  link.lineWidth = 2; // 线宽
  link.fontColor="153,193,229";
  link.arrowsRadius = 0; //箭头大小
  link.dashedPattern = dashedPattern; // 虚线
  link.bundleOffset = 60; // 折线拐角处的长度
  link.bundleGap = 20; // 线条之间的间隔
  link.textOffsetY = 3; // 文本偏移量（向下3个像素）
  link.strokeColor = '153,193,229';
  scene.add(link);
  return link;
}
 





