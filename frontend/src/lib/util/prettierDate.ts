export const prettierDate = (date: Date): string => {
  const CurrDate = Date.now()
  if(date === null)
    return "null"
  if (CurrDate - date.getTime() > 24*60*60*1000) {
    const y = date.getFullYear()
    const m = date.getMonth()
    const d = date.getDay()

    return y + '-' + m.toString().padStart(2, '0') + '-' + d.toString().padStart(2, '0')
  }
  const h = date.getHours()
  const m = date.getMinutes()
  return h.toString().padStart(2,'0') + ":" + m.toString().padStart(2,'0')
}