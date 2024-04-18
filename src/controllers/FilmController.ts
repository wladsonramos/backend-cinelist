import { Request, Response } from "express";
import { filmRepository } from "../repositories/filmRepository";

export class FilmController {
    async create(req: Request, res: Response){
        const { title, description, watched_at} = req.body

        if(!title) {
            return res.status(400).json({ message: 'O título é obrigatório' })
        }

        try {
            const newFilm = filmRepository.create({
                title,
                description,
                watched_at
            })

            await filmRepository.save(newFilm)

           return res.status(201).json(newFilm)
        } catch (error) {
            console.log(error);
            return res.status(500).json({ message: 'Internal server error' })
        }
    }

    async list(req: Request, res: Response) {
        try {
            const films = await filmRepository.find()

            return res.json(films)
        } catch (error) {
            console.log(error);
            return res.status(500).json({ message: 'Internal server error' })
        }
    }

    async update(req: Request, res: Response) {
        const { id } = req.params;
        const { title, description, watched_at } = req.body;

        if (!id) {
            return res.status(400).json({ message: 'O ID do filme é obrigatório' });
        }

        try {
            const film = await filmRepository.findOne({where: {id}});

            if (!film) {
                return res.status(404).json({ message: 'Filme não encontrado' });
            }

            film.title = title ? title : film.title;
            film.description = description ? description : film.description;
            film.watched_at = watched_at ? watched_at : film.watched_at;

            await filmRepository.save(film);

            return res.json(film);           
        } catch (error) {
            console.log(error);
            return res.status(500).json({ message: 'Internal server error' });
        }
    }

    async delete(req: Request, res: Response) {
        const { id } = req.params;

        if (!id) {
            return res.status(400).json({ message: 'O ID do filme é obrigatório' });
        }

        try {
            const film = await filmRepository.findOne({  where: { id }});

            if (!film) {
                return res.status(404).json({ message: 'Filme não encontrado' });
            }

            await filmRepository.remove(film);
            
            return res.status(204).send();
        } catch (error) {
            console.log(error);
            return res.status(500).json({ message: 'Internal server error' });
        }
    }

}