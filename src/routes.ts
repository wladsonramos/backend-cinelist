import { Router } from 'express'
import { FilmController } from './controllers/FilmController';

const routes = Router();

routes.post('/films', new FilmController().create)
routes.get('/films', new FilmController().list)
routes.put('/films/:id', new FilmController().update)
routes.delete('/films/:id', new FilmController().delete)

export default routes

