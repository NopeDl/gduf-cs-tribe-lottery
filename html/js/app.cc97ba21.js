(function(e){function t(t){for(var a,c,o=t[0],s=t[1],u=t[2],g=0,d=[];g<o.length;g++)c=o[g],Object.prototype.hasOwnProperty.call(r,c)&&r[c]&&d.push(r[c][0]),r[c]=0;for(a in s)Object.prototype.hasOwnProperty.call(s,a)&&(e[a]=s[a]);l&&l(t);while(d.length)d.shift()();return i.push.apply(i,u||[]),n()}function n(){for(var e,t=0;t<i.length;t++){for(var n=i[t],a=!0,o=1;o<n.length;o++){var s=n[o];0!==r[s]&&(a=!1)}a&&(i.splice(t--,1),e=c(c.s=n[0]))}return e}var a={},r={app:0},i=[];function c(t){if(a[t])return a[t].exports;var n=a[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,c),n.l=!0,n.exports}c.m=e,c.c=a,c.d=function(e,t,n){c.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},c.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},c.t=function(e,t){if(1&t&&(e=c(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(c.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var a in e)c.d(n,a,function(t){return e[t]}.bind(null,a));return n},c.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return c.d(t,"a",t),t},c.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},c.p="/";var o=window["webpackJsonp"]=window["webpackJsonp"]||[],s=o.push.bind(o);o.push=t,o=o.slice();for(var u=0;u<o.length;u++)t(o[u]);var l=s;i.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"0210":function(e,t,n){},"034f":function(e,t,n){"use strict";n("85ec")},"0d54":function(e,t,n){"use strict";n("8ca4")},"0e73":function(e,t,n){},"50fc":function(e,t,n){"use strict";n("cb5e")},5159:function(e,t,n){"use strict";n("0210")},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var a=n("2b0e"),r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("router-view")],1)},i=[],c={name:"App"};document.addEventListener("touchmove",(function(e){e.preventDefault()}),{passive:!1});var o=c,s=(n("034f"),n("2877")),u=Object(s["a"])(o,r,i,!1,null,null,null),l=u.exports,g=n("8c4f"),d=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"bg",staticStyle:{overflow:"hidden"}},[n("canvas",{ref:"cloudCanvas",attrs:{id:"cloudCanvas"}}),n("div",{staticClass:"clickButton mountain",style:{opacity:e.opacity},on:{click:function(t){return e.showPrice("mountain")}}},[e._v(" 爪哇山 ")]),n("div",{staticClass:"clickButton village",style:{opacity:e.opacity},on:{click:function(t){return e.showPrice("village")}}},[e._v(" 爪哇村 ")]),n("div",{staticClass:"clickButton river",style:{opacity:e.opacity},on:{click:function(t){return e.showPrice("river")}}},[e._v(" 爪哇河 ")]),n("div",{staticClass:"clickButton secret",style:{padding:"30px 40px 48px 40px",opacity:e.opacity},on:{click:e.turnTo}},[e._v(" 神秘画卷 ")]),n("div",{directives:[{name:"show",rawName:"v-show",value:e.show,expression:"show"}],attrs:{id:"showPrice"}},[e.judgePrice?n("div",{staticClass:"success"},[e._v("恭喜你，获得"+e._s(e.price)+"等奖")]):n("div",{staticClass:"fail"},[e._v("很遗憾，您未中奖")])]),n("div",{directives:[{name:"show",rawName:"v-show",value:e.showSectry,expression:"showSectry"}],attrs:{id:"specialShowPrice"}},[n("canvas",{directives:[{name:"show",rawName:"v-show",value:e.drawable,expression:"drawable"}],ref:"myCanvas",staticStyle:{background:"#f0e7d8"},attrs:{id:"canvas"}}),n("div",{staticClass:"specialTitle",on:{"~click":function(t){return e.specialChange.apply(null,arguments)}}},[e._v(" "+e._s(e.specilTit)+" ")])])])},f=[],h=n("1da1"),p=(n("d3b7"),n("ac1f"),n("466d"),n("96cf"),n("1157")),m=n.n(p),v=n("d399");a["default"].use(v["a"]);var w={data:function(){return{show:!1,showSectry:!1,price:"三",judge:!0,token:"",judgePrice:!1,specialTitle:"点我",ctx:"",specilTit:"点击此处完成作画",flag:"",img:null,imgMark:null,markLoaded:!1,count:0,opacity:0,isiOS:!1,drawable:!0,animationId:0}},watch:{opacity:function(e){e>1&&window.cancelAnimationFrame(this.animationId)}},methods:{showPrice:function(e){var t=this;return Object(h["a"])(regeneratorRuntime.mark((function n(){return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:if(!t.judgeWherter()){n.next=2;break}return n.abrupt("return");case 2:return n.next=4,t.loginInput();case 4:if(n.sent){n.next=6;break}return n.abrupt("return");case 6:return n.next=8,t.getPrice();case 8:t.show=!0,"mountain"==e?t.judgePrice?m()("#showPrice").css({backgroundImage:'url("https://lottery-static-javatribe.oss-accelerate.aliyuncs.com/static/m_success.gif")'}):m()("#showPrice").css({backgroundImage:'url("https://lottery-static-javatribe.oss-accelerate.aliyuncs.com/static/m_fail.gif")'}):"village"==e?t.judgePrice?m()("#showPrice").css({backgroundImage:'url("https://lottery-static-javatribe.oss-accelerate.aliyuncs.com/static/v_success.gif")'}):m()("#showPrice").css({backgroundImage:'url("https://lottery-static-javatribe.oss-accelerate.aliyuncs.com/static/v_fail.gif")'}):"river"==e&&(t.judgePrice?m()("#showPrice").css({backgroundImage:'url("https://lottery-static-javatribe.oss-accelerate.aliyuncs.com/static/r_success.gif")'}):m()("#showPrice").css({backgroundImage:'url("https://lottery-static-javatribe.oss-accelerate.aliyuncs.com/static/r_fail.gif")'})),m()("#showPrice").css({"background-repeat":"no-repeat","background-size":"100% 100%"});case 11:case"end":return n.stop()}}),n)})))()},getPrice:function(){var e=this;return new Promise((function(t){console.log(e.token),e.$axios.defaults.headers.common["Authorization"]=e.token,e.$axios.post("/begin").then((function(n){var a=n.data;window.localStorage.setItem("time",(new Date).getTime()),e.price=a.prizeGrade,e.judgePrice=a.winning,localStorage.setItem("flag",1),localStorage.setItem("price",e.price),t(n)}))}))},turnTo:function(){var e=this;return Object(h["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!e.judgeWherter()){t.next=2;break}return t.abrupt("return");case 2:return t.next=4,e.loginInput();case 4:if(t.sent){t.next=6;break}return t.abrupt("return");case 6:e.showSectry=!0;case 7:case"end":return t.stop()}}),t)})))()},specialChange:function(){var e=this;return Object(h["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.getPrice();case 2:e.judgePrice?(m()("#specialShowPrice").css({backgroundImage:'url("https://lottery-static-javatribe.oss-accelerate.aliyuncs.com/static/s_success.gif")'}),e.specilTit="恭喜你获得".concat(e.price,"等奖")):(m()("#specialShowPrice").css({backgroundImage:'url("https://lottery-static-javatribe.oss-accelerate.aliyuncs.com/static/s_fail.gif")'}),e.specilTit="很遗憾，你没有中奖"),e.drawable=!1;case 4:case"end":return t.stop()}}),t)})))()},failLottery:function(){},judgeWherter:function(){if(localStorage.getItem("flag")){var e=localStorage.getItem("price"),t="";return t=4==e?"您已经抽奖，但很遗憾未中奖":"您已经抽奖，恭喜你获得".concat(e,"等奖"),Object(v["a"])({type:"fail",message:t,className:"fail",onOpened:function(){},duration:7e3}),this.flag="111",!0}return!1},paint:function(){var e=this,t=document.documentElement.clientWidth,n=document.documentElement.clientHeight,a=this.$refs.myCanvas;this.ctx=a.getContext("2d"),a.width=t/100*56.93,a.height=n/100*57.3,this.ctx.lineWidth=1,a.addEventListener("touchstart",(function(t){var n=t.targetTouches[0];e.ctx.beginPath(),e.ctx.moveTo(n.clientX-a.offsetLeft,n.clientY-a.offsetTop),a.addEventListener("touchmove",(function(t){if(1===t.targetTouches.length){var n=t.targetTouches[0];e.ctx.lineTo(n.clientX-a.offsetLeft,n.clientY-a.offsetTop),e.ctx.stroke()}}),!1),a.addEventListener("touchend",(function(t){e.ctx.closePath(),console.log(t)}),!1)}),!1)},judgeLogin:function(){if(localStorage.getItem("token")){var e=window.localStorage.getItem("time"),t=Math.round((new Date).getTime()-e)/6e4;t>5?localStorage.clear():this.token=localStorage.getItem("token")}},loginInput:function(){var e=this;return new Promise((function(t){e.$msgbox.prompt("请输入你的手机号码(手机号码仅用于兑奖使用)","提示",{confirmButtonText:"确定",cancelButtonText:"取消",inputPattern:/^1[3456789]\d{9}$/,inputErrorMessage:"格式不正确",confirmButtonClass:"confirmButton",customClass:"messageBox",center:!0,showClose:!1}).then((function(n){var a=n.value;e.$axios.get("/login?phone="+a).then((function(n){var a=n.data;200===a.code?(e.token=a.message,localStorage.setItem("token",a.message),localStorage.setItem("time",(new Date).getTime()),t(!0)):(Object(v["a"])({type:"fail",message:"兑换失败,请勿重复抽奖",className:"fail",onOpened:function(){},duration:7e3}),t(!1))}))})).catch((function(){t(!1)}))}))},cloud:function(){var e=this.$refs.cloudCanvas,t=e.getContext("2d"),n=(e.width-(70+this.count))/2,a=(e.height-(40+this.count))/2;this.markLoaded&&(e.width=this.imgMark.width,e.height=this.imgMark.height,t.clearRect(0,0,e.width,e.height),t.globalCompositeOperation="source-over",t.drawImage(this.img,n,a,70+this.count,40+this.count),t.globalCompositeOperation="source-in",t.drawImage(this.imgMark,0,0,this.imgMark.naturalWidth,this.imgMark.naturalHeight),this.opacity=this.opacity+.005,t.globalAlpha=this.opacity,this.count+=20),this.animationId=window.requestAnimationFrame(this.cloud)},detectVerticalSquash:function(e){var t=e.naturalHeight,n=document.createElement("canvas");n.width=1,n.height=t;var a=n.getContext("2d");a.drawImage(e,0,0);var r=a.getImageData(0,0,1,t).data,i=0,c=t,o=t;while(o>i){var s=r[4*(o-1)+3];0===s?c=o:i=o,o=c+i>>1}var u=o/t;return 0===u?1:u},drawImageIOSFix:function(e,t,n,a,r,i,c,o,s,u){var l=this.detectVerticalSquash(t);e.drawImage(t,n*l,a*l,r*l,i*l,c,o,s,u)}},mounted:function(){var e=this;return Object(h["a"])(regeneratorRuntime.mark((function t(){var n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return n=navigator.userAgent,t.next=3,e.judgeLogin();case 3:if(e.isiOS=!!n.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),e.img=new Image,e.imgMark=new Image,e.img.src="https://lottery-static-javatribe.oss-accelerate.aliyuncs.com/static/img/main-center-med-1.png",e.imgMark.src="https://lottery-static-javatribe.oss-accelerate.aliyuncs.com/static/抽奖.jpg",e.imgMark.onload=function(){e.markLoaded=!0},console.log(localStorage.getItem("flag")),localStorage.getItem("flag")){t.next=14;break}return console.log("初始化canvas"),t.next=14,e.paint();case 14:e.cloud();case 15:case"end":return t.stop()}}),t)})))()}},b=w,y=(n("0d54"),n("8073"),Object(s["a"])(b,d,f,!1,null,"07a73012",null)),x=y.exports,k=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"container"},[n("van-pull-refresh",{staticStyle:{color:"#000"},on:{refresh:e.onRefresh},model:{value:e.isLoading,callback:function(t){e.isLoading=t},expression:"isLoading"}},[n("div",{staticClass:"loginUser",staticStyle:{margin:"20px 0"}},[n("span",[e._v("一共有"+e._s(e.loginUser.length)+"个手机号参与抽奖")])]),n("div",{staticClass:"loginUser"},[n("div",{staticStyle:{margin:"10px 0"}},[e._v("中奖手机号：")]),e._l(e.winningUsers,(function(t,a){return n("div",{key:a,staticStyle:{margin:"5px 0"}},[e._v(e._s(a)+"："+e._s(t.phone)+" ---"+e._s(t.price)+"等奖")])}))],2)])],1)},j=[],P=(n("07ac"),n("b64b"),n("bc3a")),S=n.n(P),_={data:function(){return{loginUser:[],winningUsers:[],count:0,isLoading:!1}},created:function(){this.getLoginUser(),this.getWinningUsers()},methods:{getLoginUser:function(){var e=this;return Object(h["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:S()({url:"/monitor/loginUsers",method:"get"}).then((function(t){e.loginUser=Object.values(t.data)}));case 1:case"end":return t.stop()}}),t)})))()},getWinningUsers:function(){var e=this;return Object(h["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:S()({url:"/monitor/winningUsers",method:"get"}).then((function(t){console.log(t.data);for(var n=Object.keys(t.data),a=Object.values(t.data),r=[],i=0;i<n.length;i++){var c={phone:n[i],price:a[i]};r.push(c)}e.winningUsers=r}));case 1:case"end":return t.stop()}}),t)})))()},onRefresh:function(){var e=this;return Object(h["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.getLoginUser();case 2:return t.next=4,e.getWinningUsers();case 4:e.isLoading=!1,e.$toast.success("刷新成功");case 6:case"end":return t.stop()}}),t)})))()}}},I=_,O=(n("50fc"),n("5159"),Object(s["a"])(I,k,j,!1,null,"5ef20c4c",null)),C=O.exports;a["default"].use(g["a"]);var T=new g["a"]({routes:[{path:"/",name:"mainContent",component:x},{path:"/look",name:"look",component:C}]}),L=n("a7fe"),U=n.n(L),R=(n("c2d8"),n("58e6")),M=n("5c96");n("0fae");a["default"].use(U.a,S.a),a["default"].prototype.$msgbox=M["MessageBox"],S.a.defaults.baseURL="/api",a["default"].use(R["a"]),a["default"].config.productionTip=!1,a["default"].prototype.$axios=S.a,new a["default"]({router:T,render:function(e){return e(l)}}).$mount("#app")},8073:function(e,t,n){"use strict";n("0e73")},"85ec":function(e,t,n){},"8ca4":function(e,t,n){},cb5e:function(e,t,n){}});
//# sourceMappingURL=app.cc97ba21.js.map