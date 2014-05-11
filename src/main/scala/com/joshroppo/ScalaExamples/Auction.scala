package com.joshroppo.auction

import scala._
import akka.actor._
import java.util.Date

abstract class AuctionMessage
case class Offer(bid: Int, client:Actor)    extends AuctionMessage
case class Inquire(client: Actor)           extends AuctionMessage

abstract class AuctionReply
case class Status(asked: Int, expire: String) extends AuctionReply
case object BestOffer                 extends AuctionReply
case class BeatenOffer(maxBid: Int)   extends AuctionReply
case class AuctionConcluded(seller: Actor, client: Actor)
                                            extends AuctionReply
case object AuctionFailed                   extends AuctionReply
case object AuctionOver                     extends AuctionReply

abstract class Auction(seller: Actor, minBid: Int, closing: Date) extends Actor{
    val timeToShutdown = 36000000
    val bidIncrement = 10

    /*
    def act(){
        var maxBid = minBid - bidIncrement
        var maxBidder: Actor = null
        var running = true
        while(running){
            receiveWithin(closing.getTime() - new Date().getTime()){
                case Offer(bid, client) =>
                    if(bid >= maxBid + bidIncrement){
                        if(maxBid >= minBid) maxBidder ! BeatenOffer(bid)
                        maxBid = bid;
                        maxBidder = client;
                        client ! BestOffer;
                    } else {
                        client ! BeatenOffer(maxBid)
                    }
                case Inquire(client) =>
                    client ! Status(maxBid, closing)
                case TIMEOUT =>
                    if(maxBid >= minBid){
                        val reply = AuctionConcluded(seller, maxBider)
                        maxBidder ! reply;
                        seller ! reply;
                    } else {
                        seller ! AuctionFailed;
                    }
                    receiveWithin(timeToShutdown){
                        case Offer(_, client) => client ! AuctionOver
                        case TIMEOUT => running = false
                    }
            }
        }
    }
    */
}
