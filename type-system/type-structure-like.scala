type MailBoxLike = {
  def receive(a: String)
}

def send(msg: String, box: MailBoxLike) = box receive msg

object Home { def receive(a: String) = println(a) }
object Work { def receive(a: String) = println(a) }

send("do it at Home", Home)
send("do it at Work", Work)