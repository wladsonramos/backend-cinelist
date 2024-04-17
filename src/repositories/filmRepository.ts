import { AppDataSource } from "../database/data-source";
import { Film } from "../entities/Film";

export const filmRepository = AppDataSource.getRepository(Film)