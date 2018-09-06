# Mp3 歌词文件一键导入到Premiere cc
## Lyric to premiere pro cc subtitles
## 如何使用这个程序？
- [download]

![双击运行进入小程序界面](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/Premiere%20Pro%20XML.jar "Premiere Pro XML.jar")

![](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/mainframe.png)
![](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/choose.png)
![](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/saveas.png)
![](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/savetoxml.png)
![](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/premiere.png)
![](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/endfile.png)
![](https://github.com/uboger/LRC-to-premiere-subtitles/blob/master/in the move.png)
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
				<style />
				<span>
					That Girl - Olly Murs
					<style tts:fontSize="36px" />
				</span>
			</p>
			<p begin="00:00:57" end="00:00:57" region="pop1" style="basic"
				tts:origin="10% 78.744%">
				<style />
				<span>
					<style tts:fontSize="36px" />
				</span>
			</p>
			<p begin="00:00:57" end="00:05:80" region="pop1" style="basic"
				tts:origin="10% 78.744%">
				<style />
				<span>
					There's a girl but I let her get away
					<style tts:fontSize="36px" />
				</span>
			</p>
			<p begin="00:05:80" end="00:05:80" region="pop1" style="basic"
				tts:origin="10% 78.744%">
				<style />
				<span>
					曾经心爱的女孩 我却让她擦肩而过
					<style tts:fontSize="36px" />
				</span>
			</p>
			<p begin="00:05:80" end="00:11:23" region="pop1" style="basic"
				tts:origin="10% 78.744%">
				<style />
				<span>
					It's all my fault cause pride got in the way
					<style tts:fontSize="36px" />
				</span>
			</p>
			<p begin="00:11:23" end="00:11:23" region="pop1" style="basic"
				tts:origin="10% 78.744%">
				<style />
				<span>
					都是我的错 因为自尊心作祟
					<style tts:fontSize="36px" />
				</span>
			</p>
			<p begin="00:11:23" end="00:16:61" region="pop1" style="basic"
				tts:origin="10% 78.744%">
				<style />
				<span>
					And I'd be lying if I said I was OK
					<style tts:fontSize="36px" />
				</span>
			</p>
			<p begin="02:48:03" end="02:48:03" region="pop1" style="basic"
				tts:origin="10% 78.744%">
				<style />
				<span>
					因为受伤的心再也无法愈合
					<style tts:fontSize="36px" />
				</span>
			</p>
			<p begin="02:48:03" end="02:49:54" region="pop1" style="basic"
				tts:origin="10% 78.744%">
				<style />
				<span>
					That girl
					<style tts:fontSize="36px" />
				</span>
			</p>
			<p begin="02:49:54" end="02:49:54" region="pop1" style="basic"
				tts:origin="10% 78.744%">
				<style />
				<span>
					那个女孩
					<style tts:fontSize="36px" />
				</span>
			</p>
  <!--此处已经省略部分-->
			<p begin="02:49:54" end="02:53:54" region="pop1" style="basic"
				tts:origin="10% 78.744%">
				<style />
				<span>
					The one I let get away
					<style tts:fontSize="36px" />
				</span>
			</p>
			<p begin="02:53:54" end="02:53:54" region="pop1" style="basic"
				tts:origin="10% 78.744%">
				<style />
				<span>
					我们曾擦肩而过
					<style tts:fontSize="36px" />
				</span>
			</p>
		</div>
	</body>

</tt>
```
