# Mp3 歌词文件LRC格式为PREMIERE格式
## Lyric to premiere pro cc subtitles
## 如何使用这个程序？

##### 使用前请确认你的电脑是否安装和配置好Java环境

- [download](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/install.rar "程序包")

- 双击运行进入小程序界面

![](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/open.png "小程序界面")

- 选择要转换的歌词文件（注意一定是*.lrc格式的文件，选择点击确定后自动转换）
![](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/choose.png "选择要转换的lrc文件")

- 点击另存为 将转换好的文件进行保存，以便导入到Premiere 中
![](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/saveas.png "点击另存为")

- 这里可以 选择转换后的文件保存的文件夹和修改文件名称（指定文件名称和文件路径）
![](https://github.com/uboger/LRC-to-premiere-subtitles/blolb/master/savetoxml.png)

- 将转换好的文件导入到Premiere 中
![](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/oneline.png "导入到Premiere")

- 转换前的文件后缀名称和转换后的文件后缀名称
![](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/endfile.png "文件后缀名称") 

- 鼠标拖入Premiere软件 就可以使用了
![](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/timeline.png "在Premiere 中显示")


## 转换前格式
```lrc
[ml:1.0]

[00:00.10]That Girl - Olly Murs

[00:00.57]

[00:00.57]There's a girl but I let her get away

[00:05.80]曾经心爱的女孩 我却让她擦肩而过

[00:05.80]It's all my fault cause pride got in the way

[00:05.80]hidden .......................^^^^^^^

[02:49.54]那个女孩

[02:49.54]The one I let get away

[02:53.54]我们曾擦肩而过

[02:53.54]


```
## 转换后的格式

```xml
<?xml version="1.0" encoding="UTF-8"?>
<tt xmlns="http://www.w3.org/ns/ttml" xmlns:ttp="http://www.w3.org/ns/ttml#parameter"
	xmlns:ttm="http://www.w3.org/ns/ttml#metadata" xmlns:tts="http://www.w3.org/ns/ttml#styling"
	ttp:dropMode="nonDrop" ttp:frameRate="25" ttp:timeBase="smpte">

	<head>
		<styling>
			<style tts:color="white" tts:fontFamily="monospace"
				tts:fontWeight="normal" tts:textAlign="left" xml:id="basic" />
		</styling>
		<layout>
			<region tts:backgroundColor="transparent" xml:id="pop1" />
			<region tts:backgroundColor="transparent" xml:id="paint" />
			<region tts:backgroundColor="transparent" xml:id="rollup2" />
			<region tts:backgroundColor="transparent" xml:id="rollup3" />
			<region tts:backgroundColor="transparent" xml:id="rollup4" />
		</layout>
		<metadata />
	</head>

	<body>
		<div>

			<p begin="00:00:10" end="00:00:57" region="pop1" style="basic"
				tts:origin="10% 78.744%">
				<span>
					That Girl - Olly Murs
				</span>
			</p>			
		</div>
	</body>

</tt>
```
