export class UserRegistration {
    id!: number;
    profileImage!: string;
    firstName!: string;
    lastName!: string;
    phoneNumber!: number;
    email!: string;
    dateOfBirth!: string; // ISO-8601 formatted date string (e.g., 'YYYY-MM-DD')
    gender: string = "Male";
    age!: number;
    address!: string;
    country!: string;
    state!: string;
    creditScore!: number;
    panCardNumber!: string;
    userRole: string = "CUSTOMER";
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
  export class Quiz{
    id!: number | null;  // Assuming `id` can be null if not set
    title!: string;
    description!: string;
    maxMarks!: string;
    numberOfQuestions!: number;
    active!: boolean;
    categoryDto!: Category;
    questions!: Question[];
  }