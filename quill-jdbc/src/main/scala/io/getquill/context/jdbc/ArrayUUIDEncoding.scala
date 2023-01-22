package io.getquill.context.jdbc

import java.util.UUID
import scala.collection.Factory

trait ArrayUUIDEncoding extends ArrayEncoders with ArrayDecoders {
  this: JdbcContextTypes[_, _] =>
  implicit def arrayUuidDecoder[Col <: Seq[UUID]](using bf: Factory[UUID, Col]): Decoder[Col] =
    arrayRawDecoder[UUID, Col]
  implicit def arrayUuidEncoder[Col <: Seq[UUID]]: Encoder[Col] = arrayRawEncoder[UUID, Col]("uuid")
}
