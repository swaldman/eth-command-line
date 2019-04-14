# eth-command-line

### An instant-gratification command line for interacting with ethereum smart-contracts and accounts ###

## Prerequisites

You need a Java runtime environment installed on your machine. If you don't
already have one, you can download a [JRE](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
(or a full [Java Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html))
from Oracle.

`eth-command-line` has been developed under Java 8, but will probably work under other Java versions.

## Quick-Start

1. Clone or download this project
2. In the top-level project directory, make sure that the shell script `eth-command-line` has
   execute permissions. (If not, on a Unix-like system, type `chmod +x ./eth-command-line`)
3. Execute the shell script `eth-command-line`. The first time you do this, a whole bunch of
   downloads will likely be triggered
4. At the prompt, you can begin typing ethereum-related command. To see a list
   of all commands, type `eth<tab>`. To see a description of all commands, type `tasks -V eth`

   _Note: `sbt-ethereum` commands are really verbose! They are not intended to be typed. Use the <tab> key, Luke!
   For example, to enter `ethKeystoreWalletV3Create` (yuk, right?), just type `et<tab>K<tab>W<tab>C<tab>`. 
   Another way of visualizing this is_ **et**h**K**eystore**W**alletV3**C**reate. _Only the keys in bold
   need to be typed, the rest get taken care of by `<tab>`. `sbt-ethereum` tries very hard to require
   very few non-`<tab>` keypresses, usually just one capital letter takes you down a level of its hierarchically
   organized commands._
   

5. For operations that require the payment of Ether, such as sending ether (`ethTransactionEtherSend`) or
   invoking state-changing smart-contract methods (`ethTransactionInvoke`), you will need to define the
   ethereum address from which the operation will originate. You can create a new address using
   `ethKeystoreWalletV3Create` command.
   ```
   sbt:eth-command-line> ethKeystoreWalletV3Create
   [info] Generated keypair for address '0xe10280702f233573b2dca5a81bda8dd3a0867fcc'
   [info] Generating V3 wallet, alogorithm=scrypt, n=262144, r=8, p=1, dklen=32
   Enter passphrase for new wallet: *******************
   Please retype to confirm: *******************
   [success] Total time: 30 s, completed Feb 23, 2018 6:50:33 PM

   ```
   You can also import existing `geth` wallets into the `sbt-ethereum` repository directory.
   See the [sbt-ethereum docs](https://github.com/swaldman/sbt-ethereum/blob/master/README.md).

   **Be sure to back up your `sbt-ethereum` repository directory to avoid losing your wallets and accounts!**

   ...but using your own Ethereum address of course!
   

## Introduction

`eth-command-line` is just a thin wrapper around [sbt-ethereum](https://www.sbt-ethereum.io/).

To use _sbt-ethereum_, you have to go through
the ceremony of setting up a project directory and run a synced ethereum node. This project takes care of that for you.

In order for the instant gratification thing to work, _sbt-ethereum_ may be preconfigured to interact with a public
_ethereum_ node. **No guarantees are
made about how long this Ethereum node will be exposed for public use!** It's best to [get access to a more reliable
node, and define that as your default node URL](https://www.sbt-ethereum.io/tutorials/getting-started.html#connect-to-a-node).

### Quick Example: Import a contract ABI and call a constant method of a smart contract to check its state

```
sbt:eth-command-line> ethContractAbiImport
Contract address in hex: 0x82ea8ab1e836272322f376a5f71d5a34a71688f1
Contract ABI: [{"outputs":[],"constant":false,"payable":false,"inputs":[{"name":"fortune","type":"string"}],"name":"addFortune","stateMutability":"nonpayable","type":"function"},{"outputs":[{"name":"count","type":"uint256"}],"constant":true,"payable":false,"inputs":[],"name":"countFortunes","stateMutability":"view","type":"function"},{"outputs":[{"name":"fortune","type":"string"}],"constant":true,"payable":false,"inputs":[],"name":"drawFortune","stateMutability":"view","type":"function"},{"outputs":[{"name":"","type":"string"}],"constant":true,"payable":false,"inputs":[{"name":"","type":"uint256"}],"name":"fortunes","stateMutability":"view","type":"function"},{"inputs":[{"name":"author","type":"address","indexed":false},{"name":"fortune","type":"string","indexed":false}],"name":"FortuneAdded","anonymous":false,"type":"event"},{"payable":false,"inputs":[{"name":"initialFortune","type":"string"}],"stateMutability":"nonpayable","type":"constructor"}]
[info] ABI is now known for the contract at address '0x82ea8ab1e836272322f376a5f71d5a34a71688f1'
[success] Total time: 37 s, completed Dec 29, 2016 9:33:13 AM
sbt:eth-command-line> ethTransactionView 0x57d0dfa84161e565c9f9ba4aab24d6b22654cca1 sayHello
[info] The function 'sayHello' yields 1 result.
[info]  + Result 1 of type 'string' is "Hello, world!!!"
[success] Total time: 1 s, completed Feb 23, 2018 6:59:28 PM
```

## Tab completion is your friend.

If you try to type everything in, you will find this to be an annoyingly verbose
command line interface. `eth-command-line` tasks support <tab> completion *extensively*. **When in doubt, just hit <tab>
a few times in quick succession, and maybe things will get clearer.**

## RTFM

Please just see the [_sbt-ethereum_ docs](https://www.sbt-ethereum.io/).

