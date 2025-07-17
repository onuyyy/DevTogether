export const testUser: App.UserData = {
  username: "테스트유저",
  id: 1
}

const testCommentData: App.CommentData[] = [
  {
    author: testUser,
    postId: -1,
    id: 1,
    createDate: new Date("2022-02-22T22:22:22"),
    content: "이것은 댓글 입니다.",
    parent: -1
  },
  {
    author: testUser,
    postId: -1,
    id: 2,
    createDate: new Date("2022-02-22T22:22:22"),
    content: "이것은 대댓글 입니다.",
    parent: 1
  },
  {
    author: testUser,
    postId: -1,
    id: 3,
    createDate: new Date("2022-02-22T22:22:22"),
    content: "이것은 대대댓글 입니다.",
    parent: 2
  },
  {
    author: testUser,
    postId: -1,
    id: 4,
    createDate: new Date("2022-02-22T22:22:22"),
    content: "이것은 또다른 댓글 입니다.",
    parent: -1
  },
  {
    author: testUser,
    postId: -1,
    id: 5,
    createDate: new Date("2022-02-22T22:22:22"),
    content: "이것은 대대대댓글 입니다.",
    parent: 3
  },
  {
    author: testUser,
    postId: -1,
    id: 6,
    createDate: new Date("2022-02-22T22:22:22"),
    content: "이것은 또다른 댓글의 대댓글 입니다.",
    parent: 4
  },
]

const testPostData: App.PostData = {
  code:`public class Main {
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
    createDate: "0000.00.00T00:00:00",
  
    id: -1,
    title: "테스트 페이지입니다.",
    author: testUser,
    comments: testCommentData,
    content: `
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

export const GetPostsExample: Api.GetPostsPosts = {
  id: testPostData.id,
  title: testPostData.title,
  content: testPostData.content,
  author: testUser,
  createDate: testPostData.createDate,
  commentCount: 0
}

export const GetPostsPageInfoExample: Api.GetPostsPageInfo = {
  currentPage: 0,
  totalPages: 0
}

export const GetPostResponseExample: Api.GetPostsResponse = {
  posts: [
    GetPostsExample
  ],
  pageInfo: GetPostsPageInfoExample
}

export const GetPostsByPostIDExample: Api.GetPostsByPostId = {
  post: {
    id: testPostData.id,
    title: testPostData.title,
    content: testPostData.content,
    code: testPostData.code,
    author: testUser,
    createDate: testPostData.createDate,
    commentCount: 0,
    comments: testPostData.comments
  }
}