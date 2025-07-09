export const testPostData: App.PostData = {
  post_code:`public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Deck d = new Deck();

    int Draw = 5;

    Card hand[] = new Card[Draw];

    Checker c;
    while (true) {
      d.shuffle();
      System.out.println("Your hand is: ");
      // 카드 뽑기
      for (int i = 0; i < Draw; i++) {
        hand[i] = d.cardArr[i];
        System.out.println(hand[i]);
      }

      c = new Checker(hand);

      System.out.print("\nYour set is ...");
      System.out.println(" " + c.decision() + "!");

      System.out.println("\nContinue? ('end' to end): ");
      String ans = input.nextLine();

      if (ans.equals("end")) {
        // end 라고 칠 경우
        input.close();
        break;
      }
    }
  }
}`,
    post_createdDate: "0000.00.00/00:00",
  
    post_id: -1,
    post_title: "테스트 페이지입니다.",
    post_uploader: {
      user_createDate: "0000.00.00/00:00",
      user_id: 0,
      user_name: "테스트 유저",
      user_role: 7,
    },
    post_comments: [],
    post_content: `
    <p>포스트 내용이 들어갈 위치입니다.</p>
    <h1>제목도</h1>
    <h2>들어</h2>
    <h3>가고</h3>
    <ul>
      <li>이런 식으로</li>
      <li>리스트도 들어갑니다.</li>
    </ul>
    <ol>
      <li>번호도</li>
      <li>매겨지고요.</li>
    </ol>
    
    <hr/>
    <blockquote>마크다운 문법은 웬만한건 들어갑니다.</blockquote>
    <pre><code>public class Main {
  public static void main (String[] args) {
    System.out.println("Hello, World!!");
  }
}</code></pre>`,
}