!function(t){var e={};function n(o){if(e[o])return e[o].exports;var r=e[o]={i:o,l:!1,exports:{}};return t[o].call(r.exports,r,r.exports,n),r.l=!0,r.exports}n.m=t,n.c=e,n.d=function(t,e,o){n.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:o})},n.r=function(t){"undefined"!=typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},n.t=function(t,e){if(1&e&&(t=n(t)),8&e)return t;if(4&e&&"object"==typeof t&&t&&t.__esModule)return t;var o=Object.create(null);if(n.r(o),Object.defineProperty(o,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var r in t)n.d(o,r,function(e){return t[e]}.bind(null,r));return o},n.n=function(t){var e=t&&t.__esModule?function(){return t.default}:function(){return t};return n.d(e,"a",e),e},n.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},n.p="",n(n.s=15)}([function(t,e){t.exports={"uni-icon":{fontFamily:"uniicons",fontWeight:"normal"},"uni-bg-red":{backgroundColor:"#F76260",color:"#FFFFFF"},"uni-bg-green":{backgroundColor:"#09BB07",color:"#FFFFFF"},"uni-bg-blue":{backgroundColor:"#007AFF",color:"#FFFFFF"},"uni-container":{flex:0,paddingTop:0,paddingRight:0,paddingBottom:0,paddingLeft:0},"uni-padding-lr":{paddingLeft:"15",paddingRight:"15"},"uni-padding-tb":{paddingTop:"15",paddingBottom:"15"},"uni-header-logo":{paddingTop:"15",paddingRight:"15",paddingBottom:"15",paddingLeft:"15",flexDirection:"column",justifyContent:"center",alignItems:"center",marginTop:"10upx"},"uni-header-image":{width:"80",height:"80"},"uni-hello-text":{marginBottom:"20"},"hello-text":{color:"#7A7E83",fontSize:"14",lineHeight:"20"},"hello-link":{color:"#7A7E83",fontSize:"14",lineHeight:"20"},"uni-panel":{marginBottom:"12"},"uni-panel-h":{backgroundColor:"#ffffff",flexDirection:"row",alignItems:"center",paddingTop:"12",paddingRight:"12",paddingBottom:"12",paddingLeft:"12"},"uni-panel-h-on":{backgroundColor:"#f0f0f0"},"uni-panel-text":{flex:1,color:"#000000",fontSize:"14",fontWeight:"normal"},"uni-panel-icon":{marginLeft:"15",color:"#999999",fontSize:"14",fontWeight:"normal",transform:"rotate(0deg)",transitionDuration:0,transitionProperty:"transform"},"uni-panel-icon-on":{transform:"rotate(180deg)"},"uni-navigate-item":{flexDirection:"row",alignItems:"center",backgroundColor:"#FFFFFF",borderTopStyle:"solid",borderTopColor:"#f0f0f0",borderTopWidth:"1",paddingTop:"12",paddingRight:"12",paddingBottom:"12",paddingLeft:"12","backgroundColor:active":"#f8f8f8"},"uni-navigate-text":{flex:1,color:"#000000",fontSize:"14",fontWeight:"normal"},"uni-navigate-icon":{marginLeft:"15",color:"#999999",fontSize:"14",fontWeight:"normal"},"uni-list-cell":{position:"relative",flexDirection:"row",justifyContent:"flex-start",alignItems:"center"},"uni-list-cell-pd":{paddingTop:"22upx",paddingRight:"30upx",paddingBottom:"22upx",paddingLeft:"30upx"},"flex-r":{flexDirection:"row"},"flex-c":{flexDirection:"column"},"a-i-c":{alignItems:"center"},"j-c-c":{justifyContent:"center"},"list-item":{flexDirection:"row",paddingTop:"10",paddingRight:"10",paddingBottom:"10",paddingLeft:"10"},"@VERSION":2}},function(t,e,n){"use strict";function o(t,e,n,o,r,i,a,c,l,u){var s,f="function"==typeof t?t.options:t;if(l){f.components||(f.components={});var d=Object.prototype.hasOwnProperty;for(var p in l)d.call(l,p)&&!d.call(f.components,p)&&(f.components[p]=l[p])}if(u&&((u.beforeCreate||(u.beforeCreate=[])).unshift((function(){this[u.__module]=this})),(f.mixins||(f.mixins=[])).push(u)),e&&(f.render=e,f.staticRenderFns=n,f._compiled=!0),o&&(f.functional=!0),i&&(f._scopeId="data-v-"+i),a?(s=function(t){(t=t||this.$vnode&&this.$vnode.ssrContext||this.parent&&this.parent.$vnode&&this.parent.$vnode.ssrContext)||"undefined"==typeof __VUE_SSR_CONTEXT__||(t=__VUE_SSR_CONTEXT__),r&&r.call(this,t),t&&t._registeredComponents&&t._registeredComponents.add(a)},f._ssrRegister=s):r&&(s=c?function(){r.call(this,this.$root.$options.shadowRoot)}:r),s)if(f.functional){f._injectStyles=s;var g=f.render;f.render=function(t,e){return s.call(e),g(t,e)}}else{var m=f.beforeCreate;f.beforeCreate=m?[].concat(m,s):[s]}return{exports:t,options:f}}n.d(e,"a",(function(){return o}))},,function(t,e,n){"use strict";var o=n(9),r=n(6),i=n(1),a=Object(i.a)(r.default,o.b,o.c,!1,null,null,"5d1c7c7c",!1,o.a,void 0);e.default=a.exports},,,function(t,e,n){"use strict";var o=n(7),r=n.n(o);e.default=r.a},function(t,e,n){"use strict";(function(t){Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var o,r=n(16),i={components:{},data:function(){return{title:"app\u7aef\u5bfc\u51faexcel",successTip:""}},onLoad:function(){o=this},methods:{tableToExcel:function(){for(var e=[{name:"\u6d4b\u8bd5\u6570\u636e",phone:"123456",email:"123@456.com"},{name:"\u6d4b\u8bd5\u6570\u636e2",phone:"12345621211",email:"12312312.com"}],n="<tr><td>\u59d3\u540d</td><td>\u7535\u8bdd</td><td>\u90ae\u7bb1</td></tr>",i=0;i<e.length;i++){for(var a in n+="<tr>",e[i])n+="<td>".concat(e[i][a]+"\t","</td>");n+="</tr>"}!function(e){var n=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"\u9879\u76eeExcel\u6587\u4ef6";plus.io.requestFileSystem(plus.io.PUBLIC_DOCUMENTS,(function(i){var a=i.root,c=a.fullPath;t("log","\u5f00\u59cb\u5bfc\u51fa\u6570\u636e********"," at pages/sample/ext-module.nvue:87"),a.getDirectory(n,{create:!0},(function(i){var a=new Date,l=a.getFullYear(),u=a.getMonth()+1;i.getDirectory("".concat(l,"\u5e74").concat(u,"\u6708"),{create:!0},(function(i){var a="excel"+(0,r.getUnixTime)((0,r.formatDateThis)(new Date));t("log",a," at pages/sample/ext-module.nvue:101"),i.getFile("".concat(a,".xlsx"),{create:!0},(function(r){r.createWriter((function(r){r.onwritestart=function(t){uni.showLoading({title:"\u6b63\u5728\u5bfc\u51fa",mask:!0})};var i=c.replace("/storage/emulated/0","");r.onwrite=function(e){uni.hideLoading(),setTimeout((function(){uni.showToast({title:"\u6210\u529f\u5bfc\u51fa",icon:"success"}),t("log",a," at pages/sample/ext-module.nvue:123"),o.successTip="\u6587\u4ef6\u4f4d\u7f6e\uff1a".concat(i).concat(n,"/").concat(l,"\u5e74").concat(u,"\u6708");var e="/storage/emulated/0".concat(i).concat(n,"/").concat(l,"\u5e74").concat(u,"\u6708")+"/"+a+".xlsx";t("log",e," at pages/sample/ext-module.nvue:126"),uni.openDocument({filePath:e,showMenu:!0,success:function(t){},fail:function(e){t("log",e," at pages/sample/ext-module.nvue:132")}})}),500)},r.write(e)}),(function(e){t("log",e.message," at pages/sample/ext-module.nvue:142")}))}))}))}))}))}('<html xmlns:o="urn:schemas-microsoft-com:office:office" \n        xmlns:x="urn:schemas-microsoft-com:office:excel" \n        xmlns="http://www.w3.org/TR/REC-html40">\n        <head>\x3c!--[if gte mso 9]><xml encoding="UTF-8"><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet>\n        <x:Name>'.concat("sheet1","</x:Name>\n        <x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet>\n        </x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--\x3e\n        </head><body><table>").concat(n,"</table></body></html>"))}}};e.default=i}).call(this,n(13).default)},,function(t,e,n){"use strict";n.d(e,"b",(function(){return o})),n.d(e,"c",(function(){return r})),n.d(e,"a",(function(){}));var o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("scroll-view",{staticStyle:{flexDirection:"column"},attrs:{scrollY:!0,showScrollbar:!0,enableBackToTop:!0,bubble:"true"}},[n("view",{staticClass:["content"]},[n("view",{staticClass:["top_box"]},[n("u-text",[t._v(t._s(t.title))])]),n("view",{staticClass:["btn_cube"],on:{click:t.tableToExcel}},[n("u-text",[t._v("\u5bfc\u51fa\u4e00\u4e2a\u8868\u6765\u770b")])]),n("view",{staticClass:["tip"]},[n("u-text",[t._v("tips\uff1a\u5408\u5e76\u4ec0\u4e48\u7684\u53ef\u4ee5\u76f4\u63a5\u7528table\u6807\u7b7e\u76f8\u5173\u7684\u884c\u5185\u5c5e\u6027\u5408\u5e76\uff0c\u5982colspan\u3001rowspan")])]),n("view",{staticClass:["tip"]},[n("u-text",[t._v("tips\uff1a\u521b\u5efa\u76ee\u5f55\u65f6\uff0c\u4e00\u4e2a\u5927\u76ee\u5f55\uff0c\u4e0b\u9762\u518d\u6709\u4e00\u7ea7\u5e74\u6708\u7684\u76ee\u5f55\uff0c\u65b9\u4fbf\u5230\u65f6\u5019\u8bfb\u53d6\u76ee\u5f55")])]),n("view",{staticClass:["tip"]},[n("u-text",[t._v(t._s(t.successTip))])])])])},r=[]},function(t,e,n){Vue.prototype.__$appStyle__={},Vue.prototype.__merge_style&&Vue.prototype.__merge_style(n(11).default,Vue.prototype.__$appStyle__)},function(t,e,n){"use strict";n.r(e);var o=n(0),r=n.n(o);for(var i in o)"default"!==i&&function(t){n.d(e,t,(function(){return o[t]}))}(i);e.default=r.a},function(t,e){if("undefined"==typeof Promise||Promise.prototype.finally||(Promise.prototype.finally=function(t){var e=this.constructor;return this.then((function(n){return e.resolve(t()).then((function(){return n}))}),(function(n){return e.resolve(t()).then((function(){throw n}))}))}),"undefined"!=typeof uni&&uni&&uni.requireGlobal){var n=uni.requireGlobal();ArrayBuffer=n.ArrayBuffer,Int8Array=n.Int8Array,Uint8Array=n.Uint8Array,Uint8ClampedArray=n.Uint8ClampedArray,Int16Array=n.Int16Array,Uint16Array=n.Uint16Array,Int32Array=n.Int32Array,Uint32Array=n.Uint32Array,Float32Array=n.Float32Array,Float64Array=n.Float64Array,BigInt64Array=n.BigInt64Array,BigUint64Array=n.BigUint64Array}},function(t,e,n){"use strict";function o(t){var e=Object.prototype.toString.call(t);return e.substring(8,e.length-1)}function r(){return"string"==typeof __channelId__&&__channelId__}function i(t,e){switch(o(e)){case"Function":return"function() { [native code] }";default:return e}}Object.defineProperty(e,"__esModule",{value:!0}),e.log=function(t){for(var e=arguments.length,n=new Array(e>1?e-1:0),o=1;o<e;o++)n[o-1]=arguments[o];console[t].apply(console,n)},e.default=function(){for(var t=arguments.length,e=new Array(t),n=0;n<t;n++)e[n]=arguments[n];var a=e.shift();if(r())return e.push(e.pop().replace("at ","uni-app:///")),console[a].apply(console,e);var c=e.map((function(t){var e=Object.prototype.toString.call(t).toLowerCase();if("[object object]"===e||"[object array]"===e)try{t="---BEGIN:JSON---"+JSON.stringify(t,i)+"---END:JSON---"}catch(n){t=e}else if(null===t)t="---NULL---";else if(void 0===t)t="---UNDEFINED---";else{var n=o(t).toUpperCase();t="NUMBER"===n||"BOOLEAN"===n?"---BEGIN:"+n+"---"+t+"---END:"+n+"---":String(t)}return t})),l="";if(c.length>1){var u=c.pop();l=c.join("---COMMA---"),0===u.indexOf(" at ")?l+=u:l+="---COMMA---"+u}else l=c[0];console[a](l)}},,function(t,e,n){"use strict";n.r(e);n(10),n(12);var o=n(3);o.default.mpType="page",o.default.route="pages/sample/ext-module",o.default.el="#root",new Vue(o.default)},function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.datePassDays=e.compareTime=e.mathChangeDate=e.getDateDiff=e.toDate=e.formatTimes=e.formatTime=e.formatDateThis=e.getUnixTime=e.getCurrentTime=e.dateCompare=void 0;var o=function(t){var e=t.replace(/-/g,"/");return new Date(e).getTime().toString().substring(0,10)};e.getUnixTime=o;var r=function(t,e,n){var o=t,r=new Date(1e3*parseInt(o)),i=r.getFullYear(),a=r.getMonth()+1;a=a<10?"0"+a:a;var c=r.getDate();c=c<10?"0"+c:c;var l=r.getHours();l=l<10?"0"+l:l;var u=r.getMinutes(),s=r.getSeconds();return u=u<10?"0"+u:u,s=s<10?"0"+s:s,e?"year"==n?i:"month"==n?a:"date"==n?o:i+"-"+a+"-"+c:i+"-"+a+"-"+c+" "+l+":"+u+":"+s};e.toDate=r;e.dateCompare=function(t,e){return t>e?Math.floor((t-e)/86400):Math.floor((e-t)/86400)};e.datePassDays=function(t,e){return o(i(new Date))-t>=86400*e};e.mathChangeDate=function(t,e,n,o){var i=t.replace(/-/g,"/"),a=Date.parse(i);return"+"==e?a=a/1e3+86400*n:"-"==e&&(a=a/1e3-86400*n),r(a,o)};e.getDateDiff=function(t){var e=o(i(new Date))-t;if(!(e<0)){var n=e/2592e3,r=e/604800,a=e/86400,c=e/3600,l=e/60;return n>=1?parseInt(n)+"\u6708\u524d":r>=1?parseInt(r)+"\u5468\u524d":a>=1?parseInt(a)+"\u5929\u524d":c>=1?parseInt(c)+"\u5c0f\u65f6\u524d":l>=1?parseInt(l)+"\u5206\u949f\u524d":"\u521a\u521a"}};e.getCurrentTime=function(t){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:new Date;return"year"==t?e.getFullYear():"month"==t?e.getMonth()+1:e};var i=function(t){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"-",n=t.getFullYear(),o=t.getMonth()+1,r=t.getDate(),i=t.getHours(),c=t.getMinutes(),l=t.getSeconds();return[n,o,r].map(a).join(e)+" "+[i,c,l].map(a).join(":")};e.formatDateThis=i;e.formatTime=function(t){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"-",n=t.getFullYear(),o=t.getMonth()+1,r=t.getDate();return[n,o,r].map(a).join(e)};e.formatTimes=function(t){return[t.getHours(),t.getMinutes(),t.getSeconds()].map(a).join(":")};var a=function(t){return(t=t.toString())[1]?t:"0"+t};e.compareTime=function(t,e){var n=1*o(t);return 1*o(e)>n}}]);