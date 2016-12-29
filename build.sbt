import com.scalapenos.sbt.prompt._
import SbtPrompt.autoImport._

name := "eth-command-line"

version := "0.0.1-SNAPSHOT"

ethJsonRpcUrl := "http://ethjsonrpc.mchange.com:8545/"

promptTheme := PromptTheme( Seq( text("eth-command-line ~> ", NoStyle) ) )







