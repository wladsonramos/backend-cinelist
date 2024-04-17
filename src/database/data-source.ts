import "reflect-metadata";
import { DataSource } from "typeorm";
import { CreateFilms1713347709651 } from './migrations/1713347709651-CreateFilms';
import { Film } from "../entities/Film";

export const AppDataSource = new DataSource({
    type: "postgres",
    host: "localhost",
    port: 5432,
    username: "postgres",
    password: "password",
    database: "cinelist",
    synchronize: true,
    logging: false,
    entities: [Film],
    subscribers: [],
    migrations: [CreateFilms1713347709651],
})