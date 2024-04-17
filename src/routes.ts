import { Router } from 'express'
import { FilmController } from './controllers/FilmController';

const routes = Router();

routes.post('/films', new FilmController().create)

export default routes

