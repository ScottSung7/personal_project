<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
</script> 
<!-- 1. Form형식으로 food유저의 menu테이블에 추가 가능하도록 
		menuAdd.jsp를 구성하였습니다.  -->
<!-- 2. MenuAddServlet으로 등록버튼 클릭시 submit됩니다-->
<form action="MenuAddServlet" method="get">
가게이름<input type="text" name="restaurant" id="restaurant"><br>
메뉴명<input type="text" name="menu" id="menu"><br>
장르<select  id="genre" name="genre">
        <option value="한식">한식</option>
        <option value="중식">중식</option>
        <option value="일식">일식</option>
        <option value="양식">양식</option>
        <option value="패스트푸드">패스트푸드</option>
        <option value="아시안">아시안</option>
        <option value="분식">분식</option>
        <option value="치킨">치킨</option>
        <option value="피자">피자</option>
        <option value="야식">야식</option>
        <option value="브런치">브런치</option>
       </select><br>
식사스타일<select  id="estyle" name="estyle">
        <option value="식사류">식사류</option>
        <option value="국물류">국물류</option>
        <option value="간편">간편</option>       
       </select><br>
식감<select  id="texture" name="texture">
        <option value="바삭">바삭</option>
        <option value="쫄깃">쫄깃</option>
        <option value="간편">눅눅</option>       
        <option value="간편">아삭</option>       
        <option value="간편">부드러움</option>       
        <option value="간편">간편</option>       
        <option value="간편">간편</option>       
       </select><br>
맛<select  id="taste" name="taste">
       <option value="단맛">단맛</option>	
        <option value="쓴맛">쓴맛</option>	
        <option value="짠맛">짠맛</option>       
        <option value="신맛">신맛</option>       
        <option value="감칠맛">감칠맛</option>             
       </select><br>
양념<select  id="sauce" name="sauce">
        <option value="none">none</option>	
        <option value="고추장베이스">고추장베이스</option>	
        <option value="토마토소스">토마토소스</option>       
        <option value="크림소스">크림소스</option>       
        <option value="로제소스">로제소스</option>           
        <option value="간장베이스">간장베이스</option>           
        <option value="메이플시럽">메이플시럽</option>  
       </select><br>
향신료<select  id="spice" name="spice">
        <option value="none">none</option>	
        <option value="생강">생강</option>	
        <option value="카레">카레</option>       
        <option value="고추">고추</option>       
        <option value="후추">후추</option>           
        <option value="겨자">겨자</option>           
        <option value="깨">깨</option>           
        <option value="허브">허브</option>           
        <option value="마늘">마늘</option>              
       </select><br>
탄수화물<select  id="carbo" name="carbo">
        <option value="none">none</option>	
        <option value="국수류">국수류</option>	
        <option value="빵류">빵류</option>       
        <option value="기타밀가루">기타밀가루</option>       
        <option value="밥류">밥류</option>           
       </select><br>
고기<select  id="meat" name="meat">
        <option value="none">none</option>	
        <option value="소고기">소고기</option>	
        <option value="돼지고기">돼지고기</option>       
        <option value="양고기">양고기</option>       
        <option value="닭고기">닭고기</option>           
       </select><br>
지방<select  id="fat" name="fat">
        <option value="none">none</option>	
        <option value="올리브유">올리브유</option>	
        <option value="기타식용유">기타식용유</option>       
        <option value="땅콩기름">땅콩기름</option>       
        <option value="들기름">들기름</option>           
        <option value="참기름">참기름</option>           
       </select><br>
채소<select  id="vegi" name="vegi">
        <option value="none">none</option>	
        <option value="시금치">시금치</option>	
        <option value="콩나물">콩나물</option>       
        <option value="숙주나물">숙주나물</option>       
        <option value="무">무</option>           
        <option value="청경채">청경채</option>           
        <option value="상추">상추</option>           
        <option value="양상추">양상추</option>           
        <option value="배추">배추</option>           
        <option value="대파">대파</option>           
        <option value="애호박">애호박</option>           
        <option value="버섯">버섯</option>           
        <option value="우엉">우엉</option>           
        <option value="도라지">도라지</option>           
        <option value="브로콜리">브로콜리</option>           
        <option value="파프리카">파프리카</option>           
        <option value="비트">비트</option>           
        <option value="부추">부추</option>           
        <option value="더덕">더덕</option>           
        <option value="연근">연근</option>           
        <option value="죽순">죽순</option>           
        <option value="깻잎">깻잎</option>           
        <option value="쑥">쑥</option>           
        <option value="양배추">양배추</option>           
        <option value="셀러리">셀러리</option>           
        <option value="토마토">토마토</option>           
        <option value="당근">당근</option>           
       </select><br>
이미지이름<input type="text" name="image" id="iamge"><br>
<input type="submit" value="등록">
<input type="reset" value="취소">


</form>