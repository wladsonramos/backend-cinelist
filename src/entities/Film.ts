import { Entity, Column, CreateDateColumn, PrimaryColumn} from "typeorm"
import { v4 as uuid } from "uuid"

@Entity("films")
export class Film {

    @PrimaryColumn()
    id: string;

    @Column()
    title: string;

    @Column()
    description: string;

    @CreateDateColumn()
    watched_at: Date;

    constructor() {
        if (!this.id) {
            this.id = uuid()
        }
    }
}