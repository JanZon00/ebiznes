package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  val products = Seq(
    Product(1, "Product 1", 10.99),
    Product(2, "Product 2", 20.49),
    Product(3, "Product 3", 5.99)
  )

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index(products))
  }
}

case class Product(id: Int, name: String, price: Double)