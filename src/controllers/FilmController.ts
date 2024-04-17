import { Request, Response } from "express";
import { filmRepository } from "../repositories/filmRepository";

export class FilmController {
    async create(req: Request, res: Response){
        const { title, description, watched_at} = req.body

        if(!title) {
            return res.status(400).json({message: 'O título é obrigatório'})
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
            return res.status(500).json({message: 'Internal server error'})
        }
    }

    async list(req: Request, res: Response) {
        try {
            const films = await filmRepository.find()

            return res.json(films)
        } catch (error) {
            console.log(error);
            return res.status(500).json({message: 'Internal server error'})
        }
    }

}