import { goto } from "$app/navigation"

let userInfo: App.UserData | null = $state(null)

export const getUser = () => userInfo

export const setUser = async (reqData: Api.PostLoginRequest) => {
  if (reqData.username == 'null' || reqData.password == 'null'
    || reqData.username == '' || reqData.password == ''
  ) {
    console.log(reqData)
    alert("비어있는 필드가 존재합니다!")
    return
  }

  const jsonData = JSON.stringify( reqData )

  try {
    const res = await fetch(`${import.meta.env.VITE_API_URL}/api/user/login`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: jsonData
    })

    if(res.status == 403 || res.status == 404) {
      alert('아이디 또는 비밀번호가 틀렸습니다!')
      return
    }
    // 대답이 어떻게 나오려나
    // 로그인 성공했어용 -> user 상태 변경하고 어디론가 보내기
      // 어디로 보내지? /? 아니면 이전 페이지?
    // 실패했어용 -> "아이디 또는 비밀번호가 틀렸습니다."
    
    console.log(res)
    if(!res.ok) {
      throw new Error("login fail!")
    }
    alert("로그인 성공!")

    const userData = await res.json()
    console.log(userData)

    userInfo = {
      id: userData.id,
      username: userData.username
    }

    goto('/')
  } catch (err) {
    alert('로그인에 실패했습니다!')
    console.log(err)
  }
}

export const clearUser = () => {
  userInfo = null
}
