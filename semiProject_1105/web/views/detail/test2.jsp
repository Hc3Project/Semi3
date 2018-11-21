<!doctype html>
<head>
<meta charset="utf-8" />
<title>Workshop.rs: News Ticker in 4 lines of jQuery</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<style>
.ticker {
 height: 40px;
 overflow: hidden;
 margin: 0;
 padding: 0;
 list-style: none;

}
.ticker li {
 height: 30px;
 padding: 5px;
 margin: 0px 5px;
}
</style>


<script>
 function tick(){
  $('#ticker_01 li:first').slideUp( function () { $(this).appendTo($('#ticker_01')).slideDown(); });
  $('#ticker_02 li:first').slideUp( function () { $(this).appendTo($('#ticker_02')).slideDown(); });
  $('#ticker_03 li:first').slideUp( function () { $(this).appendTo($('#ticker_03')).slideDown(); });
 }
 setInterval(function(){ tick () }, 3000);
</script>


</head>

<body>


<div>
<ul id="ticker_01" class="ticker">

  <li><a href="#">111</li>
        <li><a href="#">222</li>
  <li><a href="#">333</li>
  <li><a href="#">444</li>
 </ul>
</div>
 <ul id="ticker_02" class="ticker">

  <li><a href="#">222</li>
        <li><a href="#">333</li>
  <li><a href="#">444</li>
  <li><a href="#">111</li>
 </ul>
</div>
<ul id="ticker_03" class="ticker">

  <li><a href="#">333</li>
        <li><a href="#">444</li>
  <li><a href="#">111</li>
  <li><a href="#">222</li>
 </ul>
</div>

</body>