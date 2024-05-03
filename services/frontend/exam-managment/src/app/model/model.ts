export class UserRegistration {
  id!: number;  // The "!" is a non-null assertion operator.
  firstName!: string;
  lastName!: string;
  phoneNumber!: string;
  email!: string;
  gender!: string;
  userRole!: string;
  password!: string;
  }

  export class Category {
    id!: number;
    title!: string;
    description!: string;
  }

  export class Question{
     id!: number;
     content!:string;
     option1!:string;
     option2!:string;
     option3!:string;
     option4!:string;
     answer!:string;
  }
  export class ExamResponse{
    content!:string;
    option1!:string;
    option2!:string;
    option3!:string;
    option4!:string;
    answer!:string;
    givenAnswer!:string;
 }
 export class ExamResult{
      quizId!:number;
      userId!:string;
      noOfQuestions!:number;
      correctAnswer!:number;
 }
  export class Quiz{
    id!: number | null;  // Assuming `id` can be null if not set
    title!: string;
    description!: string;
    maxMarks!: string;
    numberOfQuestions!: number;
    active!: boolean;
    categoryDto: Category = new Category();
    questions!: Question[];
  }